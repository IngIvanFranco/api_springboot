package com.example.demo.services;

import com.example.demo.entitys.Usuario;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UsuarioService {
    public abstract List<Usuario> getUsuarios();

    public abstract ResponseEntity<Usuario> createUsr(Usuario usuario);

    public abstract ResponseEntity<Usuario> updateUsr(String id, Usuario Usuario);
}
