package com.example.app.Models;


import javax.persistence.*;

@Entity
@Table(name = "estatusVehiculo")
public class EstatusVehiculo {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    public String nombre;

    public EstatusVehiculo() {
    }

    public EstatusVehiculo(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }


    public EstatusVehiculo(String nombre) {
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
