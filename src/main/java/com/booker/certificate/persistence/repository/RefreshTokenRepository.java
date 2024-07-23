package com.booker.certificate.persistence.repository;

import com.booker.certificate.persistence.repository.entity.RefreshTokenEntity;
import com.booker.core.redis.DefaultRedisRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends DefaultRedisRepository<RefreshTokenEntity, String> {
    Optional<RefreshTokenEntity> findByRefreshToken(String refreshToken);

}
