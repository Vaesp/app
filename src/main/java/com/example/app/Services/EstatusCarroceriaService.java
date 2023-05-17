package com.example.app.Services;

import com.example.app.Models.EstatusCarroceria;
import com.example.app.Repositories.EstatusCarroceriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstatusCarroceriaService {

    private final EstatusCarroceriaRepository estatusCarroceriaRepository;

    @Autowired
    public EstatusCarroceriaService(EstatusCarroceriaRepository estatusCarroceriaRepository) {
        this.estatusCarroceriaRepository = estatusCarroceriaRepository;
    }

    public List<EstatusCarroceria> getEstatusCarroceria(){
        return estatusCarroceriaRepository.findAll();
    }
}