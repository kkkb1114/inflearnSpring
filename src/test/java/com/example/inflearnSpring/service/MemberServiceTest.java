package com.example.inflearnSpring.service;

import com.example.inflearnSpring.domain.Member;
import com.example.inflearnSpring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberService();
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        memberRepository.claerStore();
    }

    /**
     * given: (데이터)
     * when: (동작)
     * then: (검증)
     */
    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("김기범1");
        //when
        Long saveId = memberService.join(member);

        //then
        Optional<Member> memberOptional = memberService.findOneMember(saveId);
        Assertions.assertThat(memberOptional.get()).isEqualTo(member);
    }

    @Test
    void checkMember() {
        //given
        Member member1 = new Member();
        member1.setName("김기범1");

        Member member2 = new Member();
        member2.setName("김기범2");

        //when
        //memberService.join(member1);

        System.out.println("111111111111111"+assertThrows(IllegalStateException.class, () -> memberService.join(member2)).getMessage());
        Assertions.assertThat(assertThrows(IllegalStateException.class, () -> memberService.join(member2)).getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        //then

    }

    @Test
    void findAllMembers() {
        for (Member member : memberService.findAllMembers()){
            System.out.println("asdsada"+member.getName());
        }
    }

    @Test
    void findOneMember() {
    }

}