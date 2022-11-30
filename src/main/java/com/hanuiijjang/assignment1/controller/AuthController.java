package com.hanuiijjang.assignment1.controller;

import com.hanuiijjang.assignment1.dto.UserSignInDto;
import com.hanuiijjang.assignment1.dto.UserSignUpDto;
import com.hanuiijjang.assignment1.exception.CustomException;
import com.hanuiijjang.assignment1.model.ApiResponse;
import com.hanuiijjang.assignment1.service.AuthControllerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthControllerService authControllerService;

    @PostMapping("/sign-up")
    public ResponseEntity<ApiResponse<Boolean>> signIn(@RequestBody UserSignUpDto userSignUpDto) {
        Boolean result = authControllerService.registerUser(userSignUpDto);
        return ResponseEntity.ok(ApiResponse.createSuccess(result));
    }

    @PostMapping("/sign-in")
    public ResponseEntity<ApiResponse<Boolean>> signIn(@RequestBody UserSignInDto userSignInDto) {
        System.out.println("FSDFASDASDFASFASDASDF");
        System.out.println("userSignInDto = " + userSignInDto);
        Boolean result = authControllerService.signIn(userSignInDto);
        return ResponseEntity.ok(ApiResponse.createSuccess(result));
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiResponse> errorHandling(CustomException e) {
        return ResponseEntity.status(e.getErrorCode().getStatus()).body(ApiResponse.createFailure(e.getErrorCode()));
    }
}
