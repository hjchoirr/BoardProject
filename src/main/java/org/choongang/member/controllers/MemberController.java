package org.choongang.member.controllers;

import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.PostMapping;
import org.choongang.global.config.annotations.RequestMapping;
import org.choongang.member.services.JoinService;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final JoinService joinService;

    //화원가입양식
    @GetMapping("/join")
    public String join() {

        return "member/join";
    }

    //회원가입처리
    @PostMapping("/join")
    public String joinPs(RequestJoin form) {
        joinService.process(form);

        return null;
    }

    //로그인 양식
    @GetMapping("/login")
    public String login() {
        return "member/login";
    }

    @PostMapping("/login")
    public String loginPs(RequestLogin form) {
        return null;
    }
}
