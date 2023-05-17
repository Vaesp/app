package com.example.app.Services;

import com.example.app.Models.TipoTransporte;
import com.example.app.Repositories.TipoTransporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoTransporteService {

    private final TipoTransporteRepository tipoTransporteRepository;

    @Autowired
    public TipoTransporteService(TipoTransporteRepository tipoTransporteRepository) {
        this.tipoTransporteRepository = tipoTransporteRepository;
    }

    public List<TipoTransporte> getTipoTransporte(){
        return tipoTransporteRepository.findAll();
    }
}