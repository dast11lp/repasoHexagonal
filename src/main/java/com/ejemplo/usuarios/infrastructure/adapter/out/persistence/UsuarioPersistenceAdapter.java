package com.ejemplo.usuarios.infrastructure.adapter.out.persistence;

import com.ejemplo.usuarios.application.port.out.UsuarioRepositoryPort;
import com.ejemplo.usuarios.domain.model.Email;
import com.ejemplo.usuarios.domain.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioPersistenceAdapter implements UsuarioRepositoryPort {
    private final UsuarioJpaRepository usuarioJpaRepository;
    private final UsuarioPersistenceMapper  mapper;

    public UsuarioPersistenceAdapter (UsuarioJpaRepository usuarioJpaRepository,
                                      UsuarioPersistenceMapper  mapper) {
        this.usuarioJpaRepository = usuarioJpaRepository;
        this.mapper = mapper;
    }


    @Override
    public Usuario guardar(Usuario usuario) {
        UsuarioJpaEntity usuarioEntidad = this.mapper.toJpa(usuario);
        UsuarioJpaEntity  usuarioGuardado = this.usuarioJpaRepository.save(usuarioEntidad);
        return mapper.toDomain(usuarioGuardado);
    }

    @Override
    public boolean existePorEmail(Email email) {
        return usuarioJpaRepository.existsByEmail(email.valor());
    }
}
