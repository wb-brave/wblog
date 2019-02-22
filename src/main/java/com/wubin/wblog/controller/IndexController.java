package com.wubin.wblog.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wubin.wblog.constant.WebConst;
import com.wubin.wblog.entity.Contents;
import com.wubin.wblog.exception.WblogException;
import com.wubin.wblog.model.bo.RestResponseBo;
import com.wubin.wblog.service.ContentsService;
import com.wubin.wblog.utils.CountingGenerator;
import com.wubin.wblog.utils.LocalCache;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.expression.Lists;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @author wubin
 * @Description 前台页面
 * @project wblog
 * @package com.wubin.wblog.controller
 * @email wubin326@qq.com
 * @date 2019/01/22
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/22        wubin            0.0.1
 */
@Controller
public class IndexController extends BaseController {
    public static int count = 0;

    @Autowired
    private ContentsService contentsService;

    @RequestMapping(value = {"/", "/index"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String index(HttpServletRequest request, @RequestParam(name = "limit", defaultValue = "6") int limit) {
        return this.index(request, 1, limit);
    }

    /**
     * 首页分页
     *
     * @param request request
     * @param p       第几页
     * @param limit   每页大小
     * @return 主页
     */
    @GetMapping(value = "page/{p}")
    public String index(HttpServletRequest request, @PathVariable int p, @RequestParam(value = "limit", defaultValue = "6") int limit) {
        p = p < 0 || p > WebConst.MAX_PAGE ? 1 : p;
        /**
         * 设置分页插件的属性
         */
        Page<Contents> contentsPage = new Page<>(p, limit);
        /**
         * 设置查询的条件
         */
        EntityWrapper<Contents> ew = new EntityWrapper<>();
        /**
         * 开始分页查询
         */
        Page<Contents> articles = contentsService.selectPage(contentsPage);
        /**
         * 设置文章属性，便于前端获取数据设置页面
         * 由于mybatis-plus2.*的分页插件不支持总页数的list类型
         * 再次转换
         */
        ArrayList<Long> pages = new ArrayList<>();
        //控制页码从第几行开始 i=p
        for (long i = p; i < contentsPage.getPages(); i++) {
            pages.add(i);
        }
        request.setAttribute("articles", articles);
        request.setAttribute("pages", pages);
        request.setAttribute("pageInfo", contentsPage);
        this.title(request, "第 " + p + " 页");
        return "/index";
    }

    /**
     * 设置页面主题，不完善
     *
     * @param request
     * @param theme
     * @return
     */
    @PostMapping("/changeTheme")
    @ResponseBody
    public String changeTheme(HttpServletRequest request, String theme) {
        String myTheme = String.format("hold-transition %s sidebar-mini", theme);
        request.setAttribute("myTheme", myTheme);
        request.getSession().setAttribute("myTheme", myTheme);
        HashMap<String, String> map = new HashMap<>();
        map.put("result", "success");
        return "index";
    }

    @RequestMapping(value = "/llogin", method = {RequestMethod.POST, RequestMethod.GET})
    public String login(HttpServletRequest request) {
        System.out.println("进来 " + ++count + " 次了");
        return "login";
    }

    @GetMapping("/register")
    public String register(HttpServletRequest request) {
        Random random = new Random(47);
        // request.setAttribute("pic",random.nextInt(5)+);
        return "register";
    }

    protected LocalCache cache = LocalCache.single();

    // @PostMapping
    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    @ResponseBody
    public RestResponseBo doLogin(@RequestParam String username,
                                  @RequestParam String password,
                                  @RequestParam(required = false) String remeber_me,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {

        Integer error_count = cache.get("login_error_count");
        System.out.println(username + " " + password);
        try {
            // UserVo user = usersService.login(username, password);
            request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, "wubin");
            if (StringUtils.isNotBlank(remeber_me)) {
                // TaleUtils.setCookie(response, user.getUid());
            }
            // logService.insertLog(LogActions.LOGIN.getAction(), null, request.getRemoteAddr(), user.getUid());
        } catch (Exception e) {
            error_count = null == error_count ? 1 : error_count + 1;
            if (error_count > 3) {
                return RestResponseBo.fail("您输入密码已经错误超过3次，请10分钟后尝试");
            }
            cache.set("login_error_count", error_count, 10 * 60);
            String msg = "登录失败";
            if (e instanceof WblogException) {
                msg = e.getMessage();
            } else {
                // LOGGER.error(msg, e);
            }
            return RestResponseBo.fail(msg);
        }
        return RestResponseBo.fail("登录失败！");
        // return RestResponseBo.ok();
    }
}
