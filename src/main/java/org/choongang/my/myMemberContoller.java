package org.choongang.my;

import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.PostMapping;
import org.choongang.global.config.annotations.RequestMapping;

@Controller
@RequestMapping("/my/member")
public class myMemberContoller {

    @GetMapping("/join")
    public String join() {
        return "/my/member/join";
    }

    @PostMapping("/join")
    public String joinPost() {
        return "/my/member/login";
    }

    @GetMapping("/login")
    public String login() {
        return "/my/member/login";
    }
    @PostMapping("/login")
    public String loginPost() {
        return null;
    }
}
