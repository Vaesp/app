package com.example.app.Services;

import com.example.app.Repositories.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    @Autowired
    public VehiculoService(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    public void deleteVehiculo(Long reporteId) {
        boolean exists = vehiculoRepository.existsById(reporteId);
        if(!exists){
            throw new IllegalStateException("El vehículo no existe");
        }
        vehiculoRepository.deleteById(reporteId);
    }
}