package com.tv.springbootwork;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tv.springbootwork.mapper")
public class SpringBootWorkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWorkApplication.class, args);
    }

}
