package hello.week3practice.member;

import hello.week3practice.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

    @Test
    void saveAndFind(){
        Member member = new Member(1L,"woomin",Grade.VIP);
        memberRepository.save(member);
        Assertions.assertEquals(member,memberRepository.findById(1L));
    }
    @Test
    void clear(){
        Member member = new Member(1L,"woomin",Grade.VIP);
        memberRepository.save(member);
        memberRepository.clear();
        assertNull(memberRepository.findById(1L));
    }
}