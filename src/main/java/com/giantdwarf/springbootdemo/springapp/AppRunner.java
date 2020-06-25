package com.giantdwarf.springbootdemo.springapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    YangProperties yangProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("-------------");
        System.out.println("name = " + yangProperties.getName());
        System.out.println("age = " + yangProperties.getAge());
        System.out.println("yangProperties = " + yangProperties.getSessionTimeout());

    }
}
