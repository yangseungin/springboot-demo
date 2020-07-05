package com.giantdwarf.springbootdemo.exception;

public class TestException extends RuntimeException {
    public TestException() {
        super();
    }

    public TestException(String message) {
        super(message);
    }
}
