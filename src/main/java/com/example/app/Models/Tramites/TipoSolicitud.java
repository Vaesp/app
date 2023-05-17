package com.example.app.Models.Tramites;

import javax.persistence.*;

@Entity
@Table(name = "tipoSolicitud")
public class TipoSolicitud {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;


    public String nombre;

    public TipoSolicitud() {
    }

    public TipoSolicitud(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public TipoSolicitud(String nombre) {
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
