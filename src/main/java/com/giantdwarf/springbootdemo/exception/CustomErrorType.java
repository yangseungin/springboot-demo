package com.giantdwarf.springbootdemo.exception;

public class CustomErrorType {
    private int value;
    private String message;

    public CustomErrorType(int value, String message) {
        this.value = value;
        this.message = message;
    }
}
