package com.hanuiijjang.assignment1.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserSignInDto {
    private final String id;
    private final String password;
}
