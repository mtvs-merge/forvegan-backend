package com.ohgiraffers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@ComponentScan(basePackages = "com.ohgiraffers.forepeproject")
@SpringBootApplication
@EnableJpaAuditing
public class ForepeApplication {
    public static void main(String[] args) {
        SpringApplication.run(ForepeApplication.class, args); 
    }
}
