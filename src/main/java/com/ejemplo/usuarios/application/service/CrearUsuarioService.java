package com.ejemplo.usuarios.application.service;

import com.ejemplo.usuarios.application.port.in.CrearUsuarioUseCase;
import com.ejemplo.usuarios.application.port.out.UsuarioRepositoryPort;
import com.ejemplo.usuarios.domain.exception.EmailYaRegistradoException;
import com.ejemplo.usuarios.domain.model.Email;
import com.ejemplo.usuarios.domain.model.Usuario;
import com.ejemplo.usuarios.domain.model.UsuarioId;

public class CrearUsuarioService implements CrearUsuarioUseCase {
    private final UsuarioRepositoryPort repository;

    public CrearUsuarioService(UsuarioRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Usuario crear(String nombre, String email) {
        Email formatoEmailValido = new Email(email);

        if (repository.existePorEmail(formatoEmailValido)) {
            throw new EmailYaRegistradoException(formatoEmailValido.valor());
        }

        Usuario usuario = new Usuario(UsuarioId.nuevo(), nombre, formatoEmailValido);
        return repository.guardar(usuario);
    }
}
