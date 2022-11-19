package com.pitaza170.accountservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public class UserEntity {

    private final int id;
    private final String name;
    private final String surname;
    private final String userId;
    @NonNull
    private final String login;
    @NonNull
    private final String password;
    private final String role;
    private final boolean registered;
    private final boolean status;
    private final Timestamp created;



}
