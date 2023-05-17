package com.example.app.Models.Tramites;

import com.example.app.Models.Vehiculo;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalDate;

@Entity
@Table(name = "cambioNeumaticos", uniqueConstraints = {
        @UniqueConstraint(columnNames = "folio")
})public class CambioNeumaticos {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    private String folio;

    private LocalDate fecha;

    private String responsable;

    private Boolean neumatico1;

    private String neumatico1Descripcion;

    private Boolean neumatico2;

    private String neumatico2Descripcion;

    private Boolean neumatico3;

    private String neumatico3Descripcion;

    private Boolean neumatico4;

    private String neumatico4Descripcion;

    private Boolean neumatico5;

    private String neumatico5Descripcion;

    private Boolean neumatico6;

    private String neumatico6Descripcion;

    private Boolean neumaticoR;

    private String neumaticoRDescripcion;

    private String observaciones;

    private LocalDateTime timestamp;

    private LocalDateTime timestampEdit;

    private String userstamp;

    @ManyToOne
    private Vehiculo vehiculo;

    public CambioNeumaticos() {
    }

    public CambioNeumaticos(Long id, String folio, LocalDate fecha, String responsable, Boolean neumatico1, String neumatico1Descripcion, Boolean neumatico2, String neumatico2Descripcion, Boolean neumatico3, String neumatico3Descripcion, Boolean neumatico4, String neumatico4Descripcion, Boolean neumatico5, String neumatico5Descripcion, Boolean neumatico6, String neumatico6Descripcion, Boolean neumaticoR, String neumaticoRDescripcion, String observaciones, LocalDateTime timestamp, LocalDateTime timestampEdit, String userstamp, Vehiculo vehiculo) {
        this.id = id;
        this.folio = folio;
        this.fecha = fecha;
        this.responsable = responsable;
        this.neumatico1 = neumatico1;
        this.neumatico1Descripcion = neumatico1Descripcion;
        this.neumatico2 = neumatico2;
        this.neumatico2Descripcion = neumatico2Descripcion;
        this.neumatico3 = neumatico3;
        this.neumatico3Descripcion = neumatico3Descripcion;
        this.neumatico4 = neumatico4;
        this.neumatico4Descripcion = neumatico4Descripcion;
        this.neumatico5 = neumatico5;
        this.neumatico5Descripcion = neumatico5Descripcion;
        this.neumatico6 = neumatico6;
        this.neumatico6Descripcion = neumatico6Descripcion;
        this.neumaticoR = neumaticoR;
        this.neumaticoRDescripcion = neumaticoRDescripcion;
        this.observaciones = observaciones;
        this.timestamp = timestamp;
        this.timestampEdit = timestampEdit;
        this.userstamp = userstamp;
        this.vehiculo = vehiculo;
    }

    public CambioNeumaticos(String folio, LocalDate fecha, String responsable, Boolean neumatico1, String neumatico1Descripcion, Boolean neumatico2, String neumatico2Descripcion, Boolean neumatico3, String neumatico3Descripcion, Boolean neumatico4, String neumatico4Descripcion, Boolean neumatico5, String neumatico5Descripcion, Boolean neumatico6, String neumatico6Descripcion, Boolean neumaticoR, String neumaticoRDescripcion, String observaciones, LocalDateTime timestamp, LocalDateTime timestampEdit, String userstamp, Vehiculo vehiculo) {
        this.folio = folio;
        this.fecha = fecha;
        this.responsable = responsable;
        this.neumatico1 = neumatico1;
        this.neumatico1Descripcion = neumatico1Descripcion;
        this.neumatico2 = neumatico2;
        this.neumatico2Descripcion = neumatico2Descripcion;
        this.neumatico3 = neumatico3;
        this.neumatico3Descripcion = neumatico3Descripcion;
        this.neumatico4 = neumatico4;
        this.neumatico4Descripcion = neumatico4Descripcion;
        this.neumatico5 = neumatico5;
        this.neumatico5Descripcion = neumatico5Descripcion;
        this.neumatico6 = neumatico6;
        this.neumatico6Descripcion = neumatico6Descripcion;
        this.neumaticoR = neumaticoR;
        this.neumaticoRDescripcion = neumaticoRDescripcion;
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

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public Boolean getNeumatico1() {
        return neumatico1;
    }

    public void setNeumatico1(Boolean neumatico1) {
        this.neumatico1 = neumatico1;
    }

    public String getNeumatico1Descripcion() {
        return neumatico1Descripcion;
    }

    public void setNeumatico1Descripcion(String neumatico1Descripcion) {
        this.neumatico1Descripcion = neumatico1Descripcion;
    }

    public Boolean getNeumatico2() {
        return neumatico2;
    }

    public void setNeumatico2(Boolean neumatico2) {
        this.neumatico2 = neumatico2;
    }

    public String getNeumatico2Descripcion() {
        return neumatico2Descripcion;
    }

    public void setNeumatico2Descripcion(String neumatico2Descripcion) {
        this.neumatico2Descripcion = neumatico2Descripcion;
    }

    public Boolean getNeumatico3() {
        return neumatico3;
    }

    public void setNeumatico3(Boolean neumatico3) {
        this.neumatico3 = neumatico3;
    }

    public String getNeumatico3Descripcion() {
        return neumatico3Descripcion;
    }

    public void setNeumatico3Descripcion(String neumatico3Descripcion) {
        this.neumatico3Descripcion = neumatico3Descripcion;
    }

    public Boolean getNeumatico4() {
        return neumatico4;
    }

    public void setNeumatico4(Boolean neumatico4) {
        this.neumatico4 = neumatico4;
    }

    public String getNeumatico4Descripcion() {
        return neumatico4Descripcion;
    }

    public void setNeumatico4Descripcion(String neumatico4Descripcion) {
        this.neumatico4Descripcion = neumatico4Descripcion;
    }

    public Boolean getNeumatico5() {
        return neumatico5;
    }

    public void setNeumatico5(Boolean neumatico5) {
        this.neumatico5 = neumatico5;
    }

    public String getNeumatico5Descripcion() {
        return neumatico5Descripcion;
    }

    public void setNeumatico5Descripcion(String neumatico5Descripcion) {
        this.neumatico5Descripcion = neumatico5Descripcion;
    }

    public Boolean getNeumatico6() {
        return neumatico6;
    }

    public void setNeumatico6(Boolean neumatico6) {
        this.neumatico6 = neumatico6;
    }

    public String getNeumatico6Descripcion() {
        return neumatico6Descripcion;
    }

    public void setNeumatico6Descripcion(String neumatico6Descripcion) {
        this.neumatico6Descripcion = neumatico6Descripcion;
    }

    public Boolean getNeumaticoR() {
        return neumaticoR;
    }

    public void setNeumaticoR(Boolean neumaticoR) {
        this.neumaticoR = neumaticoR;
    }

    public String getNeumaticoRDescripcion() {
        return neumaticoRDescripcion;
    }

    public void setNeumaticoRDescripcion(String neumaticoRDescripcion) {
        this.neumaticoRDescripcion = neumaticoRDescripcion;
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
