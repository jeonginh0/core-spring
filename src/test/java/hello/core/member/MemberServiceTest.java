package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    public void beforeEach() { // 테스트를 실행하기전 무조건 실행된다.
        AppConfig appConfig = new AppConfig(); //테스트 실행전 AppConfig 객체를 생성
        memberService = appConfig.memberService(); //위에 값 할당 후 테스트가 돌아감.
    }

    @Test
    void join(){
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(findMember).isEqualTo(findMember);
    }
}
