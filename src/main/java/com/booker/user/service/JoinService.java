package com.booker.user.service;

import com.booker.core.util.EncryptUtils;
import com.booker.user.controller.front.model.request.JoinRequestModel;
import com.booker.user.converter.UserConverter;
import com.booker.user.persistence.repository.UserEntity;
import com.booker.user.persistence.repository.UserRepository;
import com.booker.user.service.dao.UserDao;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final UserDao userDao;
    private final UserConverter userConverter;

    @Transactional
    public void join(JoinRequestModel joinModel) {
        String salt = EncryptUtils.generateSalt();
        UserEntity user = userConverter.convert(joinModel, salt);
        user.encrypt(EncryptUtils.encryptSHA256WithSalt(joinModel.getPassword(), salt));
        userDao.save(user);
    }
}
