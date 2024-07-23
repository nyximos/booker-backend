package com.booker.certificate.persistence.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RedisHash(value = "jwt")
public class RefreshTokenEntity {
    @Id
    private String id;

    private String refreshToken;

    private String clientSecret;

    @TimeToLive
    private long expiration;

    public boolean isEmpty(){
        return refreshToken.equals(StringUtils.EMPTY);
    }
}
