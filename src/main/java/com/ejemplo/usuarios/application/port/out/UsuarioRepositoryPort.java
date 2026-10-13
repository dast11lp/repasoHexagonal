package com.ejemplo.usuarios.application.port.out;

import com.ejemplo.usuarios.domain.model.Email;
import com.ejemplo.usuarios.domain.model.Usuario;

public interface UsuarioRepositoryPort {
    Usuario guardar (Usuario usuario);
    boolean existePorEmail (Email email);
}
