package com.gannan.court;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//spring boot 启动装置
//添加注解（@MapperScan）用于扫描Mapper
@MapperScan(value = "com.gannan.court.dao")
@SpringBootApplication
public class CourtApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourtApplication.class, args);
    }

}
