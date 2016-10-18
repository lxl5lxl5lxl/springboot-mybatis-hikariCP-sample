package com.lxl.sample.one;

import com.lxl.sample.one.dao.Mark;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackageClasses = Mark.class,sqlSessionFactoryRef="sqlSessionFactory")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
