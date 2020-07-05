package com.giantdwarf.springbootdemo.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExceptionController {
    @GetMapping("/exception")
    public String exception(){
        throw new TestException();
    }
    @ExceptionHandler(TestException.class)
    public @ResponseBody
    AppError sampleError(TestException e){
        AppError appError = new AppError();
        appError.setMessage("error.unknown");
        appError.setReason("Unknown cause");
        return appError;
    }
}
