package hello.week3practice;

import hello.week3practice.discount.DiscountPolicy;
import hello.week3practice.discount.RateDiscountPolicy;
import hello.week3practice.member.MemberRepository;
import hello.week3practice.member.MemberService;
import hello.week3practice.member.MemberServiceImpl;
import hello.week3practice.member.MemoryMemberRepository;
import hello.week3practice.order.OrderService;
import hello.week3practice.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService(MemberRepository memberRepository){
        return new MemberServiceImpl(memberRepository);
    }
    @Bean
    public OrderService orderService(MemberService memberService, DiscountPolicy discountPolicy){
        return new OrderServiceImpl(memberService, discountPolicy);
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
