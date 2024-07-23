package com.booker.certificate.service;

import com.booker.core.util.TokenUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class TokenProvider {

    @Value("${jwt.key}")
    private String key;

    @Value("${jwt.prefix}")
    private String tokenPrefix;

    public String issueToken(Map<String,Object> tokenInfo, long expireDuration) {
        long current = System.currentTimeMillis();
        return tokenPrefix +
                StringUtils.SPACE +
                Jwts.builder()
                        .claims(tokenInfo)
                        .issuedAt(new Date(current))
                        .expiration(new Date(current + expireDuration))
                        .signWith(TokenUtils.getSecretKey(key))
                        .compact();
    }

    public Claims parseJwt(String token) {
        return TokenUtils.extractAllClaims(TokenUtils.getSecretKey(key),token);
    }
}
