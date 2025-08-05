package com.example.gestor_reservas.controllers;

import com.example.gestor_reservas.entities.Reserva;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final List<Reserva> reservas = new ArrayList<>();
    private final AtomicInteger contadorId = new AtomicInteger(1);


    @GetMapping
    public List<Reserva> obtenerReservas() {
        return reservas;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Reserva> obtenerReservaPorId(@PathVariable int id) {
        Optional<Reserva> reserva = reservas.stream()
                .filter(r -> r.getId() == id)
                .findFirst();

        return reserva.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Reserva> crearReserva(@RequestBody Reserva nuevaReserva) {
        nuevaReserva.setId(contadorId.getAndIncrement());
        if (nuevaReserva.getFecha() == null) {
            nuevaReserva.setFecha(new Date(System.currentTimeMillis()));
        }
        reservas.add(nuevaReserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaReserva);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReserva(@PathVariable int id) {
        boolean removed = reservas.removeIf(r -> r.getId() == id);
        if (removed) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/{id}/estado")
    public ResponseEntity<Reserva> actualizarEstado(@PathVariable int id, @RequestParam String estado) {
        Optional<Reserva> reservaOpt = reservas.stream()
                .filter(r -> r.getId() == id)
                .findFirst();

        if (reservaOpt.isPresent()) {
            Reserva reserva = reservaOpt.get();
            reserva.setEstado(estado);
            return ResponseEntity.ok(reserva);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
