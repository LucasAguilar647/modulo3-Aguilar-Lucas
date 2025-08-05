package com.example.gestor_reservas;

import com.example.gestor_reservas.dao.ReservaDAO;
import com.example.gestor_reservas.dao.UsuarioDAO;
import com.example.gestor_reservas.entities.Reserva;
import com.example.gestor_reservas.entities.Usuario;
import com.example.gestor_reservas.services.ReservaService;

import java.sql.Date;
import java.util.List;

public class MainTest {
    public static void main(String[] args) throws Exception {

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ReservaDAO reservaDAO = new ReservaDAO();
        ReservaService reservaService = new ReservaService(reservaDAO);
        usuarioDAO.resetearTablaUsuarios();


        Usuario usuario = new Usuario(0,"Juan Pérez", "juan@gmail.com");
        usuarioDAO.crear(usuario);
        System.out.println("Usuario creado.");
        Usuario usuario1 = new Usuario(1,"Lucas Aguilar", "lucas@gmail.com");
        usuarioDAO.crear(usuario1);
        System.out.println("Usuario1 creado.");


        List<Usuario> usuarios = usuarioDAO.obtenerTodos();
        System.out.println("Lista de usuarios:");
        for (Usuario u : usuarios) {
            System.out.println("Nombre      : " + u.getNombre());

        }


        int usuarioId = usuarios.get(0).getId();


        Date fechaReserva = Date.valueOf("2030-01-01");
        Reserva reserva = new Reserva();
        reserva.setFecha(fechaReserva);
        reserva.setEstado("activa");
        reserva.setUsuarioId(usuarioId);
        reservaService.crearReserva(reserva);
        System.out.println(" Reserva creada.");


        Reserva r = reservaService.obtenerReserva(1);
        if (r != null) {
            System.out.println("Reserva obtenida:");
            System.out.println(r);
        } else {
            System.out.println(" No se encontró la reserva.");
        }


        reservaService.cancelarReserva(1);
        System.out.println("Reserva cancelada.");


        Reserva cancelada = reservaService.obtenerReserva(1);
        System.out.println("Estado de la reserva después de cancelar:");
        System.out.println(cancelada);
    }
}
