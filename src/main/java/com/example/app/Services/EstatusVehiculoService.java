package com.example.app.Services;

import com.example.app.Models.EstatusVehiculo;
import com.example.app.Repositories.EstatusVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstatusVehiculoService {

    private final EstatusVehiculoRepository estatusVehiculoRepository;

    @Autowired
    public EstatusVehiculoService(EstatusVehiculoRepository estatusVehiculoRepository) {
        this.estatusVehiculoRepository = estatusVehiculoRepository;
    }

    public List<EstatusVehiculo> getEstatusVehiculo(){
        return estatusVehiculoRepository.findAll();
    }
}