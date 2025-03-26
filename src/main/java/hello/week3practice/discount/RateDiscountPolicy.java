package hello.week3practice.discount;

import hello.week3practice.member.Grade;
import hello.week3practice.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{
    private int discount_percent = 10;
    @Override
    public int discount_policy(Member member, int item_price) {
        if (member.getGrade() == Grade.VIP){
            return item_price * discount_percent / 100;
        }
        return 0;
    }
}
