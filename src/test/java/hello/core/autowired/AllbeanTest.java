package hello.core.autowired;

import hello.core.AutoAppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixedDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class AllbeanTest {
    @Test
    void findAllBean(){
        // 여기서 생성된 모든 bean을 조회함.
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class,DiscountService.class);
        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L,"andy", Grade.VIP);
        int fixDiscountPolicy = discountService.discount(member,10000, "fixedDiscountPolicy");
        Assertions.assertThat(discountService).isInstanceOf(DiscountService.class);
        Assertions.assertThat(fixDiscountPolicy).isEqualTo(1000);

        int rateDiscountedPrice = discountService.discount(member,20000, "rateDiscountPolicy");
        Assertions.assertThat(rateDiscountedPrice).isEqualTo(2000);
    }

    static class DiscountService{
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policyList;

        @Autowired
        public DiscountService(Map<String,DiscountPolicy> map, List<DiscountPolicy> list ){
            this.policyList= list;
            this.policyMap = map;
            System.out.println("map = " + map);
            System.out.println("list = " + list);
        }

        public int discount(Member member, int price, String discountCode) {
            DiscountPolicy discountPolicy = policyMap.get(discountCode);
            System.out.println("discountCode = " + discountCode);
            System.out.println("price = " + price);
            return discountPolicy.discount(member, price);
        }
    }
}
