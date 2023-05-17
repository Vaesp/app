package com.example.app.Controller.Tramites;

import com.example.app.Models.Tramites.TipoSolicitud;
import com.example.app.Repositories.Tramites.TipoSolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",methods = {RequestMethod.GET}, maxAge = 3600)

@RestController
@RequestMapping(path = "/api/auth/tipoSolicitud")
//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public class TipoSolicitudController {

    @Autowired
    TipoSolicitudRepository tipoSolicitudRepository;

    @GetMapping
    public List<TipoSolicitud> listTipoSolicitud(){
        return tipoSolicitudRepository.findAll();
    }
}