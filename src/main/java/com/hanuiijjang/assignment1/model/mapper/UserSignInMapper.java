package com.hanuiijjang.assignment1.model.mapper;

import com.hanuiijjang.assignment1.domain.UserEntity;
import com.hanuiijjang.assignment1.dto.UserSignInDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserSignInMapper extends GenericMapper<UserEntity, UserSignInDto> {
}
