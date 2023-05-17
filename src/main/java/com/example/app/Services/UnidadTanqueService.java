package com.example.app.Services;

import com.example.app.Models.UnidadTanque;
import com.example.app.Repositories.UnidadTanqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadTanqueService {

    private final UnidadTanqueRepository unidadTanqueRepository;

    @Autowired
    public UnidadTanqueService(UnidadTanqueRepository unidadTanqueRepository) {
        this.unidadTanqueRepository = unidadTanqueRepository;
    }

    public List<UnidadTanque> getUnidadTanque(){
        return unidadTanqueRepository.findAll();
    }
}