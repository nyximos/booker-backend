package com.booker.user.service;

import com.booker.certificate.controller.model.request.TokenDomain;
import com.booker.core.exception.NodataFoundException;
import com.booker.user.controller.front.model.request.LoginRequestModel;
import com.booker.user.converter.UserConverter;
import com.booker.user.persistence.repository.UserEntity;
import com.booker.user.service.dao.UserDao;
import com.booker.user.service.validate.LoginValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserDao userDao;
    private final LoginValidator passwordValidator;
    private final UserConverter userConverter;

    public TokenDomain login(LoginRequestModel loginModel) {
        UserEntity user = userDao.findById(loginModel.getId()).orElseThrow(NodataFoundException::new);
        passwordValidator.validate(loginModel, user);
        return userConverter.convertToTokenDomain(user);
    }
}
