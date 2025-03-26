package hello.week3practice.order;

import hello.week3practice.discount.DiscountPolicy;
import hello.week3practice.member.Member;
import hello.week3practice.member.MemberService;

public class OrderServiceImpl implements OrderService{
    MemberService memberService;
    DiscountPolicy discountPolicy;
    public OrderServiceImpl(MemberService memberService, DiscountPolicy discountPolicy){
        this.memberService = memberService;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(long member_id, String item_name, int item_price) {
        Member member = memberService.findMember(member_id);
        int discount_price = discountPolicy.discount_policy(member, item_price);
        return new Order(member_id,item_name,item_price, discount_price);
    }
}
