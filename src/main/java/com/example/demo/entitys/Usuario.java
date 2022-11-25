package com.example.demo.entitys;


import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="usuario")

public class Usuario {
@Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy= IDENTITY)
    private  Long id;

@Column(name="identificacion",length = 250)
    private String identificacion;

    @Column(name="nombre",length = 250)
    private String nombre;

    @Column(name="apellido",length = 250)
    private String apellido;

    @Column(name="estado")
    private Integer estado;

    public Usuario(Long id, String identificacion, String nombre, String apellido, Integer estado) {
        this.id = id;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
    }

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

}
