package hello.core.xml;

import hello.core.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlAppContext {
    @Test
    void xmlAppContext(){
        // xml로 설정을 해서 가져오는 걸로.. appconfig.java대신 이걸로
//      spring 은 bean을 선언한 파일의 형태에 영향을 받지 않는다. 그냥 bean definition을 만들어 버리기 때문에..
//        bean definition 자체가 interface임
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        MemberService memberService = ac.getBean("memberService",MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
