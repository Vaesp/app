package com.example.app.Files;

import com.example.app.Models.Tramites.ReporteIncidencias;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fileIncidencia")
public class FileIncidencia {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String name;

    private LocalDateTime timestamp;

    @ManyToOne
    private ReporteIncidencias reporteIncidencias;

    public FileIncidencia() {
    }

    public FileIncidencia(String name, LocalDateTime timestamp, ReporteIncidencias reporteIncidencias) {
        this.name = name;
        this.timestamp = timestamp;
        this.reporteIncidencias = reporteIncidencias;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public ReporteIncidencias getReporteIncidencias() {
        return reporteIncidencias;
    }

    public void setReporteIncidencias(ReporteIncidencias reporteIncidencias) {
        this.reporteIncidencias = reporteIncidencias;
    }
}
