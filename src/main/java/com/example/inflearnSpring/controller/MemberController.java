package com.example.inflearnSpring.controller;

import com.example.inflearnSpring.domain.Member;
import com.example.inflearnSpring.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

    /**
     * @Autowired: 생성자에 해당 어노테이션이 설정되어있으면 스프링이 컨테이너에 등록되어있는 MemberService.class를 객체로 자동으로 넣어준다.
     */
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
}
