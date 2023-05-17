package com.example.app.Controller;

import com.example.app.Models.EstatusCarroceria;
import com.example.app.Repositories.EstatusCarroceriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",methods = {RequestMethod.GET}, maxAge = 3600)

@RestController
@RequestMapping(path = "/api/auth/estatusCarroceria")
//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public class EstatusCarroceriaController {

    @Autowired
    EstatusCarroceriaRepository estatusCarroceriaRepository;

    @GetMapping
    public List<EstatusCarroceria> listEstatusCarroceria(){
        return estatusCarroceriaRepository.findAll();
    }
}