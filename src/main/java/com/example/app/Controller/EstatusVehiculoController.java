package com.example.app.Controller;

import com.example.app.Models.EstatusVehiculo;
import com.example.app.Repositories.EstatusVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",methods = {RequestMethod.GET}, maxAge = 3600)

@RestController
@RequestMapping(path = "/api/auth/estatusVehiculo")
//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public class EstatusVehiculoController {

    @Autowired
    EstatusVehiculoRepository estatusVehiculoRepository;

    @GetMapping
    public List<EstatusVehiculo> listEstatusVehiculo(){
        return estatusVehiculoRepository.findAll();
    }
}