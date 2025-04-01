package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy disscountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = disscountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); //회원정보 조회
        int discountPrice = discountPolicy.discount(member, itemPrice); //할인 정책에 회원을 넘기고 할인된 가격을 받음, 멤버도 같이 넘길지 말지는 우리의 선택
        //설계를 잘한 이유: 할인에 대한건 discountPolicy여기에 다 맡김 할인에 대한 변경이 필요하면 할인만 변경하면 됨

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }


}
