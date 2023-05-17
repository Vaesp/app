package com.example.app.Models.Tramites;

import com.example.app.Models.Vehiculo;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalDate;

@Entity
@Table(name = "mantenimiento", uniqueConstraints = {
        @UniqueConstraint(columnNames = "folio")
})
public class Mantenimiento {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    private String folio;

    private LocalDate fecha;

    private String responsable;

    private String descripcion;

    private String ubicacion;

    private String observaciones;

    private LocalDateTime timestamp;

    private LocalDateTime timestampEdit;

    private String userstamp;

    @ManyToOne
    private TipoMantenimiento tipoMantenimiento;

    @ManyToOne
    private EstatusTramite estatusTramite;

    @ManyToOne
    private Vehiculo vehiculo;

    public Mantenimiento() {
    }

    public Mantenimiento(Long id, String folio, LocalDate fecha, String responsable, String descripcion, String ubicacion, String observaciones, LocalDateTime timestamp, LocalDateTime timestampEdit, String userstamp, TipoMantenimiento tipoMantenimiento, EstatusTramite estatusTramite, Vehiculo vehiculo) {
        this.id = id;
        this.folio = folio;
        this.fecha = fecha;
        this.responsable = responsable;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.observaciones = observaciones;
        this.timestamp = timestamp;
        this.timestampEdit = timestampEdit;
        this.userstamp = userstamp;
        this.tipoMantenimiento = tipoMantenimiento;
        this.estatusTramite = estatusTramite;
        this.vehiculo = vehiculo;
    }

    public Mantenimiento(String folio, LocalDate fecha, String responsable, String descripcion, String ubicacion, String observaciones, LocalDateTime timestamp, LocalDateTime timestampEdit, String userstamp, TipoMantenimiento tipoMantenimiento, EstatusTramite estatusTramite, Vehiculo vehiculo) {
        this.folio = folio;
        this.fecha = fecha;
        this.responsable = responsable;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.observaciones = observaciones;
        this.timestamp = timestamp;
        this.timestampEdit = timestampEdit;
        this.userstamp = userstamp;
        this.tipoMantenimiento = tipoMantenimiento;
        this.estatusTramite = estatusTramite;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
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

    public TipoMantenimiento getTipoMantenimiento() {
        return tipoMantenimiento;
    }

    public void setTipoMantenimiento(TipoMantenimiento tipoMantenimiento) {
        this.tipoMantenimiento = tipoMantenimiento;
    }

    public EstatusTramite getEstatusTramite() {
        return estatusTramite;
    }

    public void setEstatusTramite(EstatusTramite estatusTramite) {
        this.estatusTramite = estatusTramite;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}
