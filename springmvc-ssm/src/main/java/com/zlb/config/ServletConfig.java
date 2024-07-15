package com.zlb.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
//
public class ServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 指定了Spring应用上下文的配置类
     * @return 包含应用程序中的bean定义，数据源配置等。
     */
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    /**
     *指定了Spring MVC应用上下文的配置类
     * @return 包含Web组件（如控制器、视图解析器等）的定义。
     */
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }
    /**
     *指定了可访问路径
     * @return 指定了可访问的路径（"/"表示全路径）。
     */
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 用于配置Servlet的过滤器
     * @return  CharacterEncodingFilter 实例，并设置编码为UTF-8。
     */
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        return new Filter[]{filter};
    }
}
