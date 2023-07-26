package com.ohgiraffers.forepeproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ForepeApplication {
    public static void main(String[] args) {
        SpringApplication.run(ForepeApplication.class, args); 
    }
}
