package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixedDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 어떤게 주입이 될지는 여기서 결정됨..
// imple 들은 의존관계에 대해  집중하지 않고 실행에만 집중한다.
// implements 입장에서는 의존관계를 외부에서 주입하는 것과 같다고 해서 ,,DI라고 한다.
// 따라서 DI를 하는 이유 : DIP를 지키기 위해

// refactoring 하면서 역할이 다 드러나는 장점을 가진다.
// 역할과 구현 클래스가 한눈에 들어온다.
@Configuration
public class AppConfig {
    @Bean
     public MemberService memberService() {
        return new MemberServiceImpl(MemberRepository());
    }
    @Bean
    public MemoryMemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
         return new OrderServiceImpl(MemberRepository(),DiscountPolicy()) ;
    }
    @Bean
    public DiscountPolicy DiscountPolicy() {
        // policy를 바꾸게 되더라도 이부분만 바꾸면 되는 장점이 있다.
        return new FixedDiscountPolicy();
    }

}
