package com.pitaza170.accountservice.service;

import com.pitaza170.accountservice.domain.User;
import com.pitaza170.accountservice.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceDetailImpl implements UserServiceDetail {

    private final UserRepository userRepository;

    @Override
    public User getUserById(String userId) {
        try {
            return userRepository.getUserById(userId);
        } catch (Exception e) {
            log.error("Ошибка во время получения Юзера по id:" + userId, e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ошибка во время получения Юзера по id ", e);
        }
    }

    @Override
    public void changeStatus(String userId, Boolean status) {
        userRepository.updateStatus(userId, status);
    }

}
