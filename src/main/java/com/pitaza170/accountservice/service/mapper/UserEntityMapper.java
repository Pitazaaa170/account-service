package com.pitaza170.accountservice.service.mapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pitaza170.accountservice.domain.Role;
import com.pitaza170.accountservice.domain.User;
import com.pitaza170.accountservice.model.entity.UserEntity;
import liquibase.pro.packaged.F;
import liquibase.pro.packaged.T;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserEntityMapper implements BaseMapper<UserEntity, User> {

    @Override
    public User mapFrom(UserEntity object) {
        return new User(object.getId(),
                object.getName(),
                object.getSurname(),
                object.getLogin(),
                object.getPassword(),
                Role.valueOf(object.getRole().toUpperCase()),
                object.isRegistered(),
                object.isStatus(),
                object.getCreated().toLocalDateTime()
                );


    }

    @Override
    public User mapSign(UserEntity object) {
        return new User(object.getId(),
                object.isRegistered(),
                object.isStatus());
    }



}
