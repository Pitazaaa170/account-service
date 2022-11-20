package com.pitaza170.accountservice.service;

import com.pitaza170.accountservice.domain.User;
import com.pitaza170.accountservice.exception.UserNotFoundException;
import com.pitaza170.accountservice.persistence.UserRepository;
import com.pitaza170.accountservice.service.mapper.UserEntityMapper;
import com.pitaza170.accountservice.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceDetailImpl implements UserServiceDetail {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    @Override
    public User getUserById(String userId) {
        var user = userRepository.getUserById(userId);
        if (user.isPresent()) {
            return userEntityMapper.mapFrom(user.get());
        }
        throw new UserNotFoundException(userId);

    }

    @Override
    public void changeStatus(String userId, Boolean status) {
        userRepository.updateStatus(userId, status);
    }

}
