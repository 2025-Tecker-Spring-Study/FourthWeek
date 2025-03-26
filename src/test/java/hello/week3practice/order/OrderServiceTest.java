package hello.week3practice.order;

import hello.week3practice.AppConfig;
import hello.week3practice.member.Grade;
import hello.week3practice.member.Member;
import hello.week3practice.member.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    OrderService orderService = ac.getBean("orderService",OrderService.class);
    MemberService memberService;
    @BeforeEach
    void beforeEach(){
        memberService = ac.getBean("memberService", MemberService.class);
        memberService.clearDB();
    }
    @Test
    void 주문생성(){
        Member member1 = new Member(1L,"memberA", Grade.VIP);
        memberService.signUp(member1);
        Order order1 = orderService.createOrder(member1.getId(),"itemA",10000);
        Assertions.assertEquals(order1.getItem_price(), 10000);
    }
}