package com.giantdwarf.springbootdemo.springapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    @Value("${yang.fullName}")
    private String name;

    @Value("${yang.age}")
    private int age;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("-------------");
        System.out.println("name = " + name);
        System.out.println("age = " + age);

    }
}
