package com.booker.user.service;

import com.booker.core.util.EncryptUtils;
import com.booker.user.controller.front.model.request.JoinRequestModel;
import com.booker.user.converter.UserConverter;
import com.booker.user.persistence.repository.UserEntity;
import com.booker.user.persistence.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Transactional
    public void join(JoinRequestModel joinModel) {
        UserEntity user = userConverter.convert(joinModel);
        user.encrypt(EncryptUtils.encryptSHA256WithSalt(joinModel.getPassword(), EncryptUtils.generateSalt()));
        userRepository.save(user);
    }
}
