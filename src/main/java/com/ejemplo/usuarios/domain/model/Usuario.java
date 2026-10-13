package com.ejemplo.usuarios.domain.model;

public class Usuario {
    private final UsuarioId id;
    private String nombre;
    private final Email email;

    public Usuario (UsuarioId id, String nombre, Email email) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }


    public UsuarioId getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Email getEmail() {
        return email;
    }
}
