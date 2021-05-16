package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy policy = new RateDiscountPolicy();
    @Test
    @DisplayName("Vip는 10퍼센트 할인이 적용되어야 한다.")
    void vip_o(){
        //given
        Member member= new Member(1L,"CustomerA", Grade.VIP);
        //when
        int discount = policy.discount(member,10000);

        Assertions.assertThat(discount). isEqualTo(1000);
        //then
    }
}