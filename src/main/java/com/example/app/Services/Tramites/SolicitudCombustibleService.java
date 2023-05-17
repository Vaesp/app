package com.example.app.Services.Tramites;

import com.example.app.Models.Tramites.SolicitudCombustible;
import com.example.app.Repositories.Tramites.SolicitudCombustibleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitudCombustibleService {
    private final SolicitudCombustibleRepository solicitudCombustibleRepository;

    @Autowired
    public SolicitudCombustibleService(SolicitudCombustibleRepository solicitudCombustibleRepository) {
        this.solicitudCombustibleRepository = solicitudCombustibleRepository;
    }

    public List<SolicitudCombustible> getSolicitudCombustible(){
        return solicitudCombustibleRepository.findAll();
    }

    public void deleteSolicitudCombustible(Long solicitudCombustibleId) {
        boolean exists = solicitudCombustibleRepository.existsById(solicitudCombustibleId);
        if (!exists){
            throw new RuntimeException("La solicitud de combustible no existe");
        }
        solicitudCombustibleRepository.deleteById(solicitudCombustibleId);
    }
}