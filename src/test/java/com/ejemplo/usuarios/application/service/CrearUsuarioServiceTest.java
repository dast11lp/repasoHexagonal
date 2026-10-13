package com.ejemplo.usuarios.application.service;

import com.ejemplo.usuarios.application.port.out.UsuarioRepositoryPort;
import com.ejemplo.usuarios.domain.exception.EmailYaRegistradoException;
import com.ejemplo.usuarios.domain.model.Email;
import com.ejemplo.usuarios.domain.model.Usuario;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CrearUsuarioServiceTest {

    static class RepositorioEnMemoria implements UsuarioRepositoryPort {
        private final List<Usuario> usuarios = new ArrayList<>();


        @Override
        public Usuario guardar(Usuario usuario) {
            usuarios.add(usuario);
            return usuario;
        }

        @Override
        public boolean existePorEmail(Email email) {
           return usuarios.stream().anyMatch( u -> u.getEmail().equals(email));
        }
    }

    static class jejejajaja implements UsuarioRepositoryPort {

        @Override
        public Usuario guardar(Usuario usuario) {
            return null;
        }

        @Override
        public boolean existePorEmail(Email email) {
            return false;
        }
    }

    @Test
    void creaUsuario () {
        CrearUsuarioService service = new CrearUsuarioService(new RepositorioEnMemoria());

        Usuario usuario = service.crear("Ana", "ana@mail.com");

        assertEquals("Ana", usuario.getNombre());
        assertEquals("ana@mail.com", usuario.getEmail().valor());
    }

    @Test
    void rechazaEmailDuplicado() {
        CrearUsuarioService service = new CrearUsuarioService (new RepositorioEnMemoria());
        service.crear("Ana", "ana@mail.com");

        assertThrows(EmailYaRegistradoException.class,
                () -> service.crear("Otra", "ANA@mail.com"));
    }
}
