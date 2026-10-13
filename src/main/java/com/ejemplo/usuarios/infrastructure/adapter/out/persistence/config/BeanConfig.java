package com.ejemplo.usuarios.infrastructure.adapter.out.persistence.config;

import com.ejemplo.usuarios.application.port.in.CrearUsuarioUseCase;
import com.ejemplo.usuarios.application.port.out.UsuarioRepositoryPort;
import com.ejemplo.usuarios.application.service.CrearUsuarioService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public CrearUsuarioUseCase crearUsuarioUseCase(UsuarioRepositoryPort repository) {
        return new CrearUsuarioService(repository);
    }
}
