package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

// 어떤게 주입이 될지는 여기서 결정됨..
// imple 들은 의존관계에 대해  집중하지 않고 실행에만 집중한다.
// implements 입장에서는 의존관계를 외부에서 주입하는 것과 같다고 해서 ,,DI라고 한다.
// 따라서 DI를 하는 이유 : DIP를 지키기 위해
public class AppConfig {
     public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }
    public OrderService orderService(){
         return new OrderServiceImpl(new MemoryMemberRepository(), new RateDiscountPolicy()) ;
    }
}
