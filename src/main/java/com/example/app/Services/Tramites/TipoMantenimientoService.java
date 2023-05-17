package com.example.app.Services.Tramites;

import com.example.app.Models.Tramites.TipoMantenimiento;
import com.example.app.Repositories.Tramites.TipoMantenimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoMantenimientoService {

    private final TipoMantenimientoRepository tipoMantenimientoRepository;

    @Autowired
    public TipoMantenimientoService(TipoMantenimientoRepository tipoMantenimientoRepository){
        this.tipoMantenimientoRepository = tipoMantenimientoRepository;
    }

    public List<TipoMantenimiento> getTipoMantenimiento(){
        return tipoMantenimientoRepository.findAll();
    }
}