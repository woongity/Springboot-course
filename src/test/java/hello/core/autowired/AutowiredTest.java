package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {
    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }
     static class TestBean {
        // 이렇게 등록해놓으면 member라는 빈이 없어도 에러가 나지않음.
         //의존 관계가 없다면 메소드 호출 자체가 안됨.
         @Autowired(required = false)
        public void setNo1Bean(Member member1){
            System.out.println("member = " + member1);
        }
// 호출은 되지만 null이라면 null로 들어감.아니라면 정상적으로 들어감
        @Autowired
        public void setNo2Bean(@Nullable Member member2){
            System.out.println("member = " + member2);
        }
// java 8 문법. optional에 쌓여있어서 값이 있다면 optional로 감싸져서 들어감.
        @Autowired
        public void setNo3Bean(Optional<Member> member3){
            System.out.println("member = " + member3);
        }
    }
}
