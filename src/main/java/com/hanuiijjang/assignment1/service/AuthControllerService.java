package com.hanuiijjang.assignment1.service;

import com.hanuiijjang.assignment1.domain.UserEntity;
import com.hanuiijjang.assignment1.dto.UserSignInDto;
import com.hanuiijjang.assignment1.dto.UserSignUpDto;
import com.hanuiijjang.assignment1.exception.CustomException;
import com.hanuiijjang.assignment1.model.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthControllerService {

    private final UserDataService userDataService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Transactional
    public Boolean registerUser(UserSignUpDto userSignUpDto) throws CustomException {

        // 1. id, password 유효성 검사
        String id = userSignUpDto.getId().trim();
        String password = userSignUpDto.getPassword().trim();
        if (id.isEmpty() || id.isBlank()) throw new CustomException(ErrorCode.USER_SIGN_UP_NO_ID);
        if (password.isEmpty() || password.isBlank()) throw new CustomException(ErrorCode.USER_SIGN_UP_NO_PASSWORD);
        if (!isValidUserId(id)) throw new CustomException(ErrorCode.USER_SIGN_UP_INVALID_ID);
        if (!isValidUserPassword(password)) throw new CustomException(ErrorCode.USER_SIGN_UP_INVALID_PASSWORD);

        // 2. id 중복 검사
        UserEntity findUserEntity = userDataService.findByUserId(userSignUpDto.getId());
        if (findUserEntity != null) throw new CustomException(ErrorCode.USER_SIGN_UP_DUPLICATE_ID);

        // 3. 회원가입
        UserEntity saveUserEntity = UserEntity.builder()
                .id(id)
                .password(passwordEncoder.encode(password))
                .build();

        userDataService.save(saveUserEntity);
        return true;
    }

    public Boolean signIn(UserSignInDto userSignInDto) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userSignInDto.getId(), userSignInDto.getPassword());

        try {
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (AuthenticationException e) {
            throw new CustomException(ErrorCode.USER_SIGN_IN_NO_MATCH);
        }
        return true;
    }

    /**
     * TODO User Id 유효성 검사
     */
    private Boolean isValidUserId(String userId) {

        return true;
    }

    /**
     * TODO User Password 유효성 검사
     */
    private Boolean isValidUserPassword(String password) {

        return true;
    }
}
