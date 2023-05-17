package com.example.app.Services.Tramites;

import com.example.app.Models.Tramites.PeriodoVerificacion;
import com.example.app.Repositories.Tramites.PeriodoVerificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodoVerificacionService {

    private final PeriodoVerificacionRepository periodoVerificacionRepository;

    @Autowired
    public PeriodoVerificacionService(PeriodoVerificacionRepository periodoVerificacionRepository) {
        this.periodoVerificacionRepository = periodoVerificacionRepository;
    }

    public List<PeriodoVerificacion> getPeriodoVerififcacion(){
        return periodoVerificacionRepository.findAll();
    }
}