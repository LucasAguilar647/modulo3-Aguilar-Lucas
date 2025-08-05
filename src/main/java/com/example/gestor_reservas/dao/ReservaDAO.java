package com.example.gestor_reservas.dao;

import com.example.gestor_reservas.entities.Reserva;
import com.example.gestor_reservas.utils.DBConnection;

import java.sql.*;

public class ReservaDAO {

    public ReservaDAO() {
        crearTablaSiNoExiste();
    }

    private void crearTablaSiNoExiste() {
        String sql = "CREATE TABLE IF NOT EXISTS reservas (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "fecha DATE NOT NULL, " +
                "estado TEXT NOT NULL, " +
                "usuario_id INTEGER NOT NULL, " +
                "FOREIGN KEY (usuario_id) REFERENCES usuarios(id))";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Error al crear tabla reservas: " + e.getMessage());
        }
    }

    public void crear(Reserva reserva) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO reservas (fecha, estado, usuario_id) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setDate(1, reserva.getFecha());
        stmt.setString(2, reserva.getEstado());
        stmt.setInt(3, reserva.getUsuarioId());
        stmt.executeUpdate();
        conn.close();
    }

    public Reserva obtenerPorId(int id) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM reservas WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Reserva r = null;
        if (rs.next()) {
            r = new Reserva(rs.getInt("id"), rs.getDate("fecha"), rs.getString("estado"), rs.getInt("usuario_id"));
        }
        conn.close();
        return r;
    }

    public void cancelar(int id) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "UPDATE reservas SET estado = 'cancelada' WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        conn.close();
    }
}
