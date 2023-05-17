package com.example.app.Controller.Tramites;

import com.example.app.Models.Contador;
import com.example.app.Models.Tramites.Mantenimiento;
import com.example.app.Repositories.ContadorRepository;
import com.example.app.Repositories.Tramites.MantenimientoRepository;
import com.example.app.Services.Tramites.MantenimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.time.LocalDateTime;
import java.time.LocalDate;

@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.POST, RequestMethod.GET}, maxAge = 3600)

@RestController
@RequestMapping(path = "/api/auth/mantenimiento")
//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public class MantenimientoController {

    private final MantenimientoService mantenimientoService;

    @Autowired
    MantenimientoRepository mantenimientoRepository;

    @Autowired
    ContadorRepository contadorRepository;

    public MantenimientoController(MantenimientoService mantenimientoService) {
        this.mantenimientoService = mantenimientoService;
    }

    @PostMapping
    public ResponseEntity<Mantenimiento> addMantenimiento(@RequestBody Mantenimiento mantenimiento) {
        Mantenimiento _mantenimiento = new Mantenimiento();
        Contador _contador = contadorRepository.getById(2L);

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

        _mantenimiento.setFolio(AbreviaturaFolio + ShortYear + FormatedContador);
        _mantenimiento.setFecha(mantenimiento.getFecha());
        _mantenimiento.setResponsable(mantenimiento.getResponsable());
        _mantenimiento.setDescripcion(mantenimiento.getDescripcion());
        _mantenimiento.setUbicacion(mantenimiento.getUbicacion());
        _mantenimiento.setObservaciones(mantenimiento.getObservaciones());
        _mantenimiento.setTipoMantenimiento(mantenimiento.getTipoMantenimiento());
        _mantenimiento.setEstatusTramite(mantenimiento.getEstatusTramite());
        _mantenimiento.setVehiculo(mantenimiento.getVehiculo());

        _mantenimiento.setTimestamp(LocalDateTime.now().withNano(0));
        _mantenimiento.setUserstamp(mantenimiento.getUserstamp());

        try {
            mantenimientoRepository.save(_mantenimiento);
            return new ResponseEntity<>(_mantenimiento, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping(path = "/{mId}")
    public ResponseEntity<Mantenimiento> deleteMantenimiento(@PathVariable("mId") Long mId) {
        try {
            mantenimientoService.deleteMantenimiento(mId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping(path = "/{mId}")
    public ResponseEntity<Mantenimiento> updateMantenimiento(@PathVariable("mId") Long mId, @RequestBody Mantenimiento mantenimiento) {
        Optional<Mantenimiento> mantenimientoData = mantenimientoRepository.findById(mId);
        try {
            if (mantenimientoData.isPresent()) {
                Mantenimiento _mantenimiento = mantenimientoData.get();

                _mantenimiento.setFecha(mantenimiento.getFecha());
                _mantenimiento.setResponsable(mantenimiento.getResponsable());
                _mantenimiento.setDescripcion(mantenimiento.getDescripcion());
                _mantenimiento.setUbicacion(mantenimiento.getUbicacion());
                _mantenimiento.setObservaciones(mantenimiento.getObservaciones());
                _mantenimiento.setTipoMantenimiento(mantenimiento.getTipoMantenimiento());
                _mantenimiento.setEstatusTramite(mantenimiento.getEstatusTramite());
                _mantenimiento.setVehiculo(mantenimiento.getVehiculo());

                _mantenimiento.setTimestampEdit(LocalDateTime.now().withNano(0));
                _mantenimiento.setUserstamp(mantenimiento.getUserstamp());

                return new ResponseEntity<>(mantenimientoRepository.save(_mantenimiento), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(path = "/{mId}")
    public ResponseEntity<Mantenimiento> getMantenimientoById(@PathVariable("mId") Long mId) {
        Optional<Mantenimiento> mantenimientoData = mantenimientoRepository.findById(mId);

        if (mantenimientoData.isPresent()) {
            return new ResponseEntity<>(mantenimientoData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getMantenimiento(
            @RequestParam(required = false) String folio,

            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaIni,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            @RequestParam(defaultValue = "0") Long tipoMantenimientoId,
            @RequestParam(defaultValue = "0") Long estatusTramiteId,
            @RequestParam(defaultValue = "0") Long vehiculoId,
            @RequestParam(defaultValue = "0") Long categoriaId,
            @RequestParam(defaultValue = "1") Long tipoTransporteId,

            @RequestParam(defaultValue = "folio") String filter,
            @RequestParam(defaultValue = "ASC") Sort.Direction direction,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size
    ) {
        List<Mantenimiento> mantenimiento_;
        Pageable paging = PageRequest.of(page, size, Sort.by(direction, filter));
        Page<Mantenimiento> pageReps;

        try {
            if (folio != null && vehiculoId != 0) {
                pageReps = mantenimientoRepository.findByFolioContainingAndVehiculo_id(folio, vehiculoId, paging);
            } else if (folio != null) {
                pageReps = mantenimientoRepository.findByFolioContaining(folio, paging);
            } else if (fechaIni != null && fechaFin != null && tipoMantenimientoId != 0 && estatusTramiteId != 0 && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = mantenimientoRepository.findByFechaBetweenAndTipoMantenimiento_idAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, tipoMantenimientoId, estatusTramiteId, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && tipoMantenimientoId != 0 && estatusTramiteId != 0 && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = mantenimientoRepository.findByFechaBetweenAndTipoMantenimiento_idAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, tipoMantenimientoId, estatusTramiteId, vehiculoId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && tipoMantenimientoId != 0 && estatusTramiteId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = mantenimientoRepository.findByFechaBetweenAndTipoMantenimiento_idAndEstatusTramite_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, tipoMantenimientoId, estatusTramiteId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && tipoMantenimientoId != 0 && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = mantenimientoRepository.findByFechaBetweenAndTipoMantenimiento_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, tipoMantenimientoId, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && estatusTramiteId != 0 && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = mantenimientoRepository.findByFechaBetweenAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, estatusTramiteId, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (tipoMantenimientoId != 0 && estatusTramiteId != 0 && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = mantenimientoRepository.findByTipoMantenimiento_idAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(tipoMantenimientoId, estatusTramiteId, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && tipoMantenimientoId != 0 && estatusTramiteId != 0 && tipoTransporteId != 0) {
                pageReps = mantenimientoRepository.findByFechaBetweenAndTipoMantenimiento_idAndEstatusTramite_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, tipoMantenimientoId, estatusTramiteId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && tipoMantenimientoId != 0 && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = mantenimientoRepository.findByFechaBetweenAndTipoMantenimiento_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, tipoMantenimientoId, vehiculoId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && tipoMantenimientoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = mantenimientoRepository.findByFechaBetweenAndTipoMantenimiento_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, tipoMantenimientoId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && estatusTramiteId != 0 && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = mantenimientoRepository.findByFechaBetweenAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, estatusTramiteId, vehiculoId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && estatusTramiteId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = mantenimientoRepository.findByFechaBetweenAndEstatusTramite_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, estatusTramiteId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = mantenimientoRepository.findByFechaBetweenAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (tipoMantenimientoId != 0 && estatusTramiteId != 0 && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = mantenimientoRepository.findByTipoMantenimiento_idAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(tipoMantenimientoId, estatusTramiteId, vehiculoId, tipoTransporteId, paging);
            } else if (tipoMantenimientoId != 0 && estatusTramiteId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = mantenimientoRepository.findByTipoMantenimiento_idAndEstatusTramite_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(tipoMantenimientoId, estatusTramiteId, categoriaId, tipoTransporteId, paging);
            } else if (tipoMantenimientoId != 0 && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = mantenimientoRepository.findByTipoMantenimiento_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(tipoMantenimientoId, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (estatusTramiteId != 0 && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = mantenimientoRepository.findByEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(estatusTramiteId, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && tipoMantenimientoId != 0 && tipoTransporteId != 0) {
                pageReps = mantenimientoRepository.findByFechaBetweenAndTipoMantenimiento_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, tipoMantenimientoId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && estatusTramiteId != 0 && tipoTransporteId != 0) {
                pageReps = mantenimientoRepository.findByFechaBetweenAndEstatusTramite_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, estatusTramiteId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = mantenimientoRepository.findByFechaBetweenAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, vehiculoId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = mantenimientoRepository.findByFechaBetweenAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, categoriaId, tipoTransporteId, paging);
            } else if (tipoMantenimientoId != 0 && estatusTramiteId != 0 && tipoTransporteId != 0) {
                pageReps = mantenimientoRepository.findByTipoMantenimiento_idAndEstatusTramite_idAndVehiculo_Categoria_TipoTransporte_id(tipoMantenimientoId, estatusTramiteId, tipoTransporteId, paging);
            } else if (tipoMantenimientoId != 0 && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = mantenimientoRepository.findByTipoMantenimiento_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(tipoMantenimientoId, vehiculoId, tipoTransporteId, paging);
            } else if (tipoMantenimientoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = mantenimientoRepository.findByTipoMantenimiento_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(tipoMantenimientoId, categoriaId, tipoTransporteId, paging);
            } else if (estatusTramiteId != 0 && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = mantenimientoRepository.findByEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(estatusTramiteId, vehiculoId, tipoTransporteId, paging);
            } else if (estatusTramiteId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = mantenimientoRepository.findByEstatusTramite_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(estatusTramiteId, categoriaId, tipoTransporteId, paging);
            } else if (vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = mantenimientoRepository.findByVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && tipoTransporteId != 0) {
                pageReps = mantenimientoRepository.findByFechaBetweenAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, tipoTransporteId, paging);
            } else if (tipoMantenimientoId != 0 && tipoTransporteId != 0) {
                pageReps = mantenimientoRepository.findByTipoMantenimiento_idAndVehiculo_Categoria_TipoTransporte_id(tipoMantenimientoId, tipoTransporteId, paging);
            } else if (estatusTramiteId != 0 && tipoTransporteId != 0) {
                pageReps = mantenimientoRepository.findByEstatusTramite_idAndVehiculo_Categoria_TipoTransporte_id(estatusTramiteId, tipoTransporteId, paging);
            } else if (vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = mantenimientoRepository.findByVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(vehiculoId, tipoTransporteId, paging);
            } else if (categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = mantenimientoRepository.findByVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(categoriaId, tipoTransporteId, paging);
            } else if (tipoTransporteId != 0) {
                pageReps = mantenimientoRepository.findByVehiculo_Categoria_TipoTransporte_id(tipoTransporteId, paging);
            } else {
                pageReps = mantenimientoRepository.findAll(paging);
            }

            mantenimiento_ = pageReps.getContent();
            Map<String, Object> response = new HashMap<>();

            response.put("mantenimientoList", mantenimiento_);
            response.put("currentPage", pageReps.getNumber());
            response.put("totalItems", pageReps.getTotalElements());
            response.put("totalPages", pageReps.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}