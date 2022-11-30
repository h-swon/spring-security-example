package com.hanuiijjang.assignment1.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class UserSignUpDto {
    private final String id;
    private final String password;
}
