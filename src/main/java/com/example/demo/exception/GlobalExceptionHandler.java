package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResult> handle(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getFieldError().getDefaultMessage();
        ErrorResult errorResult = new ErrorResult(HttpStatus.BAD_REQUEST.value(), "Bad Request", message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

    @ExceptionHandler(TraineeNotFoundException.class)
    public ResponseEntity<ErrorResult> handle(TraineeNotFoundException e) {
        ErrorResult errorResult = new ErrorResult(HttpStatus.NOT_FOUND.value(), "Not Found", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResult);
    }
}
