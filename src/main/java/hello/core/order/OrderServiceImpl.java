package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

// lombok이 그냥 생성자 만들어준다
//@RequiredArgsConstructor
@Component
public class OrderServiceImpl implements OrderService{
    // 회원조회, 할인 적용
    private final MemberRepository memberRepository;
//    DiscountPolicy discountPolicy = new FixedDiscountPolicy() ;
    // 이런식으로 설정하면, 마치 너무 많은 책임을 가지는 것이라고 생각할 수 있다. DIP에 따라서 단일 책임 원칙을 지켜야하지만, 현재 지키지 못하고 있다고 할 수 있다.
    // 관심사의 분리가 중요하다.
    // autowired 매칭할때 bean이 중복된다면? 이름을 보고 판단한다.
    private final DiscountPolicy discountPolicy ;
//    @Autowired
    // 생성자가 하나이므로 autowired를 지워도 동일
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
        //만약에 di가 안된다면 null로 찍힐것.
        System.out.println("memberRepository = " + memberRepository);
        System.out.println("discountPolicy = " + discountPolicy);
    }

    // 이런식으로 setter를 이용한 DI도 가능하다.
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository){
//        System.out.println("memberRepository = " + memberRepository);
//        this.memberRepository = memberRepository;
//    }
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy){
//        System.out.println("discountPolicy = " + discountPolicy);
//        this.discountPolicy = discountPolicy;
//    }

    // 이런식으로 아무런 함수에다가도 autowired를 통해 DI가 가능하다.
//


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
