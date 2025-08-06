package com.example.gestor_reservas.controllerSimulado;


import com.example.gestor_reservas.entities.Reserva;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/simulado/reservas")
public class ReservaControllerSimulado {

    @GetMapping
    @Operation(
            summary = "Obtener todas las reservas",
            description = "Devuelve todas las reservas disponibles",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de reservas",
                            content = @Content(schema = @Schema(implementation = Reserva.class)))
            }
    )
    public ResponseEntity<List<Reserva>> obtenerReservas() {
        return ResponseEntity.ok(List.of()); // Simulado
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Obtener reserva por ID",
            description = "Devuelve la reserva con el ID especificado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Reserva encontrada",
                            content = @Content(schema = @Schema(implementation = Reserva.class))),
                    @ApiResponse(responseCode = "404", description = "Reserva no encontrada")
            }
    )
    public ResponseEntity<Reserva> obtenerPorId(
            @Parameter(description = "ID de la reserva", required = true) @PathVariable int id) {
        return ResponseEntity.of(java.util.Optional.empty()); // Simulado
    }

    @PostMapping
    @Operation(
            summary = "Crear nueva reserva",
            description = "Crea una nueva reserva con los datos proporcionados",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos de la reserva",
                    required = true,
                    content = @Content(schema = @Schema(implementation = Reserva.class))
            ),
            responses = {
                    @ApiResponse(responseCode = "201", description = "Reserva creada"),
                    @ApiResponse(responseCode = "400", description = "Datos inválidos")
            }
    )
    public ResponseEntity<Reserva> crear(@RequestBody Reserva reserva) {
        return ResponseEntity.status(201).body(reserva); // Simulado
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Eliminar reserva",
            description = "Elimina la reserva con el ID proporcionado",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Reserva eliminada"),
                    @ApiResponse(responseCode = "404", description = "Reserva no encontrada")
            }
    )
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        return ResponseEntity.noContent().build(); // Simulado
    }

    @PutMapping("/{id}/estado")
    @Operation(
            summary = "Actualizar estado de reserva",
            description = "Actualiza el estado de una reserva",
            parameters = {
                    @Parameter(name = "id", description = "ID de la reserva", required = true),
                    @Parameter(name = "estado", description = "Nuevo estado de la reserva", required = true)
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Estado actualizado",
                            content = @Content(schema = @Schema(implementation = Reserva.class))),
                    @ApiResponse(responseCode = "404", description = "Reserva no encontrada")
            }
    )
    public ResponseEntity<Reserva> actualizarEstado(@PathVariable int id, @RequestParam String estado) {
        return ResponseEntity.of(java.util.Optional.empty()); // Simulado
    }
}

