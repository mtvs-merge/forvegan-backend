package com.ohgiraffers.forepeproject.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.ohgiraffers.forepeproject")
@EnableJpaRepositories(basePackages = "com.ohgiraffers.forepeproject")
public class JPAConfiguration {
}
