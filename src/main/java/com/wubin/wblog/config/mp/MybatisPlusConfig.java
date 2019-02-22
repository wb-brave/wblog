package com.wubin.wblog.config.mp;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wubin
 * @Description
 * @project w-blog
 * @package com.wubin.blog.wblog.config.mp
 * @email wubin326@qq.com
 * @date 2018/08/29
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * @author wubin
     * @date 2018-08-29 23:02
     * @param null
     * @description plus 的性能优化
     * @return 
     * @throws 
     * @since 
    */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        /*<!-- SQL 执行性能分析，开发环境使用，线上不推荐。 maxTime 指的是 sql 最大执行时长 -->*/
        performanceInterceptor.setMaxTime(1000);
        /*<!--SQL是否格式化 默认false-->*/
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }

    /**
     * @author wubin
     * @date 2018-08-29 23:01
     * @param null
     * @description mybatis-plus分页插件
     * @return 
     * @throws 
     * @since 
    */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType("mysql");
        return paginationInterceptor;
    }

    /**
     * @author wubin
     * @date 2018-08-29 23:04
     * @param null
     * @description 注入druid的支持
     * @return 
     * @throws 
     * @since 
    */
//    @Resource(name = "dataSource")
//    public DataSource dataSource;
}
