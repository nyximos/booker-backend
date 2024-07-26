package com.booker.certificate.converter;

import com.booker.certificate.controller.model.response.TokenModel;
import com.booker.user.controller.front.model.response.TokenResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TokenConverter {
    TokenResponse convert(TokenModel tokenModel);
}
