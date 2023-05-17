package com.example.app.Controller;

import com.example.app.Models.Categoria;
import com.example.app.Repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*",methods = {RequestMethod.GET}, maxAge = 3600)

@RestController
@RequestMapping(path = "/api/auth/categoria")
//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> listCategoria(){
        return categoriaRepository.findAll();
    }

    @GetMapping("/{cId}")
    public ResponseEntity<List<Categoria>> getAllVehiculosByCategoria(
            @PathVariable("cId") long cId
    ) {
        try{
        List<Categoria> categoria_;
        categoria_ = categoriaRepository.findByTipoTransporte_id(cId);

            return new ResponseEntity<>(categoria_, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable("id") long id) {
        Optional<Categoria> categoriaData = categoriaRepository.findById(id);

        if (categoriaData.isPresent()) {
            return new ResponseEntity<>(categoriaData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}