package com.example.app.Services;

import com.example.app.Models.TipoCombustible;
import com.example.app.Repositories.TipoCombustibleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoCombustibleService {

    private final TipoCombustibleRepository tipoCombustibleRepository;

    @Autowired
    public TipoCombustibleService(TipoCombustibleRepository tipoCombustibleRepository){
        this.tipoCombustibleRepository = tipoCombustibleRepository;
    }

    public List<TipoCombustible> getTipoCombustible(){
        return tipoCombustibleRepository.findAll();
    }
}