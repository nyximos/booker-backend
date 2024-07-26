package com.booker.user.controller.front.api;

import com.booker.core.wrapper.ResultResponse;
import com.booker.facade.AuthFacade;
import com.booker.user.controller.front.model.request.LoginRequestModel;
import com.booker.user.controller.front.model.response.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apis/user/login")
public class LoginController {

    private final AuthFacade authFacade;

    @PostMapping
    public ResultResponse<TokenResponse> login(@RequestBody LoginRequestModel loginModel) {
        return new ResultResponse<>(authFacade.login(loginModel));
    }
}
