package com.example.inflearnSpring.controller;

import com.example.inflearnSpring.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @ResponseBody: templates 폴더를 뒤지지 않고 데이터 자체를 html body에 다이렉트로 내려준다.
 */
@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("helloData", "hello11111");
        return "hello";
    }

    @GetMapping("hello_mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello_string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return name;
    }

    @GetMapping("hello_api")
    @ResponseBody
    public Member hello_api(@RequestParam("name") String name){
        Member member = new Member();
        return member;
    }
}