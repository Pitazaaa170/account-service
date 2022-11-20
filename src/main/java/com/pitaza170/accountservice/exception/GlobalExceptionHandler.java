package com.pitaza170.accountservice.exception;

import com.pitaza170.accountservice.model.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException exception) {
        log.error("Пользователь не найден: {}", exception.getMessage());
        var body = new ErrorResponse(exception.getMessage());
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(body);
    } @ExceptionHandler
    public ResponseEntity<ErrorResponse> handlerUserFailedAuth(UserFailedAuth exception) {
        log.error("Неккоректные данные для входа: {}", exception.getMessage());
        var body = new ErrorResponse(exception.getMessage());
        return ResponseEntity.status(UNAUTHORIZED).body(body);
    }
}