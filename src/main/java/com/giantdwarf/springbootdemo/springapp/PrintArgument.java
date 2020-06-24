package com.giantdwarf.springbootdemo.springapp;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

//@Component
public class PrintArgument {

    public PrintArgument(ApplicationArguments arguments) {
        System.out.println("vm:foo:"+arguments.containsOption("foo"));
        System.out.println("pro- bar:"+arguments.containsOption("bar"));

    }
}
