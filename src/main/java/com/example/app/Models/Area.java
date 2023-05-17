package com.example.app.Models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "area", uniqueConstraints = {
        @UniqueConstraint(columnNames = "nombreArea")
})
public class Area {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    private String nombreArea;

    private String nombreJefe;

    private LocalDateTime timestamp;

    private LocalDateTime timestampEdit;

    private String userstamp;

    public Area() {
    }

    public Area(Long id, String nombreArea, String nombreJefe, LocalDateTime timestamp, LocalDateTime timestampEdit, String userstamp) {
        this.id = id;
        this.nombreArea = nombreArea;
        this.nombreJefe = nombreJefe;
        this.timestamp = timestamp;
        this.timestampEdit = timestampEdit;
        this.userstamp = userstamp;
    }

    public Area(String nombreArea, String nombreJefe, LocalDateTime timestamp, LocalDateTime timestampEdit, String userstamp) {
        this.nombreArea = nombreArea;
        this.nombreJefe = nombreJefe;
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

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    public String getNombreJefe() {
        return nombreJefe;
    }

    public void setNombreJefe(String nombreJefe) {
        this.nombreJefe = nombreJefe;
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
