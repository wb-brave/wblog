package com.wubin.wblog.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mysql.fabric.xmlrpc.base.Params;
import com.wubin.wblog.constant.WebConst;
import com.wubin.wblog.entity.Logs;
import com.wubin.wblog.entity.Users;
import com.wubin.wblog.exception.WblogException;
import com.wubin.wblog.model.bo.RestResponseBo;
import com.wubin.wblog.model.dto.LogActions;
import com.wubin.wblog.service.LogsService;
import com.wubin.wblog.service.UsersService;
import com.wubin.wblog.utils.WBlogUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wubin
 * @since 2019-02-17
 */
@Controller
@RequestMapping("/users")
public class UsersController extends BaseController {

    private static final Logger LOGGER = Logger.getLogger(UsersController.class.getName());

    @Autowired
    private UsersService usersService;
    @Autowired
    private LogsService logsService;

    @GetMapping(value = "/login")
    public String login(HttpServletRequest request) {
        return "login";
    }

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    @ResponseBody
    public RestResponseBo doLogin(@RequestParam String username,
                                  @RequestParam String password,
                                  @RequestParam(required = false) String remeber_me,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {

        /**
         * 从缓存中获取数据
         */
        Integer error_count = WBlogUtils.getLocalCache().get("login_error_count");
        System.out.println(username + " " + password);
        try {
            // EntityWrapper<Users> ew = new EntityWrapper<>();
            // Users user = usersService.selectOne(ew.eq("username",username).eq("password",password));
            /**
             * 在service层进行登录验证
             */
            Users user = usersService.login(username, password);
            /**
             * 将user存入session中
             */
            request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, user);
            if (StringUtils.isNotBlank(remeber_me)) {
                WBlogUtils.setCookie(response, user.getUid());
            }
            logsService.insertLog(LogActions.LOGIN.getAction(), null, request.getRemoteAddr(), user.getUid());
        } catch (Exception e) {
            error_count = null == error_count ? 1 : error_count + 1;
            if (error_count > 3) {
                return RestResponseBo.fail("您输入密码已经错误超过3次，请6秒后尝试");
            }
            WBlogUtils.getLocalCache().set("login_error_count", error_count, 1 * 6);
            String msg = "登录失败！";
            if (e instanceof WblogException) {
                msg = e.getMessage();
            } else {
                LOGGER.log(Level.SEVERE, msg, e);
            }
            return RestResponseBo.fail(msg);
        }
        // return RestResponseBo.fail("登录失败！");
        return RestResponseBo.ok();
    }

    @GetMapping(value = "/register")
    public String register(HttpServletRequest request) {
        return "register";
    }

    @PostMapping(value = "/doRegister")
    @Transactional
    //如果要返回数据请把这个加上谢谢
    @ResponseBody
    public RestResponseBo doRegister(@RequestParam(name = "username") String username,
                                     @RequestParam(name = "password") String password,
                                     @RequestParam(name = "email") String email,
                                     @RequestParam(name = "homeurl") String homeurl,
                                     @RequestParam(name = "screenname") String screenname,
                                     @RequestParam(name = "groupname") String groupName,
                                     @RequestParam(name = "remember_me", required = false) String remember_me,
                                     HttpServletRequest request
    ) {
        if (WBlogUtils.checkParams(username, password, email, homeurl, screenname, groupName)) {
            try {
                Users users = new Users(username, password, email, homeurl, screenname, groupName);
                usersService.doRegister(users);
                if (usersService.insert(users)) {
                    request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, users);
                    return RestResponseBo.ok();
                } else {
                    String err = "注册失败";
                    return RestResponseBo.fail(err);
                }
            } catch (Exception e) {
                String msg = "注册失败！";
                if (e instanceof WblogException) {
                    msg = e.getMessage();
                } else {
                    LOGGER.log(Level.SEVERE, msg, e);
                    return RestResponseBo.fail(msg);
                }
            }
        } else {
            return RestResponseBo.fail("参数不合法！");
        }
        return RestResponseBo.ok();
    }
}

