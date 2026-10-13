package com.ejemplo.usuarios.infrastructure.adapter.in.web;


import com.ejemplo.usuarios.application.port.in.CrearUsuarioUseCase;
import com.ejemplo.usuarios.domain.model.Usuario;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CrearUsuarioUseCase crearUsuario;

    public UsuarioController (CrearUsuarioUseCase crearUsuario) {
        this.crearUsuario = crearUsuario;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> crear (@Valid @RequestBody CrearUsuarioRequest request) {
        Usuario usuario = this.crearUsuario.crear(request.nombre(), request.email());
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioResponse.from(usuario));
    }
}
