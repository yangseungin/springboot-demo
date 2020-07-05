package com.giantdwarf.springbootdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ExceptionController {
    @GetMapping("/exception")
    public String exception(){
        throw new TestException("알수없는 에러 발생");
    }
    @ExceptionHandler(TestException.class)
    public ResponseEntity sampleError(TestException e){
        ErrorData error = new ErrorData();
        error.setCode("ERROR_UNKNOWN");
        error.setMessage(e.getMessage());

        return ResponseEntity.status(HttpStatus.OK).body(error);
    }
}
