package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        System.out.println(memberService1);
        System.out.println(memberService2);
        // 맴버 서비스가 계속해서 생성되고 있다는 걸 증명. 너무 낭비가 심하다 - > 싱글톤 패턴으로 해결
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }
    @Test
    @DisplayName("싱글톤 패턴으로 해결")
    void singletonServiceTest(){
        SingletonService singletonService = SingletonService.getInstance();
        SingletonService singletonService1 = SingletonService.getInstance();

        Assertions.assertThat(singletonService1).isSameAs(singletonService);
    } 
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void SpringSingletoneContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        System.out.println(memberService1);
        System.out.println(memberService2);
        // 맴버 서비스가 계속해서 생성되고 있다는 걸 증명. 너무 낭비가 심하다 - > 싱글톤 패턴으로 해결
        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
 }
