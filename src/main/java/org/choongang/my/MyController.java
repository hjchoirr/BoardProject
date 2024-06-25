package org.choongang.my;

import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.RequestMapping;

@Controller
@RequiredArgsConstructor
public class MyController {
    @NonNull
    private HttpServletRequest request;
    private final MyLoginService service;

    @RequestMapping({"/my/login"})
    public String my(LoginForm form) {
        if(request.getMethod().equalsIgnoreCase("POST")) {

            System.out.println(form.getEmail());
            service.process(form);

            return "my/index";
        } else {
            return "my/login";
        }
    }




}
