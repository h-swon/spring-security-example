package com.hanuiijjang.assignment1.service;

import com.hanuiijjang.assignment1.domain.UserEntity;
import com.hanuiijjang.assignment1.repository.UserDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDataService {

    private final UserDataRepository userDataRepository;

    /**
     * UserEntity 저장
     */
    @Transactional
    public UserEntity save(UserEntity userEntity) {
        return userDataRepository.save(userEntity);
    }


    /**
     * userId로 UserEntity 조회
     */
    public UserEntity findByUserId(String userId) {
        return userDataRepository.findByUserId(userId);
    }
}
