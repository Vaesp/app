package com.example.app.Models;

import javax.persistence.*;

@Entity
@Table(name = "tipoCombustible")
public class TipoCombustible {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;


    public String nombre;

    public TipoCombustible() {
    }

    public TipoCombustible(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public TipoCombustible(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
