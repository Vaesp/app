package com.example.app.Controller.Tramites;

import com.example.app.Models.Contador;
import com.example.app.Models.Tramites.ReporteIncidencias;
import com.example.app.Repositories.ContadorRepository;
import com.example.app.Repositories.Tramites.ReporteIncidenciasRepository;
import com.example.app.Services.Tramites.ReporteIncidenciasService;
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
@RequestMapping(path = "/api/auth/reporteIncidencias")
//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public class ReporteIncidenciasController {

    private final ReporteIncidenciasService reporteIncidenciasService;

    @Autowired
    ReporteIncidenciasRepository reporteIncidenciasRepository;

    @Autowired
    ContadorRepository contadorRepository;

    public ReporteIncidenciasController(ReporteIncidenciasService reporteIncidenciasService) {
        this.reporteIncidenciasService = reporteIncidenciasService;
    }

    @PostMapping
    public ResponseEntity<ReporteIncidencias> addReporteIncidencias(@RequestBody ReporteIncidencias reporteIncidencias) {
        ReporteIncidencias _reporteIncidencias = new ReporteIncidencias();
        Contador _contador = contadorRepository.getById(3L);

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

        _reporteIncidencias.setFolio(AbreviaturaFolio + ShortYear + FormatedContador);
        _reporteIncidencias.setFecha(reporteIncidencias.getFecha());
        _reporteIncidencias.setTitulo(reporteIncidencias.getTitulo());
        _reporteIncidencias.setUbicacion(reporteIncidencias.getUbicacion());
        _reporteIncidencias.setDescripcion(reporteIncidencias.getDescripcion());
        _reporteIncidencias.setObservaciones(reporteIncidencias.getObservaciones());
        _reporteIncidencias.setVehiculo(reporteIncidencias.getVehiculo());

        _reporteIncidencias.setTimestamp(LocalDateTime.now().withNano(0));
        _reporteIncidencias.setUserstamp(reporteIncidencias.getUserstamp());

        try {
            reporteIncidenciasRepository.save(_reporteIncidencias);
            return new ResponseEntity<>(_reporteIncidencias, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping(path = "/{rId}")
    public ResponseEntity<ReporteIncidencias> deleteReporteIncidencias(@PathVariable("rId") Long rId) {
        try {
            reporteIncidenciasService.deleteReporteIncidencias(rId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping(path = "/{rId}")
    public ResponseEntity<ReporteIncidencias> updateReporteIncidencias(@PathVariable("rId") Long rId, @RequestBody ReporteIncidencias reporteIncidencias) {
        Optional<ReporteIncidencias> reporteData = reporteIncidenciasRepository.findById(rId);
        try {
            if (reporteData.isPresent()) {
                ReporteIncidencias _reporteIncidencias = reporteData.get();

                _reporteIncidencias.setFecha(reporteIncidencias.getFecha());
                _reporteIncidencias.setTitulo(reporteIncidencias.getTitulo());
                _reporteIncidencias.setUbicacion(reporteIncidencias.getUbicacion());
                _reporteIncidencias.setDescripcion(reporteIncidencias.getDescripcion());
                _reporteIncidencias.setObservaciones(reporteIncidencias.getObservaciones());
                _reporteIncidencias.setVehiculo(reporteIncidencias.getVehiculo());

                _reporteIncidencias.setTimestampEdit(LocalDateTime.now().withNano(0));
                _reporteIncidencias.setUserstamp(reporteIncidencias.getUserstamp());

                return new ResponseEntity<>(reporteIncidenciasRepository.save(_reporteIncidencias), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(path = "/{rId}")
    public ResponseEntity<ReporteIncidencias> getReporteIncidenciasById(@PathVariable("rId") Long rId) {
        Optional<ReporteIncidencias> reporteData = reporteIncidenciasRepository.findById(rId);

        if (reporteData.isPresent()) {
            return new ResponseEntity<>(reporteData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getReportesIncidencias(
            @RequestParam(required = false) String folio,

            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaIni,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            @RequestParam(required = false) String ubicacion,
            @RequestParam(defaultValue = "0") Long vehiculoId,
            @RequestParam(defaultValue = "0") Long categoriaId,
            @RequestParam(defaultValue = "1") Long tipoTransporteId,

            @RequestParam(defaultValue = "folio") String filter,
            @RequestParam(defaultValue = "ASC") Sort.Direction direction,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size
    ) {
        List<ReporteIncidencias> reporteIncidencias_;
        Pageable paging = PageRequest.of(page, size, Sort.by(direction, filter));
        Page<ReporteIncidencias> pageReps;

        try {
            if (folio != null && vehiculoId != 0) {
                pageReps = reporteIncidenciasRepository.findByFolioContainingAndVehiculo_id(folio, vehiculoId, paging);
            } else if (folio != null) {
                pageReps = reporteIncidenciasRepository.findByFolioContaining(folio, paging);
            } else if (fechaIni != null && fechaFin != null && ubicacion != null && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = reporteIncidenciasRepository.findByFechaBetweenAndUbicacionContainingAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, ubicacion, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && ubicacion != null && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = reporteIncidenciasRepository.findByFechaBetweenAndUbicacionContainingAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, ubicacion, vehiculoId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && ubicacion != null && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = reporteIncidenciasRepository.findByFechaBetweenAndUbicacionContainingAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, ubicacion, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = reporteIncidenciasRepository.findByFechaBetweenAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (ubicacion != null && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = reporteIncidenciasRepository.findByUbicacionContainingAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(ubicacion, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && ubicacion != null && tipoTransporteId != 0) {
                pageReps = reporteIncidenciasRepository.findByFechaBetweenAndUbicacionContainingAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, ubicacion, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = reporteIncidenciasRepository.findByFechaBetweenAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, vehiculoId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = reporteIncidenciasRepository.findByFechaBetweenAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, categoriaId, tipoTransporteId, paging);
            } else if (ubicacion != null && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = reporteIncidenciasRepository.findByUbicacionContainingAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(ubicacion, vehiculoId, tipoTransporteId, paging);
            } else if (ubicacion != null && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = reporteIncidenciasRepository.findByUbicacionContainingAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(ubicacion, categoriaId, tipoTransporteId, paging);
            } else if (vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = reporteIncidenciasRepository.findByVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && tipoTransporteId != 0) {
                pageReps = reporteIncidenciasRepository.findByFechaBetweenAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, tipoTransporteId, paging);
            } else if (ubicacion != null && tipoTransporteId != 0) {
                pageReps = reporteIncidenciasRepository.findByUbicacionContainingAndVehiculo_Categoria_TipoTransporte_id(ubicacion, tipoTransporteId, paging);
            } else if (vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = reporteIncidenciasRepository.findByVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(vehiculoId, tipoTransporteId, paging);
            } else if (categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = reporteIncidenciasRepository.findByVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(categoriaId, tipoTransporteId, paging);
            } else if (tipoTransporteId != 0) {
                pageReps = reporteIncidenciasRepository.findByVehiculo_Categoria_TipoTransporte_id(tipoTransporteId, paging);
            } else {
                pageReps = reporteIncidenciasRepository.findAll(paging);
            }

            reporteIncidencias_ = pageReps.getContent();
            Map<String, Object> response = new HashMap<>();

            response.put("reporteIncidenciasList", reporteIncidencias_);
            response.put("currentPage", pageReps.getNumber());
            response.put("totalItems", pageReps.getTotalElements());
            response.put("totalPages", pageReps.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}