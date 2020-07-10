package com.giantdwarf.springbootdemo.data;

import com.giantdwarf.springbootdemo.data.neo4j.Person;
import com.giantdwarf.springbootdemo.data.neo4j.PersonRepository;
import com.giantdwarf.springbootdemo.data.neo4j.Role;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class Neo4jRunner implements ApplicationRunner {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    PersonRepository personRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Person person = new Person();
        person.setEmail("admin@gmail.com");
        person.setUsername("adminaccount");

        Role role =new Role();
        role.setName("admin");
        person.getRoles().add(role);

//        Session session = sessionFactory.openSession();
//        session.save(person);
//        sessionFactory.close();

        personRepository.save(person);

        System.out.println("finish");

    }
}
