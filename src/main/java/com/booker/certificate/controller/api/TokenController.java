package com.booker.certificate.controller.api;

import com.booker.certificate.controller.model.request.TokenDomain;
import com.booker.certificate.controller.model.response.TokenModel;
import com.booker.certificate.service.TokenService;
import com.booker.core.wrapper.ResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/certificate/token")
public class TokenController {

    private final TokenService tokenService;

    @PostMapping("/issue")
    public ResultResponse<TokenModel> issueToken(@RequestBody TokenDomain userInfo) {
        return new ResultResponse<>(tokenService.issueToken(userInfo));
    }
}
