package org.choongang.my;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.RequestMapping;

@Controller
@RequiredArgsConstructor
public class MyController {

    private final HttpServletRequest request;
    private final MyLoginService service;

    @RequestMapping({"/my/login"})
    public String my() {
        if(request.getMethod().equalsIgnoreCase("POST")) {

            LoginForm loginForm = LoginForm.builder()
                .email(request.getParameter("email"))
                .password(request.getParameter("password"))
                .build();
            service.process(loginForm);

            return "my/index";
        } else {
            return "my/login";
        }
    }




}
