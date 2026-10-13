package com.ejemplo.usuarios.domain.model;

import com.ejemplo.usuarios.domain.exception.EmailInvalidoException;

public record Email(String valor) {
    public Email {
        if (valor == null || !valor.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
            throw new EmailInvalidoException(valor);
        }

        valor = valor.toLowerCase();
    }
}
