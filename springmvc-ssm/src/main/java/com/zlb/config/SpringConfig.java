package com.zlb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*
 spring相关配置
 Configuration:启动时自动扫描该配置文件
 ComponentScan("com.zlb.service")：告知spring框架去扫描该路径，并将该路径下符合条件的类注册为Bean
 PropertySource("classpath:jdbc.properties"):告知Spring从指定的属性文件中加载属性值，然后可以使用@Value注解将这些属性值注入到Bean的字段或方法参数中。
 Import({JdbcConfig.class, MybatisConfig.class})：告知Spring将这两个配置类整合到当前配置类，
 EnableTransactionManagement：开启事务管理
 */
@Configuration
@ComponentScan("com.zlb.service")
@PropertySource("classpath:jdbc.properties")
@Import({JdbcConfig.class, MybatisConfig.class})
@EnableTransactionManagement
public class SpringConfig {
}
