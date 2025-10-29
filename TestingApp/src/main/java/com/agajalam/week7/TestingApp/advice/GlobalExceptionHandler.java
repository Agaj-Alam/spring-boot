package com.agajalam.week7.TestingApp.advice;

import com.agajalam.week7.TestingApp.exceptions.ResourceNotFoundExceptions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundExceptions.class)
    public ResponseEntity<?>handleResourceNotFoundException(ResourceNotFoundExceptions ex){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?>handleRuntimeException(RuntimeException ex){
        return ResponseEntity.internalServerError().build();
    }
}
