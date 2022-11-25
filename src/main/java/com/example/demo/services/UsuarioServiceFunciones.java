package com.example.demo.services;

import com.example.demo.entitys.Usuario;
import com.example.demo.repository.UsuarioRepository;
import com.sun.jdi.LongValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service

public class UsuarioServiceFunciones implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceFunciones(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public ResponseEntity<Usuario> createUsr(Usuario usuario){
            usuario.setEstado(1);
            usuario.setId(0L);
        return new ResponseEntity<>(usuarioRepository.save(usuario), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Usuario> updateUsr(String id, Usuario usuario){
        if (usuarioRepository.existsById(Long.valueOf(id))) {
            return new ResponseEntity<>(usuarioRepository.findById(Long.valueOf(id))
                    .map(usuario1 -> {
                        usuario1.setNombre(usuario.getNombre());
                        usuario1.setApellido(usuario.getApellido());
                        usuario1.setIdentificacion(usuario.getIdentificacion());
                        usuario1.setEstado(1);
                        return usuarioRepository.save(usuario1);
                    }).get(), HttpStatus.OK);

        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuario no Encontrado");
    }


}
