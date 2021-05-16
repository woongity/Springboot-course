package hello.core;

import hello.core.member.*;

public class MemberApp {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
//        MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());
        Member member = new Member(1L,"memberA", Grade.VIP);
        memberService.join(member);

        Member member1 = memberService.findMember(1L);
        System.out.println("member new id = "+member1.getName());
        System.out.println("member name = "+member.getName());
    }
}
