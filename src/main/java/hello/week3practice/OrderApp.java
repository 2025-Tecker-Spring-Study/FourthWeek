package hello.week3practice;

import hello.week3practice.member.Grade;
import hello.week3practice.member.Member;
import hello.week3practice.member.MemberService;
import hello.week3practice.order.Order;
import hello.week3practice.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        Member member1 = new Member(1L,"memberA", Grade.VIP);
        Member member2 = new Member(2L,"memberB",Grade.BASIC);
        memberService.signUp(member1);
        memberService.signUp(member2);
        Order order1 = orderService.createOrder(member1.getId(),"itemA",10000);
        Order order2 = orderService.createOrder(member2.getId(),"itemB", 20000);
        System.out.println(order1);
        System.out.println(order2);
    }
}
