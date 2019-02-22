package com.wubin.wblog.controller;

import com.wubin.wblog.entity.Users;
import com.wubin.wblog.utils.LocalCache;
import com.wubin.wblog.utils.WBlogUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wubin
 * @Description
 * @project sell
 * @package com.wubin.wblog.controller
 * @email wubin326@qq.com
 * @date 2019/02/18
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/02/18        wubin            0.0.1
 */

public abstract class BaseController {

    // public static String THEME = "themes/default";

    // protected LocalCache cache = LocalCache.single();

    /**
     * 主页的页面主题
     * @param viewName
     * @return
     */
    // public String render(String viewName) {
    //     return THEME + "/" + viewName;
    // }

    public BaseController title(HttpServletRequest request, String title) {
        request.setAttribute("title", title);
        return this;
    }

    public BaseController keywords(HttpServletRequest request, String keywords) {
        request.setAttribute("keywords", keywords);
        return this;
    }

    /**
     * 获取请求绑定的登录对象
     * @param request
     * @return
     */
    public Users user(HttpServletRequest request) {
        return WBlogUtils.getLoginUser(request);
    }

    public Integer getUid(HttpServletRequest request){
        return this.user(request).getUid();
    }

    public String render_404() {
        return "comm/error_404";
    }

}
