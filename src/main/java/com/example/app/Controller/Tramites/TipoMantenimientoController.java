package com.example.app.Controller.Tramites;

import com.example.app.Models.Tramites.TipoMantenimiento;
import com.example.app.Repositories.Tramites.TipoMantenimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",methods = {RequestMethod.GET}, maxAge = 3600)

@RestController
@RequestMapping(path = "/api/auth/tipoMantenimiento")
//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public class TipoMantenimientoController {

    @Autowired
    TipoMantenimientoRepository tipoMantenimientoRepository;

    @GetMapping
    public List<TipoMantenimiento> listTipoManteminiento(){
        return tipoMantenimientoRepository.findAll();
    }
}