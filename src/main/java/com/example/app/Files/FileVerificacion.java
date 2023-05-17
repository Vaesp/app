package com.example.app.Files;

import com.example.app.Models.Tramites.Verificacion;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fileVerificacion")
public class FileVerificacion {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String name;

    private LocalDateTime timestamp;

    @ManyToOne
    private Verificacion verificacion;

    public FileVerificacion() {
    }

    public FileVerificacion(String name, LocalDateTime timestamp, Verificacion verificacion) {
        this.name = name;
        this.timestamp = timestamp;
        this.verificacion = verificacion;
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

    public Verificacion getVerificacion() {
        return verificacion;
    }

    public void setVerificacion(Verificacion verificacion) {
        this.verificacion = verificacion;
    }
}
