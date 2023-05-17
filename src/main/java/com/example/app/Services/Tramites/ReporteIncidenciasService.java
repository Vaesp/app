package com.example.app.Services.Tramites;

import com.example.app.Models.Tramites.ReporteIncidencias;
import com.example.app.Repositories.Tramites.ReporteIncidenciasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteIncidenciasService {

    private final ReporteIncidenciasRepository reporteIncidenciasRepository;

    @Autowired
    public ReporteIncidenciasService(ReporteIncidenciasRepository reporteIncidenciasRepository) {
        this.reporteIncidenciasRepository = reporteIncidenciasRepository;
    }

    public List<ReporteIncidencias> getReporteIncidencias(){
        return reporteIncidenciasRepository.findAll();
    }

    public void deleteReporteIncidencias(Long reporteId) {
        boolean exists = reporteIncidenciasRepository.existsById(reporteId);
        if (!exists){
            throw new RuntimeException("El reporte de incidencias no existe");
        }
        reporteIncidenciasRepository.deleteById(reporteId);
    }
}