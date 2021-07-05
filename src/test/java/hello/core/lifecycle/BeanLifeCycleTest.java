package hello.core.lifecycle;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {
    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac = new
                AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        // destory 메소드 실행
        ac.close(); //스프링 컨테이너를 종료, ConfigurableApplicationContext 필요
    }
    @Configuration
    static class LifeCycleConfig {
        // 이런식으로 사용하면 implements로 가져오는 것에 비해 3가지 정도 장점이 존재
        // 메소드 이름을 자유롭게 설정가능, 코드가 아니라 설정 정보 수정이기때문에 외부라이브러리에도 사용가능
        // 스프링 빈이 스프링 코드에 의존하지않음

        // destoryMethod의 경우 추론해서 close나 shutdown이라는 이름을 가지는 종료메소드를 가지고 가서 호출함
//        @Bean(initMethod = "init" , destroyMethod= "close")
        // 생명주기를 위해서 코드 수정이 불가능한 코드 등록에만 위처럼 등록하자!
        // 아닌경우 @PreDestory @PostConstruct 사용하는 것이 권장됨.

        @Bean

        public NetworkClient networkClient() {
            //요기서 생성자 호출. url = null
            NetworkClient networkClient = new NetworkClient();
            // 여기서 init 메소드 실행
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}
