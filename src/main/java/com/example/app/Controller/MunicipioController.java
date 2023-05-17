package com.example.app.Controller;

import com.example.app.Models.Municipio;
import com.example.app.Repositories.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*",methods = {RequestMethod.GET}, maxAge = 3600)

@RestController
@RequestMapping(path = "/api/auth/municipio")
//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public class MunicipioController {

    @Autowired
    MunicipioRepository municipioRepository;

    @GetMapping
    public List<Municipio> listMunicipio(){
        return municipioRepository.findByOrderByMunicipio();
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Municipio> getReporteById(@PathVariable("id") long id) {
        Optional<Municipio> municipioData = municipioRepository.findById(id);

        if (municipioData.isPresent()) {
            return new ResponseEntity<>(municipioData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}