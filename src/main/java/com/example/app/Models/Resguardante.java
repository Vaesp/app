package com.example.app.Models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "resguardante", uniqueConstraints = {
        @UniqueConstraint(columnNames = "noLicencia")
})
public class Resguardante {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    private String nombre;

    private String cargo;

    private String noLicencia;

    private String tipoLicencia;

    private LocalDate vigenciaLicencia;

    private LocalDateTime timestamp;

    private LocalDateTime timestampEdit;

    private String userstamp;

    public Resguardante() {
    }

    public Resguardante(Long id, String nombre, String cargo, String noLicencia, String tipoLicencia, LocalDate vigenciaLicencia, LocalDateTime timestamp, LocalDateTime timestampEdit, String userstamp) {
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
        this.noLicencia = noLicencia;
        this.tipoLicencia = tipoLicencia;
        this.vigenciaLicencia = vigenciaLicencia;
        this.timestamp = timestamp;
        this.timestampEdit = timestampEdit;
        this.userstamp = userstamp;
    }

    public Resguardante(String nombre, String cargo, String noLicencia, String tipoLicencia, LocalDate vigenciaLicencia, LocalDateTime timestamp, LocalDateTime timestampEdit, String userstamp) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.noLicencia = noLicencia;
        this.tipoLicencia = tipoLicencia;
        this.vigenciaLicencia = vigenciaLicencia;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNoLicencia() {
        return noLicencia;
    }

    public void setNoLicencia(String noLicencia) {
        this.noLicencia = noLicencia;
    }

    public String getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    public LocalDate getVigenciaLicencia() {
        return vigenciaLicencia;
    }

    public void setVigenciaLicencia(LocalDate vigenciaLicencia) {
        this.vigenciaLicencia = vigenciaLicencia;
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
