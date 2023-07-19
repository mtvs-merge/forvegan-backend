package com.ohgiraffers.forepeproject.config;

//import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.ohgiraffers.forepeproject")
public class BeanConfiguration {

    public BeanConfiguration() {}

//    @Bean
//    public ModelMapper modelMapper() {
//
//        return new ModelMapper();
//    }
}
