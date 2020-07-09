package com.giantdwarf.springbootdemo.data.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EmployeeRepository extends MongoRepository<Employee,String> {
    Optional<Employee> findByEmail(String email);

    Optional<Employee> findByUsername(String username);
}
