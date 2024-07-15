package com.zlb.config;


import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * Mybatis配置类，通过使用MyBatis进行数据库操作
 */
public class MybatisConfig {
    /**
     * @param dataSource 将传入的 DataSource 参数设置到 SqlSessionFactoryBean 中，以便 SqlSessionFactoryBean 能够与特定的数据源关联。
     * @return 返回factoryBean作为spring容器的Bean
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        //将指定包下的类注册为别名，以便在MyBatis映射文件中使用简单类名代替全限定类名。
        factoryBean.setTypeAliasesPackage("com.zlb.pojo");
        return factoryBean;
    }

    /**
     * 扫描指定路径下的mapper接口（即"com.zlb.mapper"下的BookMapper接口）将其注册为 Spring容器中的Bean。
     *
     * @return MapperScannerConfigurer实例作为Spring容器中的Bean。
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        //使用 setBasePackage 方法设置Mapper接口所在的包路径，以便 MapperScannerConfigurer 能够扫描到这些Mapper接口。
        msc.setBasePackage("com.zlb.mapper");
        return msc;
    }
}
