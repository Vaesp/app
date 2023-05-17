package com.example.app.Controller.Tramites;

import com.example.app.Models.Tramites.EstatusTramite;
import com.example.app.Repositories.Tramites.EstatusTramiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",methods = {RequestMethod.GET}, maxAge = 3600)

@RestController
@RequestMapping(path = "/api/auth/estatusTramite")
//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public class EstatusTramiteController {

    @Autowired
    EstatusTramiteRepository estatusTramiteRepository;

    @GetMapping
    public List<EstatusTramite> listEstatusTramite(){
        return estatusTramiteRepository.findAll();
    }
}