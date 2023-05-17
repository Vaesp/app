package com.example.app.Controller;

import com.example.app.Models.UnidadTanque;
import com.example.app.Repositories.UnidadTanqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",methods = {RequestMethod.GET}, maxAge = 3600)

@RestController
@RequestMapping(path = "/api/auth/unidadTanque")
//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public class UnidadTanqueController {

    @Autowired
    UnidadTanqueRepository unidadTanqueRepository;

    @GetMapping
    public List<UnidadTanque> listUnidadTanque(){
        return unidadTanqueRepository.findAll();
    }
}