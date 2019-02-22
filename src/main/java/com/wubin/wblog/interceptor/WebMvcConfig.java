package com.wubin.wblog.interceptor;


// import com.my.blog.website.utils.TaleUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.*;

import javax.annotation.Resource;

/**
 * @author wubin
 * @Description 向mvc中添加自定义组件
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
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Resource
    private CommonInterpetor baseInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(baseInterceptor);
    }

    /**
     * 添加静态资源文件，外部可以直接访问地址
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // registry.addResourceHandler("/upload/**").addResourceLocations("file:"+ TaleUtils.getUploadFilePath()+"upload/");

        super.addResourceHandlers(registry);
    }
}
