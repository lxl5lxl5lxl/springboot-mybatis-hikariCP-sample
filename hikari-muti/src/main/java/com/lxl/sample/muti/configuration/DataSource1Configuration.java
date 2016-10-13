package com.lxl.sample.muti.configuration;

import com.lxl.sample.muti.dao.db1.Mark;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Created by lxl on 16/10/10.
 */
@Configuration
@MapperScan(basePackageClasses = Mark.class ,sqlSessionFactoryRef = "ds1SqlSessionFactory")
public class DataSource1Configuration {

    @Bean(name = "dsp1")
    @ConfigurationProperties(prefix = "datasource.ds1")
    public DataSourceProperties dsp1(){
        return new DataSourceProperties();
    }

    @Bean(name = "ds1")
    @Primary
    @ConfigurationProperties(prefix = "datasource.ds1.hikari")
    public DataSource ds1() {
        return dsp1().initializeDataSourceBuilder().build();
    }

    @Bean(name = "ds1TransactionManager")
    @Primary
    public PlatformTransactionManager ds1TransactionManager() {
        return new DataSourceTransactionManager(ds1());
    }

    @Bean(name = "ds1SqlSessionFactory")
    @Primary
    public SqlSessionFactory ds1SqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(ds1());
        return sessionFactory.getObject();
    }
}
