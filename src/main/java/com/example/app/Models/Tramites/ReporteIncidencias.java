package com.example.app.Models.Tramites;

import com.example.app.Models.Vehiculo;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "reporteIncidencias", uniqueConstraints = {
        @UniqueConstraint(columnNames = "folio")
})
public class ReporteIncidencias {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    private String folio;

    private LocalDate fecha;

    private String ubicacion;

    private String titulo;

    private String descripcion;

    private String observaciones;

    private LocalDateTime timestamp;

    private LocalDateTime timestampEdit;

    private String userstamp;

    @ManyToOne
    private Vehiculo vehiculo;

    public ReporteIncidencias() {
    }

    public ReporteIncidencias(Long id, String folio, LocalDate fecha, String ubicacion, String titulo, String descripcion, String observaciones, LocalDateTime timestamp, LocalDateTime timestampEdit, String userstamp, Vehiculo vehiculo) {
        this.id = id;
        this.folio = folio;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.observaciones = observaciones;
        this.timestamp = timestamp;
        this.timestampEdit = timestampEdit;
        this.userstamp = userstamp;
        this.vehiculo = vehiculo;
    }

    public ReporteIncidencias(String folio, LocalDate fecha, String ubicacion, String titulo, String descripcion, String observaciones, LocalDateTime timestamp, LocalDateTime timestampEdit, String userstamp, Vehiculo vehiculo) {
        this.folio = folio;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.observaciones = observaciones;
        this.timestamp = timestamp;
        this.timestampEdit = timestampEdit;
        this.userstamp = userstamp;
        this.vehiculo = vehiculo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
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

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}
