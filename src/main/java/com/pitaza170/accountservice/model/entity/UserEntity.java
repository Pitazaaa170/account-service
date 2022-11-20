package com.pitaza170.accountservice.model.entity;

import lombok.*;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    private int id;
    private String name;
    private String surname;
    private String userId;
    private String login;
    private String password;
    private String role;
    private boolean registered;
    private boolean status;
    private Timestamp created;


}
