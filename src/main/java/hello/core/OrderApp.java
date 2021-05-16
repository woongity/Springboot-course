package hello.core;

import hello.core.discount.FixedDiscountPolicy;
import hello.core.member.*;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class  OrderApp {
    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());
//        OrderService orderService = new OrderServiceImpl(new MemoryMemberRepository(),new FixedDiscountPolicy());
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
        Long memberId = 1L;
        Member member = new Member(memberId,"CustomerA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId,"icecream",10000);
        System.out.println(order);
        System.out.println(order.calculatedPrice());
    }
}
