package com.isoft.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.isoft.demo.dao"})
@ComponentScan(basePackages = {"com.isoft.demo.service"})
@ComponentScan(basePackages = {"com.isoft.demo.controller"})

public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
