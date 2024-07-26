package com.booker.user.controller.front.model.response;

import com.booker.core.constant.DateConst;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TokenResponse {
    private String accessToken;
    private String refreshToken;

    @JsonFormat(pattern = DateConst.LOCAL_DATE_TIME_FORMAT, timezone = "Asia/Seoul")
    private LocalDateTime expireDate;
}
