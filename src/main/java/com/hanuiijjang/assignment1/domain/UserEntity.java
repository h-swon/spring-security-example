package com.hanuiijjang.assignment1.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity extends BaseTimeEntity {
    @Id
    private String uuid;

    @Column(nullable = false)
    private String id;
    @Column(nullable = false)
    private String password;

    @Builder
    public UserEntity(String id, String password) {
        this.uuid = UUID.randomUUID().toString();
        this.id = id;
        this.password = password;
    }
}
