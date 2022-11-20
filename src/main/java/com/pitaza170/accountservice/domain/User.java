package com.pitaza170.accountservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {



    public User(int id, boolean registered, boolean status) {
        this.id = id;
        this.registered = registered;
        this.status = status;
    }

    int id;
    String name;
    String surname;
    String login;
    @JsonIgnore
    String password;
    Role role;
    boolean registered;
    boolean status;
    LocalDateTime created;
}
