package com.giantdwarf.springbootdemo.data.redis;

import org.springframework.data.repository.CrudRepository;


public interface MemberRepository extends CrudRepository<Member, String> {
}
