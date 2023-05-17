package com.example.app.Files;

import javax.persistence.*;

import com.example.app.Models.Resguardante;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity
@Table(name = "fileResguardante")
public class FileResguardante {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String name;

    private LocalDateTime timestamp;

    @ManyToOne
    private Resguardante resguardante;


    public FileResguardante() {
    }

    public FileResguardante(String name, LocalDateTime timestamp, Resguardante resguardante) {
        this.name = name;
        this.timestamp = timestamp;
        this.resguardante = resguardante;
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

    public Resguardante getResguardante() {
        return resguardante;
    }

    public void setResguardante(Resguardante resguardante) {
        this.resguardante = resguardante;
    }
}