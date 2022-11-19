package com.pitaza170.accountservice.domain;

import java.time.LocalDateTime;


public record User(

    int id,
    String name,
    String surname,
    String login,
    String password,
    Role role,
    boolean registered,
    boolean status,
    LocalDateTime created

) {
}
