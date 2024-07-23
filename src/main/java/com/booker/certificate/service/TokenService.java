package com.booker.certificate.service;

import com.booker.certificate.controller.model.request.TokenDomain;
import com.booker.certificate.controller.model.response.TokenModel;
import com.booker.certificate.service.dao.RefreshTokenDao;
import com.booker.core.code.TokenType;
import com.booker.core.exception.UnauthorizedException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TokenService {

    @Value("${jwt.access.expire}")
    private long jwtExpireDuration;

    @Value("${jwt.refresh.expire}")
    private long refreshDuration;

    private final TokenProvider tokenProvider;
    private final ObjectMapper objectMapper;
    private final RefreshTokenDao refreshTokenDao;

    public TokenModel issueToken(TokenDomain userTokenDomain) {
        TokenModel token = TokenModel
                .builder()
                .accessToken(tokenProvider.issueToken(getIssueTokenModel(userTokenDomain, TokenType.ACCESS_TOKEN), jwtExpireDuration))
                .refreshToken(tokenProvider.issueToken(getIssueTokenModel(userTokenDomain, TokenType.REFRESH_TOKEN), refreshDuration))
                .refreshDuration(refreshDuration)
                .expireDate(LocalDateTime.now().plusNanos(jwtExpireDuration * 1000 * 1000))
                .build();
        refreshTokenDao.save(userTokenDomain.getId(), token.getRefreshToken(), token.getRefreshDuration());
        return token;
    }

    public TokenDomain getTokenDomain(Claims claims, String refreshToken) {
        TokenDomain domain = objectMapper.convertValue(claims, TokenDomain.class);
        String oriRefreshToken = refreshTokenDao.getRefreshToken(domain.getId());
        if (isValid(oriRefreshToken,refreshToken)) {
            return domain;
        }
        throw new UnauthorizedException();
    }

    public Map<String, Object> getIssueTokenModel(TokenDomain tokenDomain,TokenType type) {
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        Map<String, Object> map = objectMapper.convertValue(tokenDomain, Map.class);
        return map;
    }

    public boolean isValid(String oriRefreshToken, String refreshToken) {
        return StringUtils.isNotEmpty(oriRefreshToken) && oriRefreshToken.equals(refreshToken);
    }

}
