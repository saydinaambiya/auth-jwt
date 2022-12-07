package com.enigmacamp.authjwt.controller;

import com.enigmacamp.authjwt.exception.UnathorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {
    @ExceptionHandler(UnathorizedException.class)
    ResponseEntity<String> handleUnauthorizedException(UnathorizedException e){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unathorized");
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<String> handleAllException(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server error");
    }
}
