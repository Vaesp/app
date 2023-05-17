package com.example.app.Controller.Tramites;

import com.example.app.Models.Contador;
import com.example.app.Models.Tramites.Verificacion;
import com.example.app.Repositories.ContadorRepository;
import com.example.app.Repositories.Tramites.VerificacionRepository;
import com.example.app.Services.Tramites.VerifiacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.POST, RequestMethod.GET}, maxAge = 3600)

@RestController
@RequestMapping(path = "/api/auth/verificacion")
//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public class VerificacionController {

    private final VerifiacionService verifiacionService;

    @Autowired
    VerificacionRepository verificacionRepository;

    @Autowired
    ContadorRepository contadorRepository;

    public VerificacionController(VerifiacionService verifiacionService) {
        this.verifiacionService = verifiacionService;
    }

    @PostMapping
    public ResponseEntity<Verificacion> addVerificacion(@RequestBody Verificacion verificacion) {
        Verificacion _verificacion = new Verificacion();
        Contador _contador = contadorRepository.getById(7L);

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

        _verificacion.setFolio(AbreviaturaFolio + ShortYear + FormatedContador);
        _verificacion.setFecha(verificacion.getFecha());
        _verificacion.setResponsable(verificacion.getResponsable());
        _verificacion.setCentroVerificacion(verificacion.getCentroVerificacion());
        _verificacion.setObservaciones(verificacion.getObservaciones());
        _verificacion.setPeriodoVerificacion(verificacion.getPeriodoVerificacion());
        _verificacion.setVehiculo(verificacion.getVehiculo());

        _verificacion.setTimestamp(LocalDateTime.now().withNano(0));
        _verificacion.setUserstamp(verificacion.getUserstamp());

        try {
            verificacionRepository.save(_verificacion);
            return new ResponseEntity<>(_verificacion, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping(path = "/{vId}")
    public ResponseEntity<Verificacion> deleteVerificacion(@PathVariable("vId") Long vId) {
        try {
            verifiacionService.deleteVerificacion(vId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping(path = "/{vId}")
    public ResponseEntity<Verificacion> updateVerifiacion(@PathVariable("vId") Long vId, @RequestBody Verificacion verificacion) {
        Optional<Verificacion> verificacionData = verificacionRepository.findById(vId);
        try {
            if (verificacionData.isPresent()) {
                Verificacion _verificacion = verificacionData.get();

                _verificacion.setFecha(verificacion.getFecha());
                _verificacion.setResponsable(verificacion.getResponsable());
                _verificacion.setCentroVerificacion(verificacion.getCentroVerificacion());
                _verificacion.setObservaciones(verificacion.getObservaciones());
                _verificacion.setPeriodoVerificacion(verificacion.getPeriodoVerificacion());
                _verificacion.setVehiculo(verificacion.getVehiculo());

                _verificacion.setTimestampEdit(LocalDateTime.now().withNano(0));
                _verificacion.setUserstamp(verificacion.getUserstamp());

                return new ResponseEntity<>(verificacionRepository.save(_verificacion), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(path = "/{vId}")
    public ResponseEntity<Verificacion> getVerificacionById(@PathVariable("vId") Long vId) {
        Optional<Verificacion> verificacionData = verificacionRepository.findById(vId);

        if (verificacionData.isPresent()) {
            return new ResponseEntity<>(verificacionData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getVerificacion(
            @RequestParam(required = false) String folio,

            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaIni,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            @RequestParam(defaultValue = "0") Long periodoVerificacionId,
            @RequestParam(defaultValue = "0") Long vehiculoId,
            @RequestParam(defaultValue = "0") Long categoriaId,
            @RequestParam(defaultValue = "1") Long tipoTransporteId,

            @RequestParam(defaultValue = "folio") String filter,
            @RequestParam(defaultValue = "ASC") Sort.Direction direction,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size
    ) {
        List<Verificacion> verificacion_;
        Pageable paging = PageRequest.of(page, size, Sort.by(direction, filter));
        Page<Verificacion> pageReps;

        try {
            if (folio != null && vehiculoId != 0) {
                pageReps = verificacionRepository.findByFolioContainingAndVehiculo_id(folio, vehiculoId, paging);
            } else if (folio != null) {
                pageReps = verificacionRepository.findByFolioContaining(folio, paging);
            } else if (fechaIni != null && fechaFin != null && periodoVerificacionId != 0 && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = verificacionRepository.findByFechaBetweenAndPeriodoVerificacion_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, periodoVerificacionId, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && periodoVerificacionId != 0 && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = verificacionRepository.findByFechaBetweenAndPeriodoVerificacion_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, periodoVerificacionId, vehiculoId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && periodoVerificacionId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = verificacionRepository.findByFechaBetweenAndPeriodoVerificacion_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, periodoVerificacionId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = verificacionRepository.findByFechaBetweenAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (periodoVerificacionId != 0 && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = verificacionRepository.findByPeriodoVerificacion_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(periodoVerificacionId, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && periodoVerificacionId != 0 && tipoTransporteId != 0) {
                pageReps = verificacionRepository.findByFechaBetweenAndPeriodoVerificacion_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, periodoVerificacionId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = verificacionRepository.findByFechaBetweenAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, vehiculoId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = verificacionRepository.findByFechaBetweenAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, categoriaId, tipoTransporteId, paging);
            } else if (periodoVerificacionId != 0 && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = verificacionRepository.findByPeriodoVerificacion_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(periodoVerificacionId, vehiculoId, tipoTransporteId, paging);
            } else if (periodoVerificacionId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = verificacionRepository.findByPeriodoVerificacion_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(periodoVerificacionId, categoriaId, tipoTransporteId, paging);
            } else if (vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = verificacionRepository.findByVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && tipoTransporteId != 0) {
                pageReps = verificacionRepository.findByFechaBetweenAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, tipoTransporteId, paging);
            } else if (periodoVerificacionId != 0 && tipoTransporteId != 0) {
                pageReps = verificacionRepository.findByPeriodoVerificacion_idAndVehiculo_Categoria_TipoTransporte_id(periodoVerificacionId, tipoTransporteId, paging);
            } else if (vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = verificacionRepository.findByVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(vehiculoId, tipoTransporteId, paging);
            } else if (categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = verificacionRepository.findByVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(categoriaId, tipoTransporteId, paging);
            } else if (tipoTransporteId != 0) {
                pageReps = verificacionRepository.findByVehiculo_Categoria_TipoTransporte_id(tipoTransporteId, paging);
            } else {
                pageReps = verificacionRepository.findAll(paging);
            }

            verificacion_ = pageReps.getContent();
            Map<String, Object> response = new HashMap<>();

            response.put("verificacionList", verificacion_);
            response.put("currentPage", pageReps.getNumber());
            response.put("totalItems", pageReps.getTotalElements());
            response.put("totalPages", pageReps.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}