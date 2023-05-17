package com.example.app.Controller;

import com.example.app.Models.Aviso;
import com.example.app.Repositories.AvisoRepository;
import com.example.app.Services.AvisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.POST, RequestMethod.GET}, maxAge = 3600)

@RestController
@RequestMapping("/api/auth/aviso")
//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public class AvisoController {

    private final AvisoService Aviso;

    @Autowired
    AvisoRepository avisoRepository;

    @Autowired
    public AvisoController(AvisoService aviso) {
        Aviso = aviso;
    }

    @PostMapping
    public ResponseEntity<Aviso> addAviso(@RequestBody Aviso aviso){
        Aviso _aviso = new Aviso();

        _aviso.setTitulo(aviso.getTitulo());
        _aviso.setDescripcion(aviso.getDescripcion());

        _aviso.setTimestamp(LocalDateTime.now().withNano(0));
        _aviso.setUserstamp(aviso.getUserstamp());
        try {
            avisoRepository.save(_aviso);
            return new ResponseEntity<>(_aviso, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping(path = "/{aId}")
    public ResponseEntity<Aviso> deleteAviso(@PathVariable("aId") Long aId) {
        try {
            Aviso.deleteAviso(aId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping(path = "/{aId}")
    public ResponseEntity<Aviso> updateAviso(@PathVariable("aId") Long aId, @RequestBody Aviso aviso) {
        Optional<Aviso> avisoData = avisoRepository.findById(aId);

        try {
            if (avisoData.isPresent()) {
                Aviso _aviso = avisoData.get();

                _aviso.setTitulo(aviso.getTitulo());
                _aviso.setDescripcion(aviso.getDescripcion());

                _aviso.setTimestampEdit(LocalDateTime.now().withNano(0));
                _aviso.setUserstamp(aviso.getUserstamp());
                return new ResponseEntity<>(avisoRepository.save(_aviso), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(path = "/{aId}")
    public ResponseEntity<Aviso> getAvisoById(@PathVariable("aId") Long aId) {
        Optional<Aviso> avisoData = avisoRepository.findById(aId);

        if (avisoData.isPresent()) {
            return new ResponseEntity<>(avisoData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Map<String,Object>> getAllAvisos(
            @RequestParam(defaultValue = "timestamp") String filter,
            @RequestParam(defaultValue = "ASC") Sort.Direction direction,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size
    ){
        List<Aviso> aviso_;
        Pageable paging = PageRequest.of(page, size, Sort.by(direction, filter));
        Page<Aviso> pageReps;

        try {
            pageReps = avisoRepository.findAll(paging);

            aviso_ = pageReps.getContent();
            Map<String, Object> response = new HashMap<>();

            response.put("avisoList", aviso_);
            response.put("currentPage", pageReps.getNumber());
            response.put("totalItems", pageReps.getTotalElements());
            response.put("totalPages", pageReps.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}