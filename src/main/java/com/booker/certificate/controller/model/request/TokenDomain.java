package com.booker.certificate.controller.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TokenDomain extends IssueTokenDomain {
    private String nickname;
    private String email;
}
