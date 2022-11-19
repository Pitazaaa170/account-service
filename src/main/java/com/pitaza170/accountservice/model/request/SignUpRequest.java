package com.pitaza170.accountservice.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignUpRequest {

    private String name;
    private String surname;
    private String login;
    private String password;

}
