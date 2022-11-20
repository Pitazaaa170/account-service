package com.pitaza170.accountservice.controller;

import com.pitaza170.accountservice.domain.User;
import com.pitaza170.accountservice.service.UserServiceDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("${app.name}/v1")
public class UserController {

    private final UserServiceDetail userServiceDetail;

    @PutMapping("/changeStatus/{userId}")
    public ResponseEntity<?> changeStatus(@PathVariable String userId,
                                                    @RequestParam Boolean status) {

        userServiceDetail.changeStatus(userId, status);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{userId}")
    ResponseEntity<User> getUser(@PathVariable String userId) {

        User user = userServiceDetail.getUserById(userId);
        return ResponseEntity.ok(user);
    }
}
