package com.ejemplo.usuarios.infrastructure.adapter.in.web;

import com.ejemplo.usuarios.domain.model.Usuario;

import java.util.UUID;

public record UsuarioResponse(UUID id, String nombre, String email) {
    public static UsuarioResponse from (Usuario usuario) {
        return new UsuarioResponse(
                usuario.getId().valor(),
                usuario.getNombre(),
                usuario.getEmail().valor()
        );
    }
}
