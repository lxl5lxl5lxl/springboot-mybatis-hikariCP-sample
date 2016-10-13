package com.lxl.sample.muti.configuration;

import com.lxl.sample.muti.dao.db2.Mark;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
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
@MapperScan(basePackageClasses = Mark.class ,sqlSessionFactoryRef = "ds2SqlSessionFactory")
public class DataSource2Configuration {
    @Bean(name = "dsp2")
    @ConfigurationProperties(prefix = "datasource.ds2")
    public DataSourceProperties dsp2(){
        return new DataSourceProperties();
    }

    @Bean(name = "ds2")
    @ConfigurationProperties(prefix = "datasource.ds2.hikari")
    public DataSource ds2() {
        return dsp2().initializeDataSourceBuilder().build();
    }

    @Bean(name = "ds2TransactionManager")
    public PlatformTransactionManager ds2TransactionManager() {
        return new DataSourceTransactionManager(ds2());
    }

    @Bean(name = "ds2SqlSessionFactory")
    public SqlSessionFactory ds2SqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(ds2());
        return sessionFactory.getObject();
    }
}
