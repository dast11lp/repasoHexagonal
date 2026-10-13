package com.ejemplo.usuarios.infrastructure.adapter.in.web;

import com.ejemplo.usuarios.domain.exception.EmailInvalidoException;
import com.ejemplo.usuarios.domain.exception.EmailYaRegistradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailYaRegistradoException.class)
    public ResponseEntity<ErrorResponse> emailYaRegistrado (EmailYaRegistradoException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(EmailInvalidoException.class)
    public ResponseEntity<ErrorResponse> peticionInvalida (RuntimeException ex) {
        return ResponseEntity.badRequest()
                .body(new ErrorResponse(ex.getMessage()));
    }
}
