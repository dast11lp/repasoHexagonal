package com.ejemplo.usuarios.domain.exception;

public class EmailInvalidoException extends RuntimeException{
    public EmailInvalidoException (String email) {
        super ("Email invalido: " + email);
    }
}
