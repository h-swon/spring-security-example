package com.hanuiijjang.assignment1.exception;

import com.hanuiijjang.assignment1.model.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CustomException extends RuntimeException {
    private final ErrorCode errorCode;
}
