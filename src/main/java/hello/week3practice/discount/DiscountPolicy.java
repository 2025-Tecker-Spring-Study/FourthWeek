package hello.week3practice.discount;

import hello.week3practice.member.Member;

public interface DiscountPolicy {
    int discount_policy(Member member, int item_price);
}
