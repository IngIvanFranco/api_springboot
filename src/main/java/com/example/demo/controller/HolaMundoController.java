package com.example.demo.controller;

import com.example.demo.entitys.Usuario;
import com.example.demo.services.UsuarioService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping()
public class HolaMundoController {
    private final UsuarioService usuarioService;

    public HolaMundoController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/hola")
    public String saludar(){
        return "HOla Mundo 😁";
    }

    @GetMapping("/usr")
    public List<Usuario> getUsr(){
        return usuarioService.getUsuarios();
    }

    @PostMapping(value = "/usr",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario>  createusr(@RequestBody Usuario usuario){
        return usuarioService.createUsr(usuario);
    }

    @PutMapping(value = "/usr/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> updateusr(@PathVariable String id, @RequestBody Usuario usuario){
        return  usuarioService.updateUsr(id,usuario);
    }



}
