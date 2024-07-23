package com.booker.certificate.controller.model.response;

import com.booker.core.constant.DateConst;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TokenModel {
    private String accessToken;
    private String refreshToken;
    private long refreshDuration;

    @JsonFormat(pattern = DateConst.LOCAL_DATE_TIME_FORMAT, timezone = "Asia/Seoul")
    private LocalDateTime expireDate;
}
