package com.example.app.Services.Tramites;

import com.example.app.Models.Tramites.CambioNeumaticos;
import com.example.app.Repositories.Tramites.CambioNeumaticosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CambioNeumaticosService {

    private final CambioNeumaticosRepository cambioNeumaticosRepository;

    @Autowired
    public CambioNeumaticosService(CambioNeumaticosRepository cambioNeumaticosRepository) {
        this.cambioNeumaticosRepository = cambioNeumaticosRepository;
    }

    public List<CambioNeumaticos> getCambioNeumaticos(){
        return cambioNeumaticosRepository.findAll();
    }

    public void deleteCambioNeumaticos(Long cambioNeumaticosId) {
        boolean exists = cambioNeumaticosRepository.existsById(cambioNeumaticosId);
        if (!exists){
            throw new RuntimeException("La solicitud de cambio de neumáticos no existe");
        }
        cambioNeumaticosRepository.deleteById(cambioNeumaticosId);
    }
}