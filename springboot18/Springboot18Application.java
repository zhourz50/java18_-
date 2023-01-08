package com.example.springboot18;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.example.springboot18.filter")
@MapperScan("com.example.**.dao")
public class Springboot18Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot18Application.class, args);
    }

}
