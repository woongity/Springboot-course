package hello.core.order;

import hello.core.AppConfig;
import hello.core.discount.FixedDiscountPolicy;
import hello.core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

public class OrderServiceTest {
//    OrderService orderService = new OrderServiceImpl(new MemoryMemberRepository(),new FixedDiscountPolicy());
//    MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void BeforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void order(){
        //given
        Long memberId= 1L;
        Member member = new Member(1L,"customerA", Grade.VIP);
        memberService.join(member);
        //when
        Order order = orderService.createOrder(memberId,"itemA",10000);
        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
