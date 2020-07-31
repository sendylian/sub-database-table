package com.sendy.subdt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.sendy.subdt.dao")
public class SubDatabaseTableApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubDatabaseTableApplication.class, args);
    }

}
