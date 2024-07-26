package com.booker.facade;

import com.booker.certificate.controller.model.request.TokenDomain;
import com.booker.certificate.controller.model.response.TokenModel;
import com.booker.certificate.converter.TokenConverter;
import com.booker.certificate.service.TokenService;
import com.booker.user.controller.front.model.request.LoginRequestModel;
import com.booker.user.controller.front.model.response.TokenResponse;
import com.booker.user.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthFacade {

    private final LoginService loginService;
    private final TokenService tokenService;
    private final TokenConverter tokenConverter;

    public TokenResponse login(LoginRequestModel request) {
        TokenDomain tokenDomain = loginService.login(request);
        TokenModel tokenModel = tokenService.issueToken(tokenDomain);
        return tokenConverter.convert(tokenModel);
    }
}