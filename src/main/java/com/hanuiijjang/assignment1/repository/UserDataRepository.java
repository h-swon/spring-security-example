package com.hanuiijjang.assignment1.repository;

import com.hanuiijjang.assignment1.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDataRepository extends JpaRepository<UserEntity, String> {
    @Query("SELECT u FROM UserEntity u WHERE u.id = :userId")
    UserEntity findByUserId(String userId);
}
