package com.pitaza170.accountservice.service;

import com.pitaza170.accountservice.domain.User;

import java.util.Optional;

public interface UserServiceDetail {
    User getUserById(String userId);

    void changeStatus(String userId, Boolean status);
}
