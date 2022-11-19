package com.pitaza170.accountservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.sql.Timestamp;

@AllArgsConstructor
@Getter
public class UserEntity {

    private final int id;
    private final String name;
    private final String surname;
    private final String userId;
    private final String login;
    private final String password;
    private final String role;
    private final boolean registered;
    private final boolean status;
    private final Timestamp created;



}
