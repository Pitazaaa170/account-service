package com.pitaza170.accountservice.controller;

import com.pitaza170.accountservice.domain.User;
import com.pitaza170.accountservice.model.request.UserDetailsRequest;
import com.pitaza170.accountservice.model.response.ApiResponse;
import com.pitaza170.accountservice.service.UserServiceDetail;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.pitaza170.accountservice.commons.Constants.STATUS_SUCCESSFULLY_UPDATED;
import static com.pitaza170.accountservice.commons.Constants.SUCCESS;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {

    private final UserServiceDetail userServiceDetail;

    @PutMapping("/changeStatus/{userId}")
    public ResponseEntity<ApiResponse<Object>> changeStatus(@PathVariable String userId,
                                                    @RequestParam Boolean status) {

        userServiceDetail.changeStatus(userId, status);
        return ResponseEntity
                .ok(new ApiResponse<>(STATUS_SUCCESSFULLY_UPDATED));
    }

    @GetMapping()
    ResponseEntity<ApiResponse<User>> getUser(@RequestParam String userId) {

        User user = userServiceDetail.getUserById(userId);
        return ResponseEntity
                .ok(new ApiResponse<>(SUCCESS, user));
    }
}
