package com.fc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@MapperScan("com.fc.dao")
public class BysjMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(BysjMasterApplication.class, args);
    }

}
