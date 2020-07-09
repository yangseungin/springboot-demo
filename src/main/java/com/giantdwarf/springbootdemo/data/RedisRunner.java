package com.giantdwarf.springbootdemo.data;

import com.giantdwarf.springbootdemo.data.redis.Member;
import com.giantdwarf.springbootdemo.data.redis.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Optional;

//@Component
public class RedisRunner implements ApplicationRunner {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    MemberRepository memberRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ValueOperations<String, String> values = redisTemplate.opsForValue();
        values.set("seungin","giant");
        values.set("springboot","2.3.1");
        values.set("spring","nice");

        Member member = new Member();
        member.setId("giant");
        member.setUsername("seungin");
        member.setEmail("rhfpdk92@naver.com");

        memberRepository.save(member);

        Optional<Member> byId = memberRepository.findById(member.getId());

        System.out.println("byId = " + byId.get().getEmail());
        System.out.println("byId = " + byId.get().getUsername());

    }
}
