package org.choongang.member.services;

import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Component;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.mappers.MemberMapper;
import org.choongang.member.validators.JoinValidator;

@Component
@RequiredArgsConstructor
public class JoinService {

    private final JoinValidator validator;  // @NonNull 이나 final 써야함
    private final MemberMapper mapper;  // @NonNull 이나 final 써야함

    public void process(RequestJoin form) {

    }
}
