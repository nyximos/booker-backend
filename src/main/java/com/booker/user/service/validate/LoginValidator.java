package com.booker.user.service.validate;

import com.booker.core.exception.BookerException;
import com.booker.core.exception.code.ErrorCode;
import com.booker.core.util.EncryptUtils;
import com.booker.user.controller.front.model.request.LoginRequestModel;
import com.booker.user.persistence.repository.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginValidator {

    public void validate(LoginRequestModel loginModel, UserEntity user) {
        String salt = user.getSalt();
        String password = EncryptUtils.encryptSHA256WithSalt(loginModel.getPassword(), salt);
        boolean status = password.equals(user.getPassword());
        if (!status) {
            throw new BookerException(HttpStatus.BAD_REQUEST, ErrorCode.PASSWORD_NOT_CORRECT);
        }
    }
}
