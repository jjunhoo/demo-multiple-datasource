package com.example.demomultipledatasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.demomultipledatasource.mapper")
public class DemoMultiplDatasourceApplication {

    public static void main(String[] args) {
        System.out.println("[KJH] INIT");
        SpringApplication.run(DemoMultiplDatasourceApplication.class, args);
    }

}
