package com.example.app.Controller;

import com.example.app.Models.TipoTransporte;
import com.example.app.Repositories.TipoTransporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",methods = {RequestMethod.GET}, maxAge = 3600)

@RestController
@RequestMapping(path = "/api/auth/tipoTransporte")
//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public class TipoTransporteController {

    @Autowired
    TipoTransporteRepository tipoTransporteRepository;

    @GetMapping
    public List<TipoTransporte> listTipoTransporte(){
        return tipoTransporteRepository.findAll();
    }
}