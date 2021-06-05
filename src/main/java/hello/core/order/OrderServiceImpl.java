package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixedDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;

import javax.sql.DataSource;

public class OrderServiceImpl implements OrderService{
    // 회원조회, 할인 적용
    final MemberRepository memberRepository;
//    DiscountPolicy discountPolicy = new FixedDiscountPolicy() ;
    // 이런식으로 설정하면, 마치 너무 많은 책임을 가지는 것이라고 생각할 수 있다. DIP에 따라서 단일 책임 원칙을 지켜야하지만, 현재 지키지 못하고 있다고 할 수 있다.
    // 관심사의 분리가 중요하다.
    final DiscountPolicy discountPolicy ;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //    DiscountPolicy discountPolicy =
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //    public Order(Long memberId, String itemName, int itemPrice, int discountPrice) {
        Member member= memberRepository.findById(memberId);
        // 이부분이 단일책임원칙을 매우 잘지켰다고 볼수 있음
        int discountedPrice = discountPolicy.discount(member,itemPrice);
        Order order = new Order(memberId,itemName,itemPrice,discountedPrice);
        return order;
    }

    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
