package com.ejemplo.usuarios.infrastructure.adapter.in.web;

import jakarta.validation.constraints.NotBlank;

public record CrearUsuarioRequest (
        @NotBlank String nombre,
        @NotBlank String email
) {}
