package com.example.app.Files;

import com.example.app.Models.Vehiculo;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fileVehiculo")
public class  FileVehiculo{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String name;

    private LocalDateTime timestamp;

    @ManyToOne
    private Vehiculo vehiculo;

    @ManyToOne
    private TipoFileVehiculo tipoFileVehiculo;

    public FileVehiculo() {
    }

    public FileVehiculo(String name, LocalDateTime timestamp, Vehiculo vehiculo, TipoFileVehiculo tipoFileVehiculo) {
        this.name = name;
        this.timestamp = timestamp;
        this.vehiculo = vehiculo;
        this.tipoFileVehiculo = tipoFileVehiculo;
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

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public TipoFileVehiculo getTipoFileVehiculo() {
        return tipoFileVehiculo;
    }

    public void setTipoFileVehiculo(TipoFileVehiculo tipoFileVehiculo) {
        this.tipoFileVehiculo = tipoFileVehiculo;
    }
}
