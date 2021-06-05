package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class StatefulServiceTest {
    @Test
    @DisplayName("stateful service test")
    public void statefulTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(StatefulService.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        int userAprice = statefulService1.order("A", 2000);
        int userBprice = statefulService2.order("B", 1000);

        System.out.println(userAprice);
        System.out.println(userBprice);


        Assertions.assertThat(userAprice).isEqualTo(2000);
//        Assertions.assertThat(userAprice).isSameAs(userBprice);
    }
}
