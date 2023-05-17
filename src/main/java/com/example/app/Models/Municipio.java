package com.example.app.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "municipio")
public class Municipio {
    @Id
    private Long id;
    private String municipio;

    public Municipio() {
    }

    public Municipio(Long id, String municipio) {
        this.id = id;
        this.municipio = municipio;
    }

    public Municipio(String municipio) {
        this.municipio = municipio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
}
