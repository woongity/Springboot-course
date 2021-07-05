package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
// 그냥 qualifier로 하는 경우 runtime 단계에서 문자열은 체크를 안하는 문제가 있다. 따라서 오타가 나는 경우에도 문제없이 실행되는 문제발생.
public class RateDiscountPolicy implements DiscountPolicy{
    private int disCountedPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){
            return price*disCountedPercent/100;
        }
        return 0;
    }
}
