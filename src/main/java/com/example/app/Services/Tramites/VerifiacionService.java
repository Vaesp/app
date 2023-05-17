package com.example.app.Services.Tramites;

import com.example.app.Repositories.Tramites.VerificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerifiacionService {

    private final VerificacionRepository verificacionRepository;

    @Autowired
    public VerifiacionService(VerificacionRepository verificacionRepository) {
        this.verificacionRepository = verificacionRepository;
    }

    public void deleteVerificacion(Long verificacionId) {
        boolean exists = verificacionRepository.existsById(verificacionId);
        if (!exists){
            throw new RuntimeException("La verificación no existe");
        }
        verificacionRepository.deleteById(verificacionId);
    }
}