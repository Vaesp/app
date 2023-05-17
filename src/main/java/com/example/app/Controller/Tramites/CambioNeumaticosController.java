package com.example.app.Controller.Tramites;

import com.example.app.Models.Contador;
import com.example.app.Models.Tramites.CambioNeumaticos;
import com.example.app.Repositories.ContadorRepository;
import com.example.app.Repositories.Tramites.CambioNeumaticosRepository;
import com.example.app.Services.Tramites.CambioNeumaticosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.POST, RequestMethod.GET}, maxAge = 3600)

@RestController
@RequestMapping(path = "/api/auth/cambioNeumaticos")
//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public class CambioNeumaticosController {

    private final CambioNeumaticosService cambioNeumaticosService;

    @Autowired
    CambioNeumaticosRepository cambioNeumaticosRepository;

    @Autowired
    ContadorRepository contadorRepository;

    public CambioNeumaticosController(CambioNeumaticosService cambioNeumaticosService) {
        this.cambioNeumaticosService = cambioNeumaticosService;
    }

    @PostMapping
    public ResponseEntity<CambioNeumaticos> addCambioNeumaticos(@RequestBody CambioNeumaticos cambioNeumaticos) {
        CambioNeumaticos _cambioNeumaticos = new CambioNeumaticos();
        Contador _contador = contadorRepository.getById(1L);

        int YearFolio = LocalDateTime.now().getYear();
        String ShortYear = Integer.toString(YearFolio).substring(2, 4);
        String AbreviaturaFolio = _contador.getAbreviatura();
        String YearUltimo = _contador.getUltimo();

        _contador.setContador(_contador.getContador() + 1);
        if (!ShortYear.equals(YearUltimo)) {
            _contador.setContador(1);
        }
        _contador.setUltimo(ShortYear);
        contadorRepository.save(_contador);

        Integer ContadorFolio = _contador.getContador();
        String FormatedContador = String.format("%03d", ContadorFolio);

        _cambioNeumaticos.setFolio(AbreviaturaFolio + ShortYear + FormatedContador);
        _cambioNeumaticos.setFecha(cambioNeumaticos.getFecha());
        _cambioNeumaticos.setResponsable(cambioNeumaticos.getResponsable());
        _cambioNeumaticos.setNeumatico1(cambioNeumaticos.getNeumatico1());
        _cambioNeumaticos.setNeumatico1Descripcion(cambioNeumaticos.getNeumatico1Descripcion());
        _cambioNeumaticos.setNeumatico2(cambioNeumaticos.getNeumatico2());
        _cambioNeumaticos.setNeumatico2Descripcion(cambioNeumaticos.getNeumatico2Descripcion());
        _cambioNeumaticos.setNeumatico3(cambioNeumaticos.getNeumatico3());
        _cambioNeumaticos.setNeumatico3Descripcion(cambioNeumaticos.getNeumatico3Descripcion());
        _cambioNeumaticos.setNeumatico4(cambioNeumaticos.getNeumatico4());
        _cambioNeumaticos.setNeumatico4Descripcion(cambioNeumaticos.getNeumatico4Descripcion());
        _cambioNeumaticos.setNeumatico5(cambioNeumaticos.getNeumatico5());
        _cambioNeumaticos.setNeumatico5Descripcion(cambioNeumaticos.getNeumatico5Descripcion());
        _cambioNeumaticos.setNeumatico6(cambioNeumaticos.getNeumatico6());
        _cambioNeumaticos.setNeumatico6Descripcion(cambioNeumaticos.getNeumatico6Descripcion());
        _cambioNeumaticos.setNeumaticoR(cambioNeumaticos.getNeumaticoR());
        _cambioNeumaticos.setNeumaticoRDescripcion(cambioNeumaticos.getNeumaticoRDescripcion());
        _cambioNeumaticos.setObservaciones(cambioNeumaticos.getObservaciones());
        _cambioNeumaticos.setVehiculo(cambioNeumaticos.getVehiculo());

        _cambioNeumaticos.setTimestamp(LocalDateTime.now().withNano(0));
        _cambioNeumaticos.setUserstamp(cambioNeumaticos.getUserstamp());

        try {
            cambioNeumaticosRepository.save(_cambioNeumaticos);
            return new ResponseEntity<>(_cambioNeumaticos, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping(path = "/{nId}")
    public ResponseEntity<CambioNeumaticos> deleteCambioNeumaticos(@PathVariable("nId") Long nId) {
        try {
            cambioNeumaticosService.deleteCambioNeumaticos(nId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping(path = "/{nId}")
    public ResponseEntity<CambioNeumaticos> updateCambioNeumaticos(@PathVariable("nId") Long nId, @RequestBody CambioNeumaticos cambioNeumaticos) {
        Optional<CambioNeumaticos> cambioData = cambioNeumaticosRepository.findById(nId);
        try {
            if (cambioData.isPresent()) {
                CambioNeumaticos _cambioNeumaticos = cambioData.get();

                _cambioNeumaticos.setFecha(cambioNeumaticos.getFecha());
                _cambioNeumaticos.setResponsable(cambioNeumaticos.getResponsable());
                _cambioNeumaticos.setNeumatico1(cambioNeumaticos.getNeumatico1());
                _cambioNeumaticos.setNeumatico1Descripcion(cambioNeumaticos.getNeumatico1Descripcion());
                _cambioNeumaticos.setNeumatico2(cambioNeumaticos.getNeumatico2());
                _cambioNeumaticos.setNeumatico2Descripcion(cambioNeumaticos.getNeumatico2Descripcion());
                _cambioNeumaticos.setNeumatico3(cambioNeumaticos.getNeumatico3());
                _cambioNeumaticos.setNeumatico3Descripcion(cambioNeumaticos.getNeumatico3Descripcion());
                _cambioNeumaticos.setNeumatico4(cambioNeumaticos.getNeumatico4());
                _cambioNeumaticos.setNeumatico4Descripcion(cambioNeumaticos.getNeumatico4Descripcion());
                _cambioNeumaticos.setNeumatico5(cambioNeumaticos.getNeumatico5());
                _cambioNeumaticos.setNeumatico5Descripcion(cambioNeumaticos.getNeumatico5Descripcion());
                _cambioNeumaticos.setNeumatico6(cambioNeumaticos.getNeumatico6());
                _cambioNeumaticos.setNeumatico6Descripcion(cambioNeumaticos.getNeumatico6Descripcion());
                _cambioNeumaticos.setNeumaticoR(cambioNeumaticos.getNeumaticoR());
                _cambioNeumaticos.setNeumaticoRDescripcion(cambioNeumaticos.getNeumaticoRDescripcion());
                _cambioNeumaticos.setObservaciones(cambioNeumaticos.getObservaciones());
                _cambioNeumaticos.setVehiculo(cambioNeumaticos.getVehiculo());

                _cambioNeumaticos.setTimestampEdit(LocalDateTime.now().withNano(0));
                _cambioNeumaticos.setUserstamp(cambioNeumaticos.getUserstamp());

                return new ResponseEntity<>(cambioNeumaticosRepository.save(_cambioNeumaticos), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(path = "/{nId}")
    public ResponseEntity<CambioNeumaticos> getCambioNeumaticosById(@PathVariable("nId") Long nId) {
        Optional<CambioNeumaticos> cambioData = cambioNeumaticosRepository.findById(nId);

        if (cambioData.isPresent()) {
            return new ResponseEntity<>(cambioData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getCambioNeumaticos(
            @RequestParam(required = false) String folio,

            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaIni,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            @RequestParam(defaultValue = "0") Long vehiculoId,
            @RequestParam(defaultValue = "0") Long categoriaId,
            @RequestParam(defaultValue = "1") Long tipoTransporteId,

            @RequestParam(defaultValue = "folio") String filter,
            @RequestParam(defaultValue = "ASC") Sort.Direction direction,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size
    ) {
        List<CambioNeumaticos> cambioNeumaticos_;
        Pageable paging = PageRequest.of(page, size, Sort.by(direction, filter));
        Page<CambioNeumaticos> pageReps;

        try {
            if (folio != null && vehiculoId != 0) {
                pageReps = cambioNeumaticosRepository.findByFolioContainingAndVehiculo_id(folio, vehiculoId, paging);
            } else if (folio != null) {
                pageReps = cambioNeumaticosRepository.findByFolioContaining(folio, paging);
            } else if (fechaIni != null && fechaFin != null && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = cambioNeumaticosRepository.findByFechaBetweenAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = cambioNeumaticosRepository.findByFechaBetweenAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, vehiculoId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = cambioNeumaticosRepository.findByFechaBetweenAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, categoriaId, tipoTransporteId, paging);
            } else if (vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = cambioNeumaticosRepository.findByVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && tipoTransporteId != 0) {
                pageReps = cambioNeumaticosRepository.findByFechaBetweenAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, tipoTransporteId, paging);
            } else if (vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = cambioNeumaticosRepository.findByVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(vehiculoId, tipoTransporteId, paging);
            } else if (categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = cambioNeumaticosRepository.findByVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(categoriaId, tipoTransporteId, paging);
            } else if (tipoTransporteId != 0) {
                pageReps = cambioNeumaticosRepository.findByVehiculo_Categoria_TipoTransporte_id(tipoTransporteId, paging);
            } else {
                pageReps = cambioNeumaticosRepository.findAll(paging);
            }

            cambioNeumaticos_ = pageReps.getContent();
            Map<String, Object> response = new HashMap<>();

            response.put("cambioNeumaticosList", cambioNeumaticos_);
            response.put("currentPage", pageReps.getNumber());
            response.put("totalItems", pageReps.getTotalElements());
            response.put("totalPages", pageReps.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}