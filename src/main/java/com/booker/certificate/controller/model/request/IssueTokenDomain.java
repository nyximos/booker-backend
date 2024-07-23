package com.booker.certificate.controller.model.request;

import com.booker.core.code.TokenType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class IssueTokenDomain {
    private String id;
    private TokenType type;
}
