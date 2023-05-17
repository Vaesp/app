package com.example.app.Services;

import com.example.app.Models.Contador;
import com.example.app.Repositories.ContadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContadorService {
    private final ContadorRepository contadorRepository;

    public ContadorService(ContadorRepository contadorRepository) {
        this.contadorRepository = contadorRepository;
    }

    public List<Contador> getContador(){
        return contadorRepository.findAll();
    }

}
