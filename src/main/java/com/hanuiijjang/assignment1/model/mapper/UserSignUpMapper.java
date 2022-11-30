package com.hanuiijjang.assignment1.model.mapper;

import com.hanuiijjang.assignment1.domain.UserEntity;
import com.hanuiijjang.assignment1.dto.UserSignUpDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserSignUpMapper extends GenericMapper<UserEntity, UserSignUpDto> {
}
