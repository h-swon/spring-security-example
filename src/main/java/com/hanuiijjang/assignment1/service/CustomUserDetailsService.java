package com.hanuiijjang.assignment1.service;

import com.hanuiijjang.assignment1.domain.UserEntity;
import com.hanuiijjang.assignment1.repository.UserDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserDataRepository userDataRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userDataRepository.findByUserId(username);
        if (userEntity == null) throw new UsernameNotFoundException("유저 정보가 없습니다.");

        return User.builder()
                .username(userEntity.getId())
                .password(userEntity.getPassword())
                .authorities("USER")
                .build();
    }
}
