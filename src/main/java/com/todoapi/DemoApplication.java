package com.todoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo", "com.todoapi"})
public class DemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("loaded ");
//        SpringApplication.run(TodoApiApplication.class, args);

    }

}
