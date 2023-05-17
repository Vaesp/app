package com.example.app.Services.Tramites;

import com.example.app.Models.Tramites.EstatusTramite;
import com.example.app.Repositories.Tramites.EstatusTramiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstatusTramiteService {

    private final EstatusTramiteRepository estatusTramiteRepository;

    @Autowired
    public EstatusTramiteService(EstatusTramiteRepository estatusTramiteRepository) {
        this.estatusTramiteRepository = estatusTramiteRepository;
    }

    public List<EstatusTramite> getEstatusTramite(){
        return estatusTramiteRepository.findAll();
    }
}