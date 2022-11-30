package com.hanuiijjang.assignment1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)  // null인 데이터는 json 결과에 포함하지 않는다.
public class ApiResponse<T> {
    private int status;
    private String code;
    private String message;
    private T data;

    public static <T> ApiResponse<T> createSuccess(T data) {
        return new ApiResponse<>(HttpStatus.OK.value(), null, null, data);
    }

    public static <T> ApiResponse<T> createFailure(ErrorCode errorCode) {
        return new ApiResponse<>(errorCode.getStatus(), errorCode.getCode(), errorCode.getMessage(), null);
    }
}
