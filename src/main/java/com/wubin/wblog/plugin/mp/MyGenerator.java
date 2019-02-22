package com.wubin.wblog.plugin.mp;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @author wubin
 * @Description
 * @project w-blog
 * @package com.wubin.blog.wblog.plugin.mp
 * @email wubin326@qq.com
 * @date 2018/08/30
 */
public class MyGenerator {
    private static String[] tables = {"t_attach", "t_comments", "t_contents", "t_logs", "t_metas", "t_options", "t_relationships", "t_users"};
    private static boolean serviceNameStartWithI = false;//user -> UserService, 设置成true: user -> IUserService
    public static void main(String[] args) {
        String packageName = "com.wubin.blog.wblog";
        for (String table : tables
                ) {
            generateByTables(packageName, table);
        }
    }

    private static void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
        GlobalConfig config = new GlobalConfig();
        String dbUrl = "jdbc:mysql://localhost:3306/tale?useSSL=false&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&autoReconnect=true";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("123456")
                .setDriverName("com.mysql.jdbc.Driver");
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(true)
                .setEntityLombokModel(false)
                .setDbColumnUnderline(true)
                .setTablePrefix("t_")
                .setNaming(NamingStrategy.underline_to_camel)
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
        config.setActiveRecord(true)
                .setAuthor("wubin")
                .setOutputDir("/User/wufan/wubin/github/w-blog/src/main/java/com/wubin/blog/wblog/model")
                .setFileOverride(true);
        if (!serviceNameStartWithI) {
            config.setServiceName("%sService");
        }
        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent("")
                                .setController("controller")
                                .setEntity("entity")
                ).execute();
    }

    private static void generateByTables(String packageName, String... tableNames) {
        generateByTables(serviceNameStartWithI, packageName, tableNames);
    }
}
