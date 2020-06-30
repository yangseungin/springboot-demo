package com.giantdwarf.springbootdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableWebMvc // 붙이면 스프링부트가 제공하는 mvc관련된 설정이 다 사라짐
public class WebConfig implements WebMvcConfigurer {
    //WebMvcConfigurer가 제공하는 callback 메서드를 사용하여 설정
}
