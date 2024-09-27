package org.choongang.member.services;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Component;
import org.choongang.global.exceptions.AlertException;
import org.choongang.member.constants.UserType;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.entities.Member;
import org.choongang.member.mappers.MemberMapper;
import org.choongang.member.validators.JoinValidator;
import org.mindrot.jbcrypt.BCrypt;

@Component
@RequiredArgsConstructor
public class JoinService {

    private final JoinValidator validator;  // @NonNull 이나 final 써야함
    private final MemberMapper mapper;  // @NonNull 이나 final 써야함

    public void process(RequestJoin form) {
        validator.check(form);

        //비밀번호 해시화 - BCrypt:유동해시
        String hash = BCrypt.hashpw(form.getPassword(), BCrypt.gensalt(12));
        //DB에 영구저장 처리

        Member member = Member.builder()
                .email(form.getEmail())
                .password(hash)
                .userName(form.getUserName())
                .userType(UserType.USER)
                .build();
        int result = mapper.register(member);
        if (result < 1) {
            throw new AlertException("회원가입에 실패하였습니다", HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
