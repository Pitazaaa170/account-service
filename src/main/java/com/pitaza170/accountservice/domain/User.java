package com.pitaza170.accountservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    int id;
    String name;
    String surname;
    String login;
    String password;
    Role role;
    boolean registered;
    boolean status;
    LocalDateTime created;
}
