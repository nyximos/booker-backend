package com.booker.certificate.controller.model.request;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TokenDomain extends IssueTokenDomain {
    private String nickname;
    private String email;
}
