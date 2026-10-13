package com.ejemplo.usuarios.domain.model;

import java.util.UUID;

public record UsuarioId (UUID valor) {
    public static UsuarioId nuevo() {
        return new UsuarioId(UUID.randomUUID());
    }
}
