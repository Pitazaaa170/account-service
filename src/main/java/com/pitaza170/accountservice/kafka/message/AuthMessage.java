package com.pitaza170.accountservice.message;

import com.pitaza170.accountservice.domain.Role;

public record AuthMessage(

        int id,
        String name,
        String surname,
        Role role,
        boolean isRegistered

) {
}
