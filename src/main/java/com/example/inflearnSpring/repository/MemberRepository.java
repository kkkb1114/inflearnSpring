package com.example.inflearnSpring.repository;

import com.example.inflearnSpring.domain.Member;

import java.util.List;
import java.util.Optional;

/**
 * 1. Optional<>: null을 예외처리 하기 위한 변수라고 생각하면 편하다.
 */
public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
