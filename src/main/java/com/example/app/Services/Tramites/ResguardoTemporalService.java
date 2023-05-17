package com.example.app.Services.Tramites;

import com.example.app.Models.Tramites.ResguardoTemporal;
import com.example.app.Repositories.Tramites.ResguardoTemporalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResguardoTemporalService {

    private final ResguardoTemporalRepository resguardoTemporalRepository;

    @Autowired
    public ResguardoTemporalService(ResguardoTemporalRepository resguardoTemporalRepository) {
        this.resguardoTemporalRepository = resguardoTemporalRepository;
    }

    public List<ResguardoTemporal> getResguardoTemporal(){
        return resguardoTemporalRepository.findAll();
    }

    public void deleteResguardoTemporal(Long resguardoId) {
        boolean exists = resguardoTemporalRepository.existsById(resguardoId);
        if (!exists){
            throw new RuntimeException("El reporte de incidencias no existe");
        }
        resguardoTemporalRepository.deleteById(resguardoId);
    }
}