package com.example.app.Models.Tramites;

import com.example.app.Models.Vehiculo;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "verificacion", uniqueConstraints = {
        @UniqueConstraint(columnNames = "folio")
})
public class Verificacion {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    private String folio;

    private LocalDate fecha;

    private String responsable;

    private String centroVerificacion;

    private String observaciones;

    private LocalDateTime timestamp;

    private LocalDateTime timestampEdit;

    private String userstamp;

    @ManyToOne
    private PeriodoVerificacion periodoVerificacion;

    @ManyToOne
    private Vehiculo vehiculo;

    public Verificacion() {
    }

    public Verificacion(Long id, String folio, LocalDate fecha, String responsable, String centroVerificacion, String observaciones, LocalDateTime timestamp, LocalDateTime timestampEdit, String userstamp, PeriodoVerificacion periodoVerificacion, Vehiculo vehiculo) {
        this.id = id;
        this.folio = folio;
        this.fecha = fecha;
        this.responsable = responsable;
        this.centroVerificacion = centroVerificacion;
        this.observaciones = observaciones;
        this.timestamp = timestamp;
        this.timestampEdit = timestampEdit;
        this.userstamp = userstamp;
        this.periodoVerificacion = periodoVerificacion;
        this.vehiculo = vehiculo;
    }

    public Verificacion(String folio, LocalDate fecha, String responsable, String centroVerificacion, String observaciones, LocalDateTime timestamp, LocalDateTime timestampEdit, String userstamp, PeriodoVerificacion periodoVerificacion, Vehiculo vehiculo) {
        this.folio = folio;
        this.fecha = fecha;
        this.responsable = responsable;
        this.centroVerificacion = centroVerificacion;
        this.observaciones = observaciones;
        this.timestamp = timestamp;
        this.timestampEdit = timestampEdit;
        this.userstamp = userstamp;
        this.periodoVerificacion = periodoVerificacion;
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

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getCentroVerificacion() {
        return centroVerificacion;
    }

    public void setCentroVerificacion(String centroVerificacion) {
        this.centroVerificacion = centroVerificacion;
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

    public PeriodoVerificacion getPeriodoVerificacion() {
        return periodoVerificacion;
    }

    public void setPeriodoVerificacion(PeriodoVerificacion periodoVerificacion) {
        this.periodoVerificacion = periodoVerificacion;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}