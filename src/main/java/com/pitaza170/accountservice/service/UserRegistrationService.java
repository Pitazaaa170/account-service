package com.pitaza170.accountservice.service;

import com.pitaza170.accountservice.domain.User;

public interface UserRegistrationService {

    User register(User user);
    User isAuthenticated(String login, String password);
    void receiveRegistration(long userId);
}
