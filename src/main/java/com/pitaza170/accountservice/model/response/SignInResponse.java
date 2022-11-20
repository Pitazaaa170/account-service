package com.pitaza170.accountservice.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@AllArgsConstructor
@Getter
public class SignInResponse {

    private int id;
    private boolean registered;
    private boolean status;
}
