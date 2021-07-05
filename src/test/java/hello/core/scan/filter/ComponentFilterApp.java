package hello.core.scan.filter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.junit.jupiter.api.Assertions.*;

public class ComponentFilterApp {
    @Test
    void BeanAFilterScan(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentScanAppConfig.class);
        BeanA beanA = ac.getBean("beanA",BeanA.class);
        Assertions.assertThat(beanA).isNotNull();
    }
    @Test
    void BeanBFilterScan(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentScanAppConfig.class);
        assertThrows(NoSuchBeanDefinitionException.class,
                ()->ac.getBean("beanB",BeanB.class)
         );
    }

    @Configuration
    @ComponentScan(
            includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = MyIncludeComponent.class),
            excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION,classes = MyExcludeComponent.class)
    )
    static class ComponentScanAppConfig {
    }
}

