package com.example.app.Services;

import com.example.app.Models.Area;
import com.example.app.Repositories.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaService {

    private final AreaRepository areaRepository;

    @Autowired
    public AreaService(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public List<Area> getArea(){
        return areaRepository.findAll();
    }

    public void deleteArea(Long areaId) {
        boolean exists = areaRepository.existsById(areaId);
        if (!exists){
            throw new RuntimeException("El área no existe");
        }
        areaRepository.deleteById(areaId);
    }
}