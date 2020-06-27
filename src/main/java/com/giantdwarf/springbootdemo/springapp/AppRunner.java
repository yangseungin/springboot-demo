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

    @Autowired
    public String hello;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("-------------");
        System.out.println("hello = " + hello);
        System.out.println("yangProperties = " + yangProperties.getName());
        System.out.println("yangProperties = " + yangProperties.getFullName());


    }
}
