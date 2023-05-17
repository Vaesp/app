package com.example.app.Models;

import javax.persistence.*;

@Entity
@Table(name = "tipoTransporte")
public class TipoTransporte {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    private String nombre;

    private String prefijo;

    public TipoTransporte() {
    }

    public TipoTransporte(Long id, String nombre, String prefijo) {
        this.id = id;
        this.nombre = nombre;
        this.prefijo = prefijo;
    }

    public TipoTransporte(String nombre, String prefijo) {
        this.nombre = nombre;
        this.prefijo = prefijo;
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

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }
}
