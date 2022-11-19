package com.pitaza170.accountservice.controller;

import com.pitaza170.accountservice.domain.Role;
import com.pitaza170.accountservice.domain.User;
import com.pitaza170.accountservice.model.request.SignInRequest;
import com.pitaza170.accountservice.model.request.SignUpRequest;
import com.pitaza170.accountservice.model.request.UserDetailsRequest;
import com.pitaza170.accountservice.service.UserRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Random;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRegistrationService userRegistrationService;


    @PostMapping("/signup")
    public ResponseEntity registerUser(@RequestBody SignUpRequest signUpRequest) {

        userRegistrationService.register(
            new User(
                    new Random().nextInt(Integer.MAX_VALUE/2),
                    signUpRequest.getName(),
                    signUpRequest.getSurname(),
                    signUpRequest.getLogin(),
                    signUpRequest.getPassword(),
                    Role.USER,
                    false,
                    false,
                    LocalDateTime.now()
            )
        );

        return ResponseEntity.ok().build();
    }

    /*@PostMapping("/signin")
    public ResponseEntity authenticateUser(@RequestBody SignInRequest signInRequest) {

        userRegistrationService.login(
                signInRequest.getLogin(), signInRequest.getPassword()
        );


        return ResponseEntity.ok().build();
    }*/


}
