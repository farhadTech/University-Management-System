package com.example.ums.common.exception;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(IDNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleIdNotFoundException(IDNotFoundException e, WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage(e.getMessage());
        errorDetails.setTimestamp(LocalDateTime.now());
        errorDetails.setPath(webRequest.getDescription(false));
        errorDetails.setErrorCode("ID_NOT_FOUND");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<ErrorDetails> handleDuplicateEmailException(DuplicateEmailException e, WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(
                e.getMessage(),
                LocalDateTime.now(),
                webRequest.getDescription(false),
                "Email already Exist"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleException(Exception e, WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(
                e.getMessage(),
                LocalDateTime.now(),
                webRequest.getDescription(false),
                "Internal Server Error"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
