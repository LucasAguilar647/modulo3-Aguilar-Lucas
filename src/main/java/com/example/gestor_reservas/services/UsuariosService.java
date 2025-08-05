package com.example.gestor_reservas.services;

import com.example.gestor_reservas.entities.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuariosService {
    private final List<Usuario> usuarios = new ArrayList<>();
    private int proximoId = 1;

    public void registrarUsuario(String nombre, String email) {
        usuarios.add(new Usuario(proximoId++, nombre, email));
    }

    public List<Usuario> obtenerUsuarios() {
        return usuarios;
    }
}
