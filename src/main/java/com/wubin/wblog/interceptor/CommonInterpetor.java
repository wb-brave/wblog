package com.wubin.wblog.interceptor;

import com.wubin.wblog.utils.Commons;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wubin
 * @Description 定义一些公共的工具类拦截器
 * @project wblog
 * @package com.wubin.wblog.interceptor
 * @email wubin326@qq.com
 * @date 2019/02/15
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/02/15        wubin            0.0.1
 */
@Component
public class CommonInterpetor implements HandlerInterceptor{

    @Resource
    private Commons commons;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        /**
         * 在控制器执行完后，想httpServletRequest中添加属性--自定义的一些工具方法
         */
        httpServletRequest.setAttribute("commons", commons);
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
