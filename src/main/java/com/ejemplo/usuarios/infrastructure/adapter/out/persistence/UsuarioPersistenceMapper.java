package com.ejemplo.usuarios.infrastructure.adapter.out.persistence;

import com.ejemplo.usuarios.domain.model.Email;
import com.ejemplo.usuarios.domain.model.Usuario;
import com.ejemplo.usuarios.domain.model.UsuarioId;
import org.springframework.stereotype.Component;

@Component
public class UsuarioPersistenceMapper {

    public UsuarioJpaEntity toJpa(Usuario usuario) {
        return new UsuarioJpaEntity(
                usuario.getId().valor(),
                usuario.getNombre(),
                usuario.getEmail().valor()
        );
    }

    public Usuario toDomain(UsuarioJpaEntity entity) {
        return new Usuario(
                new UsuarioId(entity.getId()),
                entity.getNombre(),
                new Email(entity.getEmail()));
    }
}
