package com.example.app.Files;

import com.example.app.Models.Tramites.Verificacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileVerificacionRepository extends JpaRepository<FileVerificacion, String> {
    List<FileVerificacion> findById(Verificacion verificacion);
}
