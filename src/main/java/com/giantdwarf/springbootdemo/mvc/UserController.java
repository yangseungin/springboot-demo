package com.giantdwarf.springbootdemo.mvc;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @GetMapping("/hello2")
    public String hello(){
        return "hello2";
    }

    @PostMapping("/users/create")
    public @ResponseBody User create(@RequestBody User user){
        //@RestController가 있으면 @ResponseBody 생략하여도 converter사용가능
        return user;
    }
}
