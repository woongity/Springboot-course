package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class FixedDiscountPolicy implements DiscountPolicy{
    int discountFixedPrice = 1000;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){
            return discountFixedPrice;
        }else{
            return 0;
        }
    }
}
