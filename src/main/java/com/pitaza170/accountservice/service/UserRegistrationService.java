package com.pitaza170.accountservice.service;

import com.pitaza170.accountservice.domain.User;
import com.pitaza170.accountservice.model.entity.UserEntity;

import java.util.Optional;

public interface UserRegistrationService {

    User register(User user);

    User isAuthenticated(String login, String password);
}
