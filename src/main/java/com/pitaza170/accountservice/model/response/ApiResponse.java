package com.pitaza170.accountservice.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
public class ApiResponse<T> {


    private final String message;
    private final T data;

    public ApiResponse(String message) {
        this.message = message;
        this.data = null;
    }

    public ApiResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }
}
