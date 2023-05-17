package com.example.app.Services;

import com.example.app.Models.Resguardante;
import com.example.app.Repositories.ResguardanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResguardanteService {

    private final ResguardanteRepository resguardanteRepository;

    @Autowired
    public ResguardanteService(ResguardanteRepository resguardanteRepository) {
        this.resguardanteRepository = resguardanteRepository;
    }

    public List<Resguardante> getResguardante(){
        return resguardanteRepository.findAll();
    }

    public void deleteResguardante(Long resguardanteId) {
        boolean exists = resguardanteRepository.existsById(resguardanteId);
        if (!exists){
            throw new RuntimeException("El resguardante no existe");
        }
        resguardanteRepository.deleteById(resguardanteId);
    }
}