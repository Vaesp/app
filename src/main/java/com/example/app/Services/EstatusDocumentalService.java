package com.example.app.Services;

import com.example.app.Models.EstatusDocumental;
import com.example.app.Repositories.EstatusDocumentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstatusDocumentalService {

    private final EstatusDocumentalRepository estatusDocumentalRepository;

    @Autowired
    public EstatusDocumentalService(EstatusDocumentalRepository estatusDocumentalRepository) {
        this.estatusDocumentalRepository = estatusDocumentalRepository;
    }

    public List<EstatusDocumental> getEstatusDocumental(){
        return estatusDocumentalRepository.findAll();
    }
}