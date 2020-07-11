package com.giantdwarf.springbootdemo.springapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class AppRunner implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(AppRunner.class);

    @Autowired
    YangProperties yangProperties;

    @Autowired
    public String hello;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.debug("-------------");
        logger.debug("hello = " + hello);
        logger.debug("yangProperties = " + yangProperties.getName());
        logger.debug("yangProperties = " + yangProperties.getFullName());


    }
}
