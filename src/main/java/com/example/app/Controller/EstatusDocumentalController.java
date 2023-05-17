package com.example.app.Controller;

import com.example.app.Models.EstatusDocumental;
import com.example.app.Repositories.EstatusDocumentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",methods = {RequestMethod.GET}, maxAge = 3600)

@RestController
@RequestMapping(path = "/api/auth/estatusDocumental")
//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public class  EstatusDocumentalController {

    @Autowired
    EstatusDocumentalRepository estatusDocumentalRepository;

    @GetMapping
    public List<EstatusDocumental> listEstatusDocumental(){
        return estatusDocumentalRepository.findAll();
    }
}