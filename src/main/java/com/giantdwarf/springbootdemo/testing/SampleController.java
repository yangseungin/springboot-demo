package com.giantdwarf.springbootdemo.testing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    Logger logger = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    private SampleService sampleService;

    @GetMapping("/hello")
    public String hello(){
        logger.info("yang");
        System.out.println("skip");
        return "hello "+sampleService.getName();
    }
}
