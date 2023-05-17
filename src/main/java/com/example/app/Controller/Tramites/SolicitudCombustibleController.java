package com.example.app.Controller.Tramites;

import com.example.app.Models.Contador;
import com.example.app.Models.Tramites.SolicitudCombustible;
import com.example.app.Repositories.ContadorRepository;
import com.example.app.Repositories.Tramites.SolicitudCombustibleRepository;
import com.example.app.Services.Tramites.SolicitudCombustibleService;
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
@RequestMapping(path = "/api/auth/solicitudCombustible")
//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public class SolicitudCombustibleController {

    private final SolicitudCombustibleService solicitudCombustibleService;

    @Autowired
    SolicitudCombustibleRepository solicitudCombustibleRepository;

    @Autowired
    ContadorRepository contadorRepository;

    public SolicitudCombustibleController(SolicitudCombustibleService solicitudCombustibleService) {
        this.solicitudCombustibleService = solicitudCombustibleService;
    }

    @PostMapping
    public ResponseEntity<SolicitudCombustible> addSolicitudCombustible(@RequestBody SolicitudCombustible solicitudCombustible) {
        Long tipoId = solicitudCombustible.getTipoSolicitud().getId();
        long contadorTipoId;

        if (tipoId == 2) {
            contadorTipoId = 6L;
        } else {
            contadorTipoId = 5L;
        }

        SolicitudCombustible _solicitudCombustible = new SolicitudCombustible();
        Contador _contador = contadorRepository.getById(contadorTipoId);

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

        _solicitudCombustible.setFolio(AbreviaturaFolio + ShortYear + FormatedContador);
        _solicitudCombustible.setFecha(solicitudCombustible.getFecha());
        _solicitudCombustible.setSolicitante(solicitudCombustible.getSolicitante());
        _solicitudCombustible.setMotivo(solicitudCombustible.getMotivo());
        _solicitudCombustible.setKmInicial(solicitudCombustible.getKmInicial());
        _solicitudCombustible.setKmPorRecorrer(solicitudCombustible.getKmPorRecorrer());
        _solicitudCombustible.setKmFinal(solicitudCombustible.getKmFinal());
        _solicitudCombustible.setNivelActual(solicitudCombustible.getNivelActual());
        _solicitudCombustible.setMontoAutorizado(solicitudCombustible.getMontoAutorizado());
        _solicitudCombustible.setJefeSolicitante(solicitudCombustible.getJefeSolicitante());
        _solicitudCombustible.setJefeMateriales(solicitudCombustible.getJefeMateriales());
        _solicitudCombustible.setJefeUnidadAdministrativa(solicitudCombustible.getJefeUnidadAdministrativa());
        _solicitudCombustible.setVehiculo(solicitudCombustible.getVehiculo());
        _solicitudCombustible.setArea(solicitudCombustible.getArea());
        _solicitudCombustible.setTipoSolicitud(solicitudCombustible.getTipoSolicitud());
        _solicitudCombustible.setMunicipio(solicitudCombustible.getMunicipio());

        _solicitudCombustible.setTimestamp(LocalDateTime.now().withNano(0));
        _solicitudCombustible.setUserstamp(solicitudCombustible.getUserstamp());

        try {
            solicitudCombustibleRepository.save(_solicitudCombustible);
            return new ResponseEntity<>(_solicitudCombustible, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping(path = "/{sId}")
    public ResponseEntity<SolicitudCombustible> deleteSolicitudCombustible(@PathVariable("sId") Long sId) {
        try {
            solicitudCombustibleService.deleteSolicitudCombustible(sId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping(path = "/{sId}")
    public ResponseEntity<SolicitudCombustible> updateSolicitudCombustible(@PathVariable("sId") Long sId, @RequestBody SolicitudCombustible solicitudCombustible) {
        Optional<SolicitudCombustible> solicitudData = solicitudCombustibleRepository.findById(sId);
        try {
            if (solicitudData.isPresent()) {
                SolicitudCombustible _solicitudCombustible = solicitudData.get();

                _solicitudCombustible.setFecha(solicitudCombustible.getFecha());
                _solicitudCombustible.setSolicitante(solicitudCombustible.getSolicitante());
                _solicitudCombustible.setMotivo(solicitudCombustible.getMotivo());
                _solicitudCombustible.setKmInicial(solicitudCombustible.getKmInicial());
                _solicitudCombustible.setKmPorRecorrer(solicitudCombustible.getKmPorRecorrer());
                _solicitudCombustible.setKmFinal(solicitudCombustible.getKmFinal());
                _solicitudCombustible.setNivelActual(solicitudCombustible.getNivelActual());
                _solicitudCombustible.setMontoAutorizado(solicitudCombustible.getMontoAutorizado());
                _solicitudCombustible.setJefeSolicitante(solicitudCombustible.getJefeSolicitante());
                _solicitudCombustible.setJefeMateriales(solicitudCombustible.getJefeMateriales());
                _solicitudCombustible.setJefeUnidadAdministrativa(solicitudCombustible.getJefeUnidadAdministrativa());
                _solicitudCombustible.setVehiculo(solicitudCombustible.getVehiculo());
                _solicitudCombustible.setArea(solicitudCombustible.getArea());
                _solicitudCombustible.setTipoSolicitud(solicitudCombustible.getTipoSolicitud());
                _solicitudCombustible.setMunicipio(solicitudCombustible.getMunicipio());

                _solicitudCombustible.setTimestampEdit(LocalDateTime.now().withNano(0));
                _solicitudCombustible.setUserstamp(solicitudCombustible.getUserstamp());

                return new ResponseEntity<>(solicitudCombustibleRepository.save(_solicitudCombustible), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(path = "/{sId}")
    public ResponseEntity<SolicitudCombustible> getSolicitudCombustibleById(@PathVariable("sId") Long sId) {
        Optional<SolicitudCombustible> solicitudData = solicitudCombustibleRepository.findById(sId);

        if (solicitudData.isPresent()) {
            return new ResponseEntity<>(solicitudData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getSolicitudCombustible(
            @RequestParam(required = false) String folio,

            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaIni,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            @RequestParam(defaultValue = "0") Long areaId,
            @RequestParam(defaultValue = "0") Long municipioId,
            @RequestParam(defaultValue = "0") Long tipoSolicitudId,
            @RequestParam(defaultValue = "0") Long vehiculoId,
            @RequestParam(defaultValue = "0") Long categoriaId,
            @RequestParam(defaultValue = "1") Long tipoTransporteId,

            @RequestParam(defaultValue = "folio") String filter,
            @RequestParam(defaultValue = "ASC") Sort.Direction direction,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size
    ) {
        List<SolicitudCombustible> solicitudcCombustible_;
        Pageable paging = PageRequest.of(page, size, Sort.by(direction, filter));
        Page<SolicitudCombustible> pageReps;

        try {
            if (folio != null && areaId != 0) {
                pageReps = solicitudCombustibleRepository.findByFolioContainingAndArea_id(folio, areaId, paging);
            } else if (folio != null && vehiculoId != 0) {
                pageReps = solicitudCombustibleRepository.findByFolioContainingAndVehiculo_id(folio, vehiculoId, paging);
            } else if (folio != null) {
                pageReps = solicitudCombustibleRepository.findByFolioContaining(folio, paging);
            } else if (fechaIni != null && fechaFin != null && areaId != 0 && municipioId != 0 && tipoSolicitudId != 0 && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByFechaBetweenAndArea_idAndMunicipio_idAndTipoSolicitud_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, areaId, municipioId, tipoSolicitudId, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && areaId != 0 && municipioId != 0 && tipoSolicitudId != 0 && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByFechaBetweenAndArea_idAndMunicipio_idAndTipoSolicitud_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, areaId, municipioId, tipoSolicitudId, vehiculoId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && areaId != 0 && municipioId != 0 && tipoSolicitudId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByFechaBetweenAndArea_idAndMunicipio_idAndTipoSolicitud_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, areaId, municipioId, tipoSolicitudId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && areaId != 0 && municipioId != 0 && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByFechaBetweenAndArea_idAndMunicipio_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, areaId, municipioId, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && areaId != 0 && tipoSolicitudId != 0 && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByFechaBetweenAndArea_idAndTipoSolicitud_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, areaId, tipoSolicitudId, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && municipioId != 0 && tipoSolicitudId != 0 && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByFechaBetweenAndMunicipio_idAndTipoSolicitud_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, municipioId, tipoSolicitudId, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (areaId != 0 && municipioId != 0 && tipoSolicitudId != 0 && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByArea_idAndMunicipio_idAndTipoSolicitud_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(areaId, municipioId, tipoSolicitudId, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && areaId != 0 && municipioId != 0 && tipoSolicitudId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByFechaBetweenAndArea_idAndMunicipio_idAndTipoSolicitud_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, areaId, municipioId, tipoSolicitudId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && areaId != 0 && municipioId != 0 && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByFechaBetweenAndArea_idAndMunicipio_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, areaId, municipioId, vehiculoId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && areaId != 0 && municipioId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByFechaBetweenAndArea_idAndMunicipio_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, areaId, municipioId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && areaId != 0 && tipoSolicitudId != 0 && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByFechaBetweenAndArea_idAndTipoSolicitud_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, areaId, tipoSolicitudId, vehiculoId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && areaId != 0 && tipoSolicitudId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByFechaBetweenAndArea_idAndTipoSolicitud_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, areaId, tipoSolicitudId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && areaId != 0 && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByFechaBetweenAndArea_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, areaId, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && municipioId != 0 && tipoSolicitudId != 0 && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByFechaBetweenAndMunicipio_idAndTipoSolicitud_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, municipioId, tipoSolicitudId, vehiculoId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && municipioId != 0 && tipoSolicitudId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByFechaBetweenAndMunicipio_idAndTipoSolicitud_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, municipioId, tipoSolicitudId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && municipioId != 0 && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByFechaBetweenAndMunicipio_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, municipioId, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && tipoSolicitudId != 0 && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByFechaBetweenAndTipoSolicitud_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, tipoSolicitudId, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (areaId != 0 && municipioId != 0 && tipoSolicitudId != 0 && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByArea_idAndMunicipio_idAndTipoSolicitud_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(areaId, municipioId, tipoSolicitudId, vehiculoId, tipoTransporteId, paging);
            } else if (areaId != 0 && municipioId != 0 && tipoSolicitudId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByArea_idAndMunicipio_idAndTipoSolicitud_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(areaId, municipioId, tipoSolicitudId, categoriaId, tipoTransporteId, paging);
            } else if (areaId != 0 && municipioId != 0 && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByArea_idAndMunicipio_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(areaId, municipioId, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (areaId != 0 && tipoSolicitudId != 0 && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByArea_idAndTipoSolicitud_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(areaId, tipoSolicitudId, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (municipioId != 0 && tipoSolicitudId != 0 && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByMunicipio_idAndTipoSolicitud_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(municipioId, tipoSolicitudId, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && areaId != 0 && municipioId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByFechaBetweenAndArea_idAndMunicipio_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, areaId, municipioId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && areaId != 0 && tipoSolicitudId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByFechaBetweenAndArea_idAndTipoSolicitud_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, areaId, tipoSolicitudId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && areaId != 0 && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByFechaBetweenAndArea_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, areaId, vehiculoId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && areaId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByFechaBetweenAndArea_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, areaId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && municipioId != 0 && tipoSolicitudId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByFechaBetweenAndMunicipio_idAndTipoSolicitud_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, municipioId, tipoSolicitudId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && municipioId != 0 && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByFechaBetweenAndMunicipio_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, municipioId, vehiculoId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && municipioId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByFechaBetweenAndMunicipio_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, municipioId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && tipoSolicitudId != 0 && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByFechaBetweenAndTipoSolicitud_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, tipoSolicitudId, vehiculoId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && tipoSolicitudId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByFechaBetweenAndTipoSolicitud_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, tipoSolicitudId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByFechaBetweenAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (areaId != 0 && municipioId != 0 && tipoSolicitudId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByArea_idAndMunicipio_idAndTipoSolicitud_idAndVehiculo_Categoria_TipoTransporte_id(areaId, municipioId, tipoSolicitudId, tipoTransporteId, paging);
            } else if (areaId != 0 && municipioId != 0 && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByArea_idAndMunicipio_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(areaId, municipioId, vehiculoId, tipoTransporteId, paging);
            } else if (areaId != 0 && municipioId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByArea_idAndMunicipio_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(areaId, municipioId, categoriaId, tipoTransporteId, paging);
            } else if (areaId != 0 && tipoSolicitudId != 0 && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByArea_idAndTipoSolicitud_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(areaId, tipoSolicitudId, vehiculoId, tipoTransporteId, paging);
            } else if (areaId != 0 && tipoSolicitudId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByArea_idAndTipoSolicitud_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(areaId, tipoSolicitudId, categoriaId, tipoTransporteId, paging);
            } else if (areaId != 0 && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByArea_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(areaId, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (municipioId != 0 && tipoSolicitudId != 0 && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByMunicipio_idAndTipoSolicitud_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(municipioId, tipoSolicitudId, vehiculoId, tipoTransporteId, paging);
            } else if (municipioId != 0 && tipoSolicitudId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByMunicipio_idAndTipoSolicitud_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(municipioId, tipoSolicitudId, categoriaId, tipoTransporteId, paging);
            } else if (municipioId != 0 && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByMunicipio_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(municipioId, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (tipoSolicitudId != 0 && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByTipoSolicitud_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(tipoSolicitudId, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && areaId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByFechaBetweenAndArea_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, areaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && municipioId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByFechaBetweenAndMunicipio_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, municipioId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && tipoSolicitudId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByFechaBetweenAndTipoSolicitud_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, tipoSolicitudId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByFechaBetweenAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, vehiculoId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByFechaBetweenAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, categoriaId, tipoTransporteId, paging);
            } else if (areaId != 0 && municipioId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByArea_idAndMunicipio_idAndVehiculo_Categoria_TipoTransporte_id(areaId, municipioId, tipoTransporteId, paging);
            } else if (areaId != 0 && tipoSolicitudId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByArea_idAndTipoSolicitud_idAndVehiculo_Categoria_TipoTransporte_id(areaId, tipoSolicitudId, tipoTransporteId, paging);
            } else if (areaId != 0 && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByArea_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(areaId, vehiculoId, tipoTransporteId, paging);
            } else if (areaId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByArea_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(areaId, categoriaId, tipoTransporteId, paging);
            } else if (municipioId != 0 && tipoSolicitudId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByMunicipio_idAndTipoSolicitud_idAndVehiculo_Categoria_TipoTransporte_id(municipioId, tipoSolicitudId, tipoTransporteId, paging);
            } else if (municipioId != 0 && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByMunicipio_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(municipioId, vehiculoId, tipoTransporteId, paging);
            } else if (municipioId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByMunicipio_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(municipioId, categoriaId, tipoTransporteId, paging);
            } else if (tipoSolicitudId != 0 && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByTipoSolicitud_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(tipoSolicitudId, vehiculoId, tipoTransporteId, paging);
            } else if (tipoSolicitudId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByTipoSolicitud_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(tipoSolicitudId, categoriaId, tipoTransporteId, paging);
            } else if (vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByFechaBetweenAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, tipoTransporteId, paging);
            } else if (areaId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByArea_idAndVehiculo_Categoria_TipoTransporte_id(areaId, tipoTransporteId, paging);
            } else if (municipioId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByMunicipio_idAndVehiculo_Categoria_TipoTransporte_id(municipioId, tipoTransporteId, paging);
            } else if (tipoSolicitudId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByTipoSolicitud_idAndVehiculo_Categoria_TipoTransporte_id(tipoSolicitudId, tipoTransporteId, paging);
            } else if (vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(vehiculoId, tipoTransporteId, paging);
            } else if (categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(categoriaId, tipoTransporteId, paging);
            } else if (tipoTransporteId != 0) {
                pageReps = solicitudCombustibleRepository.findByVehiculo_Categoria_TipoTransporte_id(tipoTransporteId, paging);
            } else {
                pageReps = solicitudCombustibleRepository.findAll(paging);
            }

            solicitudcCombustible_ = pageReps.getContent();
            Map<String, Object> response = new HashMap<>();

            response.put("solicitudCombustibleList", solicitudcCombustible_);
            response.put("currentPage", pageReps.getNumber());
            response.put("totalItems", pageReps.getTotalElements());
            response.put("totalPages", pageReps.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}