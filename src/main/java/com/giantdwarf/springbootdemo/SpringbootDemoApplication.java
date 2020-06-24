package com.giantdwarf.springbootdemo;

import com.giantdwarf.springbootdemo.springapp.SampleListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootDemoApplication {

    @GetMapping("/hello")
    public String hello(){
        return "hello spring";
    }

    public static void main(String[] args) {
        //        SpringApplication.run(SpringbootDemoApplication.class, args);
        SpringApplication app = new SpringApplication(SpringbootDemoApplication.class);
        app.addListeners(new SampleListener());
        app.run(args);
    }


}
