package com.example.app.Services;

import com.example.app.Models.Aviso;
import com.example.app.Repositories.AvisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvisoService {

    private final AvisoRepository avisoRepository;

    @Autowired
    public AvisoService(AvisoRepository avisoRepository) {
        this.avisoRepository = avisoRepository;
    }

    public List<Aviso> getAviso(){
        return avisoRepository.findAll();
    }

    public void deleteAviso(Long avisoId) {
        boolean exists = avisoRepository.existsById(avisoId);
        if (!exists){
            throw new RuntimeException("El aviso no existe");
        }
        avisoRepository.deleteById(avisoId);
    }
}