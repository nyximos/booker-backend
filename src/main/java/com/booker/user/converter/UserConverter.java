package com.booker.user.converter;

import com.booker.user.controller.front.model.request.JoinRequestModel;
import com.booker.user.persistence.repository.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserConverter {

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "role", constant = "NORMAL_USER")
    UserEntity convert(JoinRequestModel source);
}
