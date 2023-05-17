package com.example.app.Models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "aviso")
public class Aviso {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    private String titulo;

    private String descripcion;

    private LocalDateTime timestamp;

    private LocalDateTime timestampEdit;

    private String userstamp;

    public Aviso() {
    }

    public Aviso(Long id, String titulo, String descripcion, LocalDateTime timestamp, LocalDateTime timestampEdit, String userstamp) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.timestamp = timestamp;
        this.timestampEdit = timestampEdit;
        this.userstamp = userstamp;
    }

    public Aviso(String titulo, String descripcion, LocalDateTime timestamp, LocalDateTime timestampEdit, String userstamp) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.timestamp = timestamp;
        this.timestampEdit = timestampEdit;
        this.userstamp = userstamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public LocalDateTime getTimestampEdit() {
        return timestampEdit;
    }

    public void setTimestampEdit(LocalDateTime timestampEdit) {
        this.timestampEdit = timestampEdit;
    }

    public String getUserstamp() {
        return userstamp;
    }

    public void setUserstamp(String userstamp) {
        this.userstamp = userstamp;
    }
}
