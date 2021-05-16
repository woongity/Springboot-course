package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
//    MemberService memberService = new MemberServiceImpl();
    MemberService memberService;
    @BeforeEach
    void BeforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
    @Test
    void join(){
        // given
        Member member = new Member(1L,"memeber",Grade.VIP);
        //when
        memberService.join(member);
        //then
        Member member1 = memberService.findMember(1L);
        Assertions.assertThat(member1).isEqualTo(member);
    }
}
