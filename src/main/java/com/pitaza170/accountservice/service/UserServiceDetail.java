package com.pitaza170.accountservice.service;

import com.pitaza170.accountservice.domain.User;

public interface UserServiceDetail {

    User getUserById(String userId);

    void changeStatus(String userId, Boolean status);
}
