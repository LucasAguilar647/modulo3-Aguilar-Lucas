package com.example.gestor_reservas.entities;

import java.sql.Date;

public class Reserva {
    private int id;
    private Date fecha;
    private String estado;
    private int usuarioId;

    public Reserva(int id, Date fecha, String estado, int usuarioId) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.usuarioId = usuarioId;
    }

    public Reserva() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", fecha=" + fecha + ", estado='" + estado + '\'' + ", usuarioId=" + usuarioId + '}';
    }
}
