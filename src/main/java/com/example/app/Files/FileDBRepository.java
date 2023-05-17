package com.example.app.Files;

import com.example.app.Models.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {
    List<FileDB> findByVehiculo(Vehiculo vehiculo);
}