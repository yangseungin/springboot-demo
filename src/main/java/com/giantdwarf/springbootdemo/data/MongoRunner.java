package com.giantdwarf.springbootdemo.data;

import com.giantdwarf.springbootdemo.data.mongo.Employee;
import com.giantdwarf.springbootdemo.data.mongo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

//@Component
public class MongoRunner implements ApplicationRunner {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Employee employee = new Employee();
        employee.setEmail("rhfpdk92@naver.com");
        employee.setId("giant");
        employee.setUsername("seungin");

//        mongoTemplate.insert(employee);
        System.out.println("finished");

        Employee employee2 = new Employee();
        employee2.setEmail("rhfpdk12@gmail.com");
        employee2.setId("dwarf");
        employee2.setUsername("yangseungin");

        employeeRepository.insert(employee2);
    }
}
