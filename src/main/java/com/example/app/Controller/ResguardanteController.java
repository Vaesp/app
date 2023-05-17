package com.example.app.Controller;

import com.example.app.Models.Resguardante;
import com.example.app.Repositories.ResguardanteRepository;
import com.example.app.Services.ResguardanteService;
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
@RequestMapping("/api/auth/resguardante")
public class ResguardanteController {

    private final ResguardanteService Resguardante;

    @Autowired
    ResguardanteRepository resguardanteRepository;

    @Autowired
    public ResguardanteController(ResguardanteService resguardante) {
        Resguardante = resguardante;
    }

    @PostMapping
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Resguardante> addResguardante(@RequestBody Resguardante resguardante) {
        Resguardante _resguardante = new Resguardante();

        _resguardante.setNombre(resguardante.getNombre());
        _resguardante.setCargo(resguardante.getCargo());
        _resguardante.setTipoLicencia(resguardante.getTipoLicencia());
        _resguardante.setVigenciaLicencia(resguardante.getVigenciaLicencia());
        _resguardante.setNoLicencia(resguardante.getNoLicencia());

        _resguardante.setTimestamp(LocalDateTime.now().withNano(0));
        _resguardante.setUserstamp(resguardante.getUserstamp());
        try {
            resguardanteRepository.save(_resguardante);
            return new ResponseEntity<>(_resguardante, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping(path = "/{rId}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Resguardante> deleteArea(@PathVariable("rId") Long rId) {
        try {
            Resguardante.deleteResguardante(rId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping(path = "/{rId}")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Resguardante> updateResguardante(@PathVariable("rId") Long rId, @RequestBody Resguardante resguardante) {
        Optional<Resguardante> resguardanteData = resguardanteRepository.findById(rId);

        try {
            if (resguardanteData.isPresent()) {
                Resguardante _resguardante = resguardanteData.get();

                _resguardante.setNombre(resguardante.getNombre());
                _resguardante.setCargo(resguardante.getCargo());
                _resguardante.setTipoLicencia(resguardante.getTipoLicencia());
                _resguardante.setVigenciaLicencia(resguardante.getVigenciaLicencia());
                _resguardante.setNoLicencia(resguardante.getNoLicencia());

                _resguardante.setTimestampEdit(LocalDateTime.now().withNano(0));
                _resguardante.setUserstamp(resguardante.getUserstamp());
                return new ResponseEntity<>(resguardanteRepository.save(_resguardante), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(path = "/{rId}")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Resguardante> getResguardanteById(@PathVariable("rId") Long rId) {
        Optional<Resguardante> resguardanteData = resguardanteRepository.findById(rId);

        if (resguardanteData.isPresent()) {
            return new ResponseEntity<>(resguardanteData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/list")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Resguardante> resguardanteList() {
        return resguardanteRepository.findByOrderByNombre();
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getResguardantes(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String noLicencia,
            @RequestParam(defaultValue = "nombre") String filter,
            @RequestParam(defaultValue = "ASC") Sort.Direction direction,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size
    ) {
        List<Resguardante> resguardante_;
        Pageable paging = PageRequest.of(page, size, Sort.by(direction, filter));
        Page<Resguardante> pageReps;

        try {
            if (nombre != null && noLicencia != null) {
                pageReps = resguardanteRepository.findByNombreContainingAndNoLicenciaContaining(nombre, noLicencia, paging);
            } else if (nombre != null) {
                pageReps = resguardanteRepository.findByNombreContaining(nombre, paging);
            } else if (noLicencia != null) {
                pageReps = resguardanteRepository.findByNoLicenciaContaining(noLicencia, paging);
            } else {
                pageReps = resguardanteRepository.findAll(paging);
            }

            resguardante_ = pageReps.getContent();
            Map<String, Object> response = new HashMap<>();

            response.put("resguardanteList", resguardante_);
            response.put("currentPage", pageReps.getNumber());
            response.put("totalItems", pageReps.getTotalElements());
            response.put("totalPages", pageReps.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}