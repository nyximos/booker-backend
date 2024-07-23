package com.booker.user.controller.front.api;

import com.booker.core.wrapper.ResultResponse;
import com.booker.user.controller.front.model.request.JoinRequestModel;
import com.booker.user.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/apis/join")
public class JoinController {

    private final JoinService joinService;

    @PostMapping
    public ResultResponse join(@RequestBody JoinRequestModel joinModel) {
        joinService.join(joinModel);
        return new ResultResponse();
    }
}
