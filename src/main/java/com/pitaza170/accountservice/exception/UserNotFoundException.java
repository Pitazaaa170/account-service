package com.pitaza170.accountservice.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserNotFoundException extends RuntimeException{
    private String userId;
    private static final String ERROR_MESSAGE = "Пользователеь с id %s не найден";

    @Override
    public String getMessage() {
        return String.format(ERROR_MESSAGE, userId);
    }
}
