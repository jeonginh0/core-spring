package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberSerivce = ac.getBean("memberService", MemberService.class);
        assertThat(memberSerivce).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType() {
        MemberService memberSerivce = ac.getBean(MemberService.class);
        assertThat(memberSerivce).isInstanceOf(MemberServiceImpl.class);
    }

    //구체화로 적는것은 좋지않다. 항상 역할과 구현은 구분하고 역할에 의존해야 한다.
    @Test
    @DisplayName("구체화 타입으로 조회")
    void findBeanByName2() {
        MemberService memberSerivce = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberSerivce).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회 X")
    void findBeanByNameX() {
//        ac.getBean("xxxxx", MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxxx", MemberService.class));
    } // ac.getBean 로직을 실행하면 왼쪽에 있는 NoSuchBeanDefinitionException.class 예외가 터져야 테스트가 성공한것이다.
}
