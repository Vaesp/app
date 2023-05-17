package com.example.app.Services.Tramites;

import com.example.app.Models.Tramites.Mantenimiento;
import com.example.app.Repositories.Tramites.MantenimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MantenimientoService {
    private final MantenimientoRepository mantenimientoRepository;

    @Autowired
    public MantenimientoService(MantenimientoRepository mantenimientoRepository) {
        this.mantenimientoRepository = mantenimientoRepository;
    }

    public List<Mantenimiento> getMantenimiento(){
        return mantenimientoRepository.findAll();
    }

    public void deleteMantenimiento(Long mantenimientoId) {
        boolean exists = mantenimientoRepository.existsById(mantenimientoId);
        if (!exists){
            throw new RuntimeException("La solicitud de mantenimiento no existe");
        }
        mantenimientoRepository.deleteById(mantenimientoId);
    }
}