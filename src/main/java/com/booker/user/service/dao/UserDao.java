package com.booker.user.service.dao;

import com.booker.user.persistence.repository.UserEntity;
import com.booker.user.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDao {

    private final UserRepository userRepository;

    public void save(UserEntity user) {
        userRepository.save(user);
    }

    public Optional<UserEntity> findById(String id) {
        return userRepository.findById(id);
    }
}
