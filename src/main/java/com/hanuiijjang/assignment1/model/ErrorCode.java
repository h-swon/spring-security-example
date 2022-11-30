package com.hanuiijjang.assignment1.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    // User Sign-Up
    USER_SIGN_UP_NO_ID(400, "S001", "아이디를 입력해주세요."),
    USER_SIGN_UP_INVALID_ID(400, "S002", "올바른 아이디 형식이 아닙니다."),
    USER_SIGN_UP_DUPLICATE_ID(400, "S003", "이미 사용 중인 아이디입니다."),
    USER_SIGN_UP_NO_PASSWORD(400, "S004", "비밀번호를 입력해주세요."),
    USER_SIGN_UP_INVALID_PASSWORD(400, "S005", "올바른 비밀번호 형식이 아닙니다."),

    // User Sign-In
    USER_SIGN_IN_NO_ID(400, "L001", "아이디를 입력해주세요."),
    USER_SIGN_IN_NO_PASSWORD(400, "L002", "비밀번호를 입력해주세요."),
    USER_SIGN_IN_NO_MATCH(400, "L003", "등록되지 않은 아이디이거나 아이디 또는 비밀번호를 잘못 입력했습니다."),
    USER_SIGN_IN_ERROR(500, "L004", "일시적인 오류로 로그인을 할 수 없습니다. 잠시 후 다시 이용해주세요."),

    ;
    private final int status;
    private final String code;
    private final String message;
}
