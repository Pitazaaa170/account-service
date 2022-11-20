package com.pitaza170.accountservice.service;

import com.pitaza170.accountservice.domain.User;
import com.pitaza170.accountservice.exception.UserFailedAuth;
import com.pitaza170.accountservice.message.PublishUserRegistrationMessage;
import com.pitaza170.accountservice.model.entity.UserEntity;
import com.pitaza170.accountservice.persistence.UserRepository;
import com.pitaza170.accountservice.service.mapper.UserEntityMapper;
import com.pitaza170.accountservice.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

    private final UserRepository userRepository;

    private final PublishUserRegistrationMessage publishUserRegistrationMessage;

    private final UserMapper userMapper;
    private final UserEntityMapper userEntityMapper;


    @Override
    public User register(User user) {
        userRepository.save(userMapper.map(user));
        publishUserRegistrationMessage.sendMessage(userMapper.mapMessage(user));
        return user;
    }

    @Override
    public User isAuthenticated(String login, String password) {
        var user = userRepository.isAuthenticated(login, password);
        if (user.isPresent()) {
            return userEntityMapper.mapSign(user.get());
        }
        throw new UserFailedAuth();
    }


}
