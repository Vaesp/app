package com.example.app.Services.Tramites;

import com.example.app.Models.Tramites.TipoSolicitud;
import com.example.app.Repositories.Tramites.TipoSolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoSolicitudService {

    private final TipoSolicitudRepository tipoSolicitudRepository;

    @Autowired
    public TipoSolicitudService(TipoSolicitudRepository tipoSolicitudRepository) {
        this.tipoSolicitudRepository = tipoSolicitudRepository;
    }

    public List<TipoSolicitud> getTipoSolicitud(){
        return tipoSolicitudRepository.findAll();
    }
}