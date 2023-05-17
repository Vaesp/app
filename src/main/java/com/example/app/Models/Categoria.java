package com.example.app.Models;

import javax.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;


    private String nombre;

    @ManyToOne
    private TipoTransporte tipoTransporte;

    public Categoria() {
    }

    public Categoria(Long id, String nombre, TipoTransporte tipoTransporte) {
        this.id = id;
        this.nombre = nombre;
        this.tipoTransporte = tipoTransporte;
    }

    public Categoria(String nombre, TipoTransporte tipoTransporte) {
        this.nombre = nombre;
        this.tipoTransporte = tipoTransporte;
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

    public TipoTransporte getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(TipoTransporte tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }
}
