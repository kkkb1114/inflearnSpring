package com.example.inflearnSpring.repository;

import com.example.inflearnSpring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    //해당 @AfterEach은 테스트 메소드가 하나씩 끝날때마다 호출되며 원하는
    @AfterEach
    public void afterEach(){
        memberRepository.claerStore();
    }

    @Test
    public void save(){
        String name = "김기범";
        Member member = new Member();
        member.setName(name);

        memberRepository.save(member);

        // findById(), findByName()
        Member result = memberRepository.findById(member.getId()).get();
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        String name1 = "김기범1";
        Member member1 = new Member();
        member1.setName(name1);
        memberRepository.save(member1);

        String name2 = "김기범2";
        Member member2 = new Member();
        member2.setName(name2);
        memberRepository.save(member2);

        Assertions.assertThat(memberRepository.findByName("김기범1").get()).isEqualTo(member1);
        Assertions.assertThat(memberRepository.findByName("김기범2").get()).isEqualTo(member2);
    }

    @Test
    public void findAll(){
        String name1 = "김기범1";
        Member member1 = new Member();
        member1.setName(name1);
        memberRepository.save(member1);

        String name2 = "김기범2";
        Member member2 = new Member();
        member2.setName(name2);
        memberRepository.save(member2);

        List<Member> memberList = memberRepository.findAll();
        Assertions.assertThat(memberList.size()).isEqualTo(2);
    }
}
