package com.pitaza170.accountservice.service.mapper;

import com.pitaza170.accountservice.domain.Role;
import com.pitaza170.accountservice.domain.User;
import com.pitaza170.accountservice.message.AuthMessage;
import com.pitaza170.accountservice.model.entity.UserEntity;
import com.pitaza170.accountservice.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserMapper {

    private final UserRepository userRepository;

    public UserEntity map(User user) {
        LocalDateTime now = LocalDateTime.now();
        return new UserEntity(
                userRepository.findNextId(),
                user.getName(),
                user.getSurname(),
                String.valueOf(user.getId()),
                user.getLogin(),
                user.getPassword(),
                user.getRole().name(),
                user.isRegistered(),
                user.isStatus(),
                Timestamp.valueOf(now)

        );
    }

    public AuthMessage mapMessage(User user) {
        return new AuthMessage(
                user.getId(),
                user.getName(),
                user.getSurname(),
                Role.USER,
                false
        );
    }
}
