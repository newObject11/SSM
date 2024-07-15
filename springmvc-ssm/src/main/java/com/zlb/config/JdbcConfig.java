package com.zlb.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * jdbc相关配置类
 */
public class JdbcConfig {
    //通过@Value注解注入属性值
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String psw;
    @Value("${jdbc.url}")
    private String url;

    /**
     * 通过DruidDataSource（阿里巴巴开源的数据库连接池实现）来创建数据源dataSource，并将该数据源返回作为spring容器中的Bean
     *
     * @return 数据源 作为spring容器中的Bean
     */
    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(psw);
        dataSource.setUrl(url);
        return dataSource;
    }

    /**
     * @param dataSource 创建事务管理器，将dataSource作为需要管理的数据源
     * @return 事务管理器 作为spring容器中的Bean
     */
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        DataSourceTransactionManager ds = new DataSourceTransactionManager();
        ds.setDataSource(dataSource);
        return ds;
    }
}
