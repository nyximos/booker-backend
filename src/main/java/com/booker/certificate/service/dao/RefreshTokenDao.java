package com.booker.certificate.service.dao;

import com.booker.certificate.persistence.repository.RefreshTokenRepository;
import com.booker.certificate.persistence.repository.entity.RefreshTokenEntity;
import com.booker.core.exception.NotFoundRefreshTokenException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RefreshTokenDao {
    private final RefreshTokenRepository repository;

    @Transactional
    public void save(String userId,  String refreshToken){
        RefreshTokenEntity entity = RefreshTokenEntity.builder()
            .id( userId )
            .refreshToken( refreshToken )
            .build();

        repository.save(entity);
    }

    @Transactional
    public void save(String userId,  String refreshToken, long expiration){
        RefreshTokenEntity entity = RefreshTokenEntity.builder()
            .id( userId )
            .refreshToken( refreshToken )
            .expiration( expiration )
            .build();

        repository.save(entity);
    }

    @Transactional
    public void save(RefreshTokenEntity entity){
        repository.save(entity);
    }

    @Transactional(readOnly = true)
    public String getRefreshToken(String userId) {
        RefreshTokenEntity refreshTokenEntity = repository.findById(userId)
            .orElseThrow(() -> new NotFoundRefreshTokenException());

        return refreshTokenEntity.getRefreshToken();
    }

    @Transactional(readOnly = true)
    public String findByRefreshToken(String refreshToken) {
        RefreshTokenEntity refreshTokenEntity = repository.findByRefreshToken(refreshToken)
                .orElseGet(RefreshTokenEntity::new);

        return refreshTokenEntity.isEmpty()?StringUtils.EMPTY:refreshTokenEntity.getClientSecret();
    }

    public String findById(String id) {
        RefreshTokenEntity refreshTokenEntity = repository.findById(id)
                .orElseGet(RefreshTokenEntity::new);
        return refreshTokenEntity.isEmpty()?StringUtils.EMPTY:refreshTokenEntity.getClientSecret();
    }
}
