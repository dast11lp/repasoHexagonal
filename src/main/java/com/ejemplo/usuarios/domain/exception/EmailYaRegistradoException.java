package com.ejemplo.usuarios.domain.exception;

import com.ejemplo.usuarios.domain.model.Email;

public class EmailYaRegistradoException extends  RuntimeException{
    public EmailYaRegistradoException (String email) {
        super ("El email ya está registrado: " + email);
    }
}
