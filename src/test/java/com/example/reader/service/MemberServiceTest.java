package com.example.reader.service;

import com.example.reader.entity.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MemberServiceTest {
    @Resource
    private MemberService memberService;
    @Test
    public void createMember1(){
        Member member = memberService.createMember("test1","123456","name");
        System.out.println(member);
    }
    @Test
    public void createMember2(){
        Member member = memberService.createMember("test2","123456","name");
        System.out.println(member);
    }

    @Test
    public void checkLogin1() {
        Member member = memberService.checkLogin("admin", "admin");
        System.out.println(member);
    }

    @Test
    public void checkLogin2() {
        Member member = memberService.checkLogin("test2", "123456");
        System.out.println(member);
    }

    @Test
    public void checkLogin3() {
        Member member = memberService.checkLogin("test3" +
                "test3", "1234561");
        System.out.println(member);
    }
}