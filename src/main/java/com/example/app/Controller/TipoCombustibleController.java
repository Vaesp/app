package com.example.app.Controller;

import com.example.app.Models.TipoCombustible;
import com.example.app.Repositories.TipoCombustibleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",methods = {RequestMethod.GET}, maxAge = 3600)

@RestController
@RequestMapping(path = "/api/auth/tipoCombustible")
//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public class TipoCombustibleController {

    @Autowired
    TipoCombustibleRepository tipoCombustibleRepository;

    @GetMapping
    public List<TipoCombustible> listTipoCombustible(){
        return tipoCombustibleRepository.findAll();
    }
}