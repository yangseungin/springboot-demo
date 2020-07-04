package com.giantdwarf.springbootdemo.testing;

import com.giantdwarf.springbootdemo.mvc.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class SampleController {

    Logger logger = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    private SampleService sampleService;

    @GetMapping("/hello")
    public @ResponseBody String hello(){
        logger.info("yang");
        System.out.println("skip");
        return "hello "+sampleService.getName();
    }

    @GetMapping("/hello3")
    public String hello3(Model model){
        User user = new User();
        user.setId(1L);
        user.setPassword("1234");
        user.setUsername("seungin");
        User user2 = new User();
        user2.setId(2L);
        user2.setPassword("1234");
        user2.setUsername("star");
        List<User> users = List.of(user,user2);
        model.addAttribute("name","seungin");
        model.addAttribute(user);
        model.addAttribute("users",users);

        return "hello3";
    }
}
