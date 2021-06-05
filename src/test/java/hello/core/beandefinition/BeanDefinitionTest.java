package hello.core.beandefinition;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


// 스프링에 빈 등록할때 beandefinition을 통해 직접 등록할수도 있고, appconfig xml, java 등을 생성해서 등록할수도 있다.
// beanDefinition이라는 interface로 meta 정보들을 추상화 한다.
public class BeanDefinitionTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 설정 메타정보 확인")
    void findApplicationBean(){
        String[] beans = ac.getBeanDefinitionNames();
        for(String name: beans){
            BeanDefinition beanDefinition = ac.getBeanDefinition(name);
            // 내가 생성한 빈들만 가져오도록
            if(beanDefinition.getRole()==BeanDefinition.ROLE_APPLICATION){
                System.out.println("bean definition name = "+ name+"bean definition = "+beanDefinition);
            }
        }
    }
}
