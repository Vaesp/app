package com.example.app.Controller.Tramites;

import com.example.app.Models.Tramites.PeriodoVerificacion;
import com.example.app.Repositories.Tramites.PeriodoVerificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",methods = {RequestMethod.GET}, maxAge = 3600)

@RestController
@RequestMapping(path = "/api/auth/periodoVerificacion")
//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public class PeriodoVerificacionController {

    @Autowired
    PeriodoVerificacionRepository periodoVerificacionRepository;

    @GetMapping
    public List<PeriodoVerificacion> listPeriodoVerificacion(){
        return periodoVerificacionRepository.findAll();
    }
}