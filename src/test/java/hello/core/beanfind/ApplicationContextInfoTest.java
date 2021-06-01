package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

//  모든 빈을 출력해보는 테스트.
    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanNames = ac.getBeanDefinitionNames();
        for (String bean : beanNames) {
            Object beanObj = ac.getBean(bean);
            System.out.println("bean = " + bean);
        }
    }
    @Test
    @DisplayName("유저가 만든 빈 출력하기")
    void findApplicationBean(){
        String[] beanNames = ac.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanName);
            if (beanDefinition.getRole() ==BeanDefinition.ROLE_APPLICATION){
                Object beanObj = ac.getBean(beanName);
                System.out.println("bean = " + beanName);
            }

        }
    }
}
