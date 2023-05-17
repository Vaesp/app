package com.example.app.Models;

import javax.persistence.*;

@Entity
@Table(name = "contador")
public class Contador {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    private String nombreTramite;

    private String abreviatura;

    private Integer contador;

    private String ultimo;

    public Contador() {
    }

    public Contador(Long id, String nombreTramite, String abreviatura, Integer contador, String ultimo) {
        this.id = id;
        this.nombreTramite = nombreTramite;
        this.abreviatura = abreviatura;
        this.contador = contador;
        this.ultimo = ultimo;
    }

    public Contador(String nombreTramite, String abreviatura, Integer contador, String ultimo) {
        this.nombreTramite = nombreTramite;
        this.abreviatura = abreviatura;
        this.contador = contador;
        this.ultimo = ultimo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreTramite() {
        return nombreTramite;
    }

    public void setNombreTramite(String nombreTramite) {
        this.nombreTramite = nombreTramite;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    public String getUltimo() {
        return ultimo;
    }

    public void setUltimo(String ultimo) {
        this.ultimo = ultimo;
    }
}
