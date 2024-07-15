package com.zlb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/*
 Configuration：启动时自动扫描该配置文件
 ComponentScan({"com.zlb.controller","com.zlb.config"})：告知spring框架去扫描该路径，并将该路径下符合条件的类注册为Bean
 EnableWebMvc：启用SpringMVC框架的关键功能，以支持基于注解的控制器、视图解析、静态资源处理、数据绑定等特性。
 */
@Configuration
@ComponentScan({"com.zlb.controller", "com.zlb.config"})
@EnableWebMvc
public class SpringMvcConfig {
}
