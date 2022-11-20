package com.pitaza170.accountservice.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserFailedAuth extends RuntimeException{
    private static final String ERROR_MESSAGE = "Неккоректные данные входа";

    @Override
    public String getMessage() {
        return ERROR_MESSAGE;
    }
}
