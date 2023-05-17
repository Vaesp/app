package com.example.app.Files;

import com.example.app.Models.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileVehiculoRepository extends JpaRepository<FileVehiculo, String> {
    List<FileVehiculo> findByVehiculo(Vehiculo vehiculo);
    FileVehiculo deleteByName(String filename);
}
