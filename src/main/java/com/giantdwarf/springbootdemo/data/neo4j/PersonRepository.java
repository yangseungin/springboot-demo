package com.giantdwarf.springbootdemo.data.neo4j;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PersonRepository extends Neo4jRepository<Person,Long> {
}
