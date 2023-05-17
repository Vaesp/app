package com.example.app.Services;

import com.example.app.Models.Municipio;
import com.example.app.Repositories.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MunicipioService {
    private final MunicipioRepository municipioRepository;

    @Autowired
    public MunicipioService(MunicipioRepository municipioRepository) {
        this.municipioRepository = municipioRepository;
    }

    public List<Municipio> getMunicipio(){
        return municipioRepository.findAll();
    }
}