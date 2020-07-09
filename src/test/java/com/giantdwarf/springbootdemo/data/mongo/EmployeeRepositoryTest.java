package com.giantdwarf.springbootdemo.data.mongo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void findByEmail(){
        Employee employee = new Employee();
        employee.setEmail("rhfpdk123@gmail.com");
        employee.setId("dwarf");
        employee.setUsername("yangseungin");

        employeeRepository.save(employee);

        Optional<Employee> byId = employeeRepository.findById(employee.getId());
        assertThat(byId).isNotEmpty();

        employeeRepository.findByUsername(employee.getUsername());

        Optional<Employee> byEmail = employeeRepository.findByEmail(employee.getEmail());
        assertThat(byEmail).isNotEmpty();
        assertThat(byEmail.get().getUsername()).isEqualTo("yangseungin");

    }

}