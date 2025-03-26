package hello.week3practice.member;

import hello.week3practice.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    MemberService memberService = ac.getBean("memberService",MemberService.class);
    @BeforeEach
    void beforeEach(){
        memberService.clearDB();
    }
    @Test
    void signUpAndFind(){
        Member member = new Member(1L,"woomin",Grade.VIP);
        memberService.signUp(member);
        assertEquals(member,memberService.findMember(1L));
    }
    @Test
    void clearTest(){
        Member member = new Member(1L,"woomin",Grade.VIP);
        memberService.signUp(member);
        memberService.clearDB();
        assertNull(memberService.findMember(1L));
    }
}