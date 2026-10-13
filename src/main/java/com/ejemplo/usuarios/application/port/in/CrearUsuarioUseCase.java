package com.ejemplo.usuarios.application.port.in;

import com.ejemplo.usuarios.domain.model.Usuario;

public interface CrearUsuarioUseCase {
    Usuario crear(String nombre, String email);
}
