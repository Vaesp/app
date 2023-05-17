package com.example.app.Files;

import com.example.app.Models.Tramites.ReporteIncidencias;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileIncidenciaRepository extends JpaRepository<FileIncidencia, String> {
    List<FileIncidencia> findByReporteIncidencias(ReporteIncidencias reporteIncidencias);
}
