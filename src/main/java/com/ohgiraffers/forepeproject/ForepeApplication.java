package com.ohgiraffers.forepeproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ohgiraffers.forepeproject.member.query.domain.repository")
public class ForepeApplication {
    public static void main(String[] args) {
        SpringApplication.run(ForepeApplication.class, args); 
    }
}
