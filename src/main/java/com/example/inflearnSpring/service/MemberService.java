package com.example.inflearnSpring.service;

import com.example.inflearnSpring.domain.Member;
import com.example.inflearnSpring.repository.MemberRepository;
import com.example.inflearnSpring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 회원 가입
    public Long join(Member member){
        checkMember(member); // 중복 회원 검사
        memberRepository.save(member);
        return member.getId();
    }


    public void checkMember(Member member){
        Optional<Member> result = memberRepository.findByName(member.getName());
        // .ifPresent은 Optional<>의 옵션으로 null이 아니라면 동작한다.
        // 따라서 새로 들어온 member 객체가 memberRepository.findByName()통해 있는지 확인 결과 있다면 이미 가입된 회원 이름인 것이다.
        result.ifPresent(memberCheck -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    // 전체 회원 조회
    public List<Member> findAllMembers(){
        return memberRepository.findAll();
    }

    // 회원 id로 조회
    public Optional<Member> findOneMember(Long id){
        return memberRepository.findById(id);
    }
}
