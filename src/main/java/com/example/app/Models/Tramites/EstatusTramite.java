package com.example.app.Models.Tramites;

import javax.persistence.*;

@Entity
@Table(name = "estatusTramite")
public class EstatusTramite {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    public String nombre;

    public EstatusTramite() {
    }

    public EstatusTramite(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public EstatusTramite(String nombre) {
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
