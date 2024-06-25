package org.choongang.board.validators;

import jakarta.servlet.http.HttpServletResponse;
import org.choongang.board.controllers.RequestArtReg;
import org.choongang.global.exceptions.AlertException;
import org.choongang.global.validators.RequiredValidator;
import org.choongang.global.validators.Validator;

public class BoardValidator implements Validator<RequestArtReg>, RequiredValidator {

    @Override
    public void check(RequestArtReg form) {
        String artTitle = form.getArtTitle();
        String artBody = form.getArtBody();
        /* 필수항목 검사 */
        int status = HttpServletResponse.SC_BAD_REQUEST;

        checkRequired(artTitle, new AlertException("제목을 입력하세요", status));
        checkRequired(artBody, new AlertException("본문을 입력하세요", status));
    }
}
