package com.example.gestor_reservas.services;

import com.example.gestor_reservas.dao.ReservaDAO;
import com.example.gestor_reservas.entities.Reserva;

import java.sql.Date;

public class ReservaService {
    private ReservaDAO dao;

    public ReservaService(ReservaDAO dao) {
        this.dao = dao;
    }

    public void crearReserva(Reserva reserva) throws Exception {
        if (reserva.getFecha().before(new Date(System.currentTimeMillis()))) {
            throw new Exception("No se puede crear una reserva en el pasado");
        }
        dao.crear(reserva);
    }

    public Reserva obtenerReserva(int id) throws Exception {
        return dao.obtenerPorId(id);
    }

    public void cancelarReserva(int id) throws Exception {
        dao.cancelar(id);
    }
}
