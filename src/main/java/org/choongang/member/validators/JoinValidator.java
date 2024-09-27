package org.choongang.member.validators;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Component;
import org.choongang.global.exceptions.AlertException;
import org.choongang.global.validators.EmailValidator;
import org.choongang.global.validators.RequiredValidator;
import org.choongang.global.validators.Validator;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.mappers.MemberMapper;

@Component
@RequiredArgsConstructor
public class JoinValidator implements Validator<RequestJoin>, RequiredValidator, EmailValidator {

    private final MemberMapper mapper;  // @NonNull 이나 final 써야함 상수로 정의하여 반드시 생성자매개변수에 넣기 위해

    @Override
    public void check(RequestJoin form) {
        String email = form.getEmail();
        String password = form.getPassword();
        String confirmPassword = form.getConfirmPassword();
        String userName = form.getUserName();
        boolean termsAgree = form.isTermsAgree();
        /* 필수항목 검사 */
        int status = HttpServletResponse.SC_BAD_REQUEST;

        checkRequired(email, new AlertException("이메일을 입력하세요", status));
        checkRequired(password, new AlertException("비밀번호를 입력하세요", status));
        checkRequired(confirmPassword, new AlertException("비밀번호확인을 입력하세요", status));
        checkRequired(userName, new AlertException("회원명 입력하세요", status));
        checkTrue(termsAgree, new AlertException("약관동의 하세요", status));

        // 이메일 형식 체크
        checkTrue(checkEmail(email), new AlertException("이메일 형식이 아닙니다.", status));
        // 이메일 중복여부 체크
        checkTrue(mapper.exists(email) == 0L, new AlertException("이미 가입된 이메일입니다", status));
        // 비밀번호 자리수 8자리 이상
        checkTrue(password.length() >= 8, new AlertException("비밀번호는 8자리 이상 입력하세요", status));
        // 비밀번호와 비밀번호 확인의 일치여부
        checkTrue(password.equals(confirmPassword), new AlertException("비밀번호와 비밀번호확인이 일치하지 않습니다.", status));

    }
}
