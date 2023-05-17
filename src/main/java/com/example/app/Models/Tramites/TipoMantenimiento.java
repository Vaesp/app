package com.example.app.Models.Tramites;

import javax.persistence.*;

@Entity
@Table(name = "tipoMantenimiento")
public class TipoMantenimiento {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;


    public String nombre;

    public TipoMantenimiento() {
    }

    public TipoMantenimiento(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public TipoMantenimiento(String nombre) {
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
