package com.example.gestor_reservas.controller;

import com.example.gestor_reservas.entities.Usuario;
import com.example.gestor_reservas.services.UsuariosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuariosService service;

    public UsuarioController(UsuariosService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Crear usuario", description = "Crea un nuevo usuario")
    @ApiResponse(responseCode = "201", description = "Usuario creado")
    public ResponseEntity<Void> crear(@RequestBody Usuario u){
        service.registrarUsuario(u.getNombre(), u.getEmail());
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    @Operation(summary = "Listar usuarios")
    public List<Usuario> listar(){
        return service.obtenerUsuarios();
    }
}
