package com.example.gestor_reservas.controllerSimulado;


import com.example.gestor_reservas.entities.Usuario;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/simulado/usuarios")
public class UsuarioControllerSimulado {

    @PostMapping
    @Operation(
            summary = "Crear usuario",
            description = "Crea un nuevo usuario en el sistema",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos del nuevo usuario",
                    required = true,
                    content = @Content(schema = @Schema(implementation = Usuario.class))
            ),
            responses = {
                    @ApiResponse(responseCode = "201", description = "Usuario creado exitosamente"),
                    @ApiResponse(responseCode = "400", description = "Datos inválidos")
            }
    )
    public ResponseEntity<Void> crear(@RequestBody Usuario usuario) {
        return ResponseEntity.status(201).build(); // Simulado
    }

    @GetMapping
    @Operation(
            summary = "Listar usuarios",
            description = "Devuelve una lista de todos los usuarios registrados",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Lista de usuarios",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Usuario.class))
                    )
            }
    )
    public ResponseEntity<List<Usuario>> listar() {
        return ResponseEntity.ok(List.of()); // Simulado
    }
}

