package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PrototypeTest {

    @Test
    void prototypeBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        System.out.println("find prototype 1");
        PrototypeBean bean1 = ac.getBean(PrototypeBean.class);
        System.out.println("find prototype 2");
        PrototypeBean bean2 = ac.getBean(PrototypeBean.class);
        System.out.println("prototypebean1 : "+bean1);
        System.out.println("prototypebean2 : "+bean2);
        Assertions.assertThat(bean1).isNotSameAs(bean2);
        ac.close();
    }
    // 프로토타입 빈은 스프링 컨테이너에서 빈을 조회할때 생성되고 초기화 메소드도 실행된다.
    // 반면에 singleton 빈은 스프링 컨테이너 생성 시점에 초기화 메소드 실행됨. 한번만 생성됨
    // 프로토타입 빈은 요청 
    @Scope("prototype")
    static class PrototypeBean {
        @PostConstruct
        public void init(){
            System.out.println("construct init");
        }
        @PreDestroy
        public void shutdown(){
            System.out.println("closing method is called");
        }
    }
}
