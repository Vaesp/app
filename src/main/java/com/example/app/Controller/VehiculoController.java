package com.example.app.Controller;

import com.example.app.Models.Vehiculo;
import com.example.app.Repositories.CategoriaRepository;
import com.example.app.Repositories.EstatusVehiculoRepository;
import com.example.app.Repositories.TipoTransporteRepository;
import com.example.app.Repositories.VehiculoRepository;
import com.example.app.Services.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.POST, RequestMethod.GET}, maxAge = 3600)

@RestController
@RequestMapping(path = "/api/auth/vehiculo")
public class VehiculoController {

    private final VehiculoService VehiculoService;

    @Autowired
    VehiculoRepository vehiculoRepository;

    @Autowired
    TipoTransporteRepository tipoTransporteRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    EstatusVehiculoRepository estatusVehiculoRepository;

    @Autowired
    public VehiculoController(VehiculoService vehiculo) {
        VehiculoService = vehiculo;
    }

    @PostMapping
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Vehiculo> addVehiculo(@RequestBody Vehiculo vehiculo) {
        Vehiculo _vehiculo = new Vehiculo();

        _vehiculo.setNoEconomico(vehiculo.getNoEconomico());
        _vehiculo.setMarca(vehiculo.getMarca());
        _vehiculo.setTipoVehiculo(vehiculo.getTipoVehiculo());
        _vehiculo.setModelo(vehiculo.getModelo());
        _vehiculo.setColor(vehiculo.getColor());
        _vehiculo.setCilindraje(vehiculo.getCilindraje());
        _vehiculo.setCapacidadTanque(vehiculo.getCapacidadTanque());
        _vehiculo.setTipoNeumaticos(vehiculo.getTipoNeumaticos());
        _vehiculo.setPlacas(vehiculo.getPlacas());
        if (!(vehiculo.getPlacas() == null) && !(Objects.equals(vehiculo.getPlacas(), ""))) {
            _vehiculo.setUltimoDigito();
        }
        _vehiculo.setNoMotor(vehiculo.getNoMotor());
        _vehiculo.setNoSerie(vehiculo.getNoSerie());
        _vehiculo.setNoFactura(vehiculo.getNoFactura());
        _vehiculo.setNoTarjetaCirculacion(vehiculo.getNoTarjetaCirculacion());
        _vehiculo.setObservaciones(vehiculo.getObservaciones());
        _vehiculo.setNoCasco(vehiculo.getNoCasco());
        _vehiculo.setNoMatricula(vehiculo.getNoMatricula());
        _vehiculo.setNombreAseguradora(vehiculo.getNombreAseguradora());
        _vehiculo.setTelefonoAseguradora(vehiculo.getTelefonoAseguradora());
        _vehiculo.setNoPoliza(vehiculo.getNoPoliza());
        _vehiculo.setFechaContratacion(vehiculo.getFechaContratacion());
        _vehiculo.setFechaRenovacion(vehiculo.getFechaRenovacion());
        _vehiculo.setNoPoliza2(vehiculo.getNoPoliza2());
        _vehiculo.setFechaContratacion2(vehiculo.getFechaContratacion2());
        _vehiculo.setFechaRenovacion2(vehiculo.getFechaRenovacion2());
        _vehiculo.setKilometraje(vehiculo.getKilometraje());
        _vehiculo.setHorasUso(vehiculo.getHorasUso());
        _vehiculo.setProximoMantenimiento(vehiculo.getProximoMantenimiento());
        _vehiculo.setProximoCambioNeumaticos(vehiculo.getProximoCambioNeumaticos());
        _vehiculo.setUbicacion(vehiculo.getUbicacion());
        _vehiculo.setDetalleEstatusVehiculo(vehiculo.getDetalleEstatusVehiculo());
        _vehiculo.setNoExpediente(vehiculo.getNoExpediente());
        _vehiculo.setUso(vehiculo.getUso());

        _vehiculo.setCategoria(vehiculo.getCategoria());
        _vehiculo.setEstatusVehiculo(vehiculo.getEstatusVehiculo());
        _vehiculo.setUnidadTanque(vehiculo.getUnidadTanque());
        _vehiculo.setTipoCombustible(vehiculo.getTipoCombustible());
        _vehiculo.setArea(vehiculo.getArea());
        _vehiculo.setResguardante(vehiculo.getResguardante());
        _vehiculo.setMunicipio(vehiculo.getMunicipio());
        _vehiculo.setEstatusCarroceria(vehiculo.getEstatusCarroceria());
        _vehiculo.setEstatusDocumental(vehiculo.getEstatusDocumental());

        _vehiculo.setUserstamp(vehiculo.getUserstamp());
        _vehiculo.setTimestamp(LocalDateTime.now().withNano(0));
        try {
            vehiculoRepository.save(_vehiculo);
            return new ResponseEntity<>(_vehiculo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping(path = "/{vId}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Vehiculo> deleteVehiculo(@PathVariable("vId") Long vId) {
        try {
            VehiculoService.deleteVehiculo(vId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping(path = "/{vId}")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Vehiculo> updateVehiculo(@PathVariable("vId") Long vId, @RequestBody Vehiculo vehiculo) {
        Optional<Vehiculo> vehiculoData = vehiculoRepository.findById(vId);
        try {
            if (vehiculoData.isPresent()) {
                Vehiculo _vehiculo = vehiculoData.get();

                _vehiculo.setNoEconomico(vehiculo.getNoEconomico());
                _vehiculo.setMarca(vehiculo.getMarca());
                _vehiculo.setTipoVehiculo(vehiculo.getTipoVehiculo());
                _vehiculo.setModelo(vehiculo.getModelo());
                _vehiculo.setColor(vehiculo.getColor());
                _vehiculo.setCilindraje(vehiculo.getCilindraje());
                _vehiculo.setCapacidadTanque(vehiculo.getCapacidadTanque());
                _vehiculo.setTipoNeumaticos(vehiculo.getTipoNeumaticos());
                _vehiculo.setPlacasAnteriores(vehiculo.getPlacasAnteriores());
                _vehiculo.setPlacas(vehiculo.getPlacas());
                if (!(vehiculo.getPlacas() == null) && !(Objects.equals(vehiculo.getPlacas(), ""))) {
                    _vehiculo.setUltimoDigito();
                }
                _vehiculo.setNoMotor(vehiculo.getNoMotor());
                _vehiculo.setNoSerie(vehiculo.getNoSerie());
                _vehiculo.setNoFactura(vehiculo.getNoFactura());
                _vehiculo.setNoTarjetaCirculacion(vehiculo.getNoTarjetaCirculacion());
                _vehiculo.setObservaciones(vehiculo.getObservaciones());
                _vehiculo.setNoCasco(vehiculo.getNoCasco());
                _vehiculo.setNoMatricula(vehiculo.getNoMatricula());
                _vehiculo.setNombreAseguradora(vehiculo.getNombreAseguradora());
                _vehiculo.setTelefonoAseguradora(vehiculo.getTelefonoAseguradora());
                _vehiculo.setNoPoliza(vehiculo.getNoPoliza());
                _vehiculo.setFechaContratacion(vehiculo.getFechaContratacion());
                _vehiculo.setFechaRenovacion(vehiculo.getFechaRenovacion());
                _vehiculo.setNoPoliza2(vehiculo.getNoPoliza2());
                _vehiculo.setFechaContratacion2(vehiculo.getFechaContratacion2());
                _vehiculo.setFechaRenovacion2(vehiculo.getFechaRenovacion2());
                _vehiculo.setKilometraje(vehiculo.getKilometraje());
                _vehiculo.setHorasUso(vehiculo.getHorasUso());
                _vehiculo.setProximoMantenimiento(vehiculo.getProximoMantenimiento());
                _vehiculo.setProximoCambioNeumaticos(vehiculo.getProximoCambioNeumaticos());
                _vehiculo.setUbicacion(vehiculo.getUbicacion());
                _vehiculo.setDetalleEstatusVehiculo(vehiculo.getDetalleEstatusVehiculo());
                _vehiculo.setNoExpediente(vehiculo.getNoExpediente());
                _vehiculo.setUso(vehiculo.getUso());

                _vehiculo.setCategoria(vehiculo.getCategoria());
                _vehiculo.setEstatusVehiculo(vehiculo.getEstatusVehiculo());
                _vehiculo.setUnidadTanque(vehiculo.getUnidadTanque());
                _vehiculo.setTipoCombustible(vehiculo.getTipoCombustible());
                _vehiculo.setArea(vehiculo.getArea());
                _vehiculo.setResguardante(vehiculo.getResguardante());
                _vehiculo.setMunicipio(vehiculo.getMunicipio());
                _vehiculo.setEstatusCarroceria(vehiculo.getEstatusCarroceria());
                _vehiculo.setEstatusDocumental(vehiculo.getEstatusDocumental());

                _vehiculo.setTimestampEdit(LocalDateTime.now().withNano(0));
                _vehiculo.setUserstamp(vehiculo.getUserstamp());

                return new ResponseEntity<>(vehiculoRepository.save(_vehiculo), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping(path = "/updateOnTramite/{vId}")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Vehiculo> updateVehiculoOnTramite(@PathVariable("vId") Long vId, @RequestBody Vehiculo vehiculo) {
        Optional<Vehiculo> vehiculoData = vehiculoRepository.findById(vId);
        try {
            if (vehiculoData.isPresent()) {
                Vehiculo _vehiculo = vehiculoData.get();

                if (vehiculo.getEstatusVehiculo() != null){
                    _vehiculo.setEstatusVehiculo(vehiculo.getEstatusVehiculo());
                }

                if (vehiculo.getProximoCambioNeumaticos() != null && (_vehiculo.getProximoCambioNeumaticos() == null || _vehiculo.getProximoCambioNeumaticos().isBefore(vehiculo.getProximoCambioNeumaticos()))) {
                    _vehiculo.setProximoCambioNeumaticos(vehiculo.getProximoCambioNeumaticos());
                }

                if (vehiculo.getProximoMantenimiento() != null && (_vehiculo.getProximoMantenimiento() == null || _vehiculo.getProximoMantenimiento().isBefore(vehiculo.getProximoMantenimiento()))) {
                    _vehiculo.setProximoMantenimiento(vehiculo.getProximoMantenimiento());
                }

                if (vehiculo.getKilometraje() != null && vehiculo.getKilometraje() > 0 && (_vehiculo.getKilometraje() == null || _vehiculo.getKilometraje() < vehiculo.getKilometraje())) {
                    _vehiculo.setKilometraje(vehiculo.getKilometraje());
                }

                if (vehiculo.getHorasUso() != null && vehiculo.getHorasUso() > 0 && (_vehiculo.getHorasUso() == null || _vehiculo.getHorasUso() < vehiculo.getHorasUso())) {
                    _vehiculo.setHorasUso(vehiculo.getHorasUso());
                }

                _vehiculo.setTimestampEdit(LocalDateTime.now().withNano(0));
                _vehiculo.setUserstamp(vehiculo.getUserstamp());

                return new ResponseEntity<>(vehiculoRepository.save(_vehiculo), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(path = "/exists/{noEconomico}")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Boolean existsVehiculoByNoEconomico(@PathVariable("noEconomico") String noEconomico) {
        return vehiculoRepository.existsByNoEconomico(noEconomico);
    }

    @GetMapping(path = "/{vId}")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Vehiculo> getVehiculoById(@PathVariable("vId") Long vId) {
        Optional<Vehiculo> reporteData = vehiculoRepository.findById(vId);

        if (reporteData.isPresent()) {
            return new ResponseEntity<>(reporteData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/count")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Map<String, Object>> countVehiculoByEstatusAndTipoAndCategoria() {
        try {
            ArrayList<Long> estatusVehiculoCount = new ArrayList<>();
            for (int i = 0; i < estatusVehiculoRepository.count(); i++) {
                long estatusVehiculo = vehiculoRepository.countByEstatusVehiculo_id((long) i + 1);
                estatusVehiculoCount.add(estatusVehiculo);
            }

            ArrayList<Long> tipoTransporteCount = new ArrayList<>();
            for (int i = 0; i < tipoTransporteRepository.count(); i++) {
                long tipoTransporte = vehiculoRepository.countByCategoria_TipoTransporte_id((long) i + 1);
                tipoTransporteCount.add(tipoTransporte);
            }

            ArrayList<Long> categoriaCount = new ArrayList<>();
            for (int i = 0; i < categoriaRepository.count(); i++) {
                long categoria = vehiculoRepository.countByCategoria_id((long) i + 1);
                categoriaCount.add(categoria);
            }

            Map<String, Object> response = new HashMap<>();

            response.put("estatusVehiculoCount", estatusVehiculoCount);
            response.put("tipoTransporteCount", tipoTransporteCount);
            response.put("categoriaCount", categoriaCount);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Map<String, Object>> getVehiculos(
            @RequestParam(required = false) String noEconomico,

            @RequestParam(defaultValue = "0") Long areaId,
            @RequestParam(defaultValue = "0") Long resguardanteId,
            @RequestParam(defaultValue = "0") Long estatusVehiculoId,
            @RequestParam(defaultValue = "0") Long categoriaId,
            @RequestParam(defaultValue = "1") Long tipoTransporteId,

            @RequestParam(defaultValue = "noEconomico") String filter,
            @RequestParam(defaultValue = "ASC") Sort.Direction direction,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size
    ) {
        List<Vehiculo> vehiculo_;
        Pageable paging = PageRequest.of(page, size, Sort.by(direction, filter));
        Page<Vehiculo> pageReps;

        try {
            if (noEconomico != null && areaId != 0) {
                pageReps = vehiculoRepository.findByNoEconomicoContainingAndArea_id(noEconomico, areaId, paging);
            } else if (noEconomico != null && resguardanteId != 0) {
                pageReps = vehiculoRepository.findByNoEconomicoContainingAndResguardante_id(noEconomico, resguardanteId, paging);
            } else if (noEconomico != null) {
                pageReps = vehiculoRepository.findByNoEconomicoContaining(noEconomico, paging);
            } else if (areaId != 0 && resguardanteId != 0 && estatusVehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = vehiculoRepository.findByArea_idAndResguardante_idAndEstatusVehiculo_idAndCategoria_idAndCategoria_TipoTransporte_id(areaId, resguardanteId, estatusVehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (areaId != 0 && resguardanteId != 0 && estatusVehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = vehiculoRepository.findByArea_idAndResguardante_idAndEstatusVehiculo_idAndCategoria_TipoTransporte_id(areaId, resguardanteId, estatusVehiculoId, tipoTransporteId, paging);
            } else if (areaId != 0 && resguardanteId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = vehiculoRepository.findByArea_idAndResguardante_idAndCategoria_idAndCategoria_TipoTransporte_id(areaId, resguardanteId, categoriaId, tipoTransporteId, paging);
            } else if (areaId != 0 && estatusVehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = vehiculoRepository.findByArea_idAndEstatusVehiculo_idAndCategoria_idAndCategoria_TipoTransporte_id(areaId, estatusVehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (resguardanteId != 0 && estatusVehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = vehiculoRepository.findByResguardante_idAndEstatusVehiculo_idAndCategoria_idAndCategoria_TipoTransporte_id(resguardanteId, estatusVehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (areaId != 0 && resguardanteId != 0 && tipoTransporteId != 0) {
                pageReps = vehiculoRepository.findByArea_idAndResguardante_idAndCategoria_TipoTransporte_id(areaId, resguardanteId, tipoTransporteId, paging);
            } else if (areaId != 0 && estatusVehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = vehiculoRepository.findByArea_idAndEstatusVehiculo_idAndCategoria_TipoTransporte_id(areaId, estatusVehiculoId, tipoTransporteId, paging);
            } else if (areaId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = vehiculoRepository.findByArea_idAndCategoria_idAndCategoria_TipoTransporte_id(areaId, categoriaId, tipoTransporteId, paging);
            } else if (resguardanteId != 0 && estatusVehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = vehiculoRepository.findByResguardante_idAndEstatusVehiculo_idAndCategoria_TipoTransporte_id(resguardanteId, estatusVehiculoId, tipoTransporteId, paging);
            } else if (resguardanteId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = vehiculoRepository.findByResguardante_idAndCategoria_idAndCategoria_TipoTransporte_id(resguardanteId, categoriaId, tipoTransporteId, paging);
            } else if (estatusVehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = vehiculoRepository.findByEstatusVehiculo_idAndCategoria_idAndCategoria_TipoTransporte_id(estatusVehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (areaId != 0 && tipoTransporteId != 0) {
                pageReps = vehiculoRepository.findByArea_idAndCategoria_TipoTransporte_id(areaId, tipoTransporteId, paging);
            } else if (resguardanteId != 0 && tipoTransporteId != 0) {
                pageReps = vehiculoRepository.findByResguardante_idAndCategoria_TipoTransporte_id(resguardanteId, tipoTransporteId, paging);
            } else if (estatusVehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = vehiculoRepository.findByEstatusVehiculo_idAndCategoria_TipoTransporte_id(estatusVehiculoId, tipoTransporteId, paging);
            } else if (categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = vehiculoRepository.findByCategoria_idAndCategoria_TipoTransporte_id(categoriaId, tipoTransporteId, paging);
            } else if (filter != null && tipoTransporteId != 0) {
                int todayMonth = LocalDate.now().getMonthValue();
                pageReps = switch (filter) {
                    case "ultimoDigito" -> switch (todayMonth) {
                        case 1, 12 ->
                                vehiculoRepository.findByCategoria_TipoTransporte_idAndUltimoDigitoOrUltimoDigito(tipoTransporteId, 5, 6, paging);
                        case 2, 11 ->
                                vehiculoRepository.findByCategoria_TipoTransporte_idAndUltimoDigitoOrUltimoDigitoOrUltimoDigitoOrUltimoDigito(tipoTransporteId, 5, 6, 7, 8, paging);
                        case 3, 10 ->
                                vehiculoRepository.findByCategoria_TipoTransporte_idAndUltimoDigitoOrUltimoDigitoOrUltimoDigitoOrUltimoDigito(tipoTransporteId, 7, 8, 3, 4, paging);
                        case 4, 9 ->
                                vehiculoRepository.findByCategoria_TipoTransporte_idAndUltimoDigitoOrUltimoDigitoOrUltimoDigitoOrUltimoDigito(tipoTransporteId, 3, 4, 1, 2, paging);
                        case 5, 8 ->
                                vehiculoRepository.findByCategoria_TipoTransporte_idAndUltimoDigitoOrUltimoDigitoOrUltimoDigitoOrUltimoDigito(tipoTransporteId, 1, 2, 9, 0, paging);
                        case 6, 7 ->
                                vehiculoRepository.findByCategoria_TipoTransporte_idAndUltimoDigitoOrUltimoDigito(tipoTransporteId, 9, 0, paging);
                        default -> vehiculoRepository.findByCategoria_TipoTransporte_id(tipoTransporteId, paging);
                    };
                    case "proximoMantenimiento" -> vehiculoRepository.findByProximoMantenimientoNotNull(paging);
                    case "proximoCambioNeumaticos" ->
                            vehiculoRepository.findByCategoria_TipoTransporte_idAndProximoCambioNeumaticosNotNull(tipoTransporteId, paging);
                    case "fechaRenovacion" ->
                            vehiculoRepository.findByFechaRenovacionNotNullOrFechaRenovacion2NotNull(paging);
                    default -> vehiculoRepository.findByCategoria_TipoTransporte_id(tipoTransporteId, paging);
                };
            } else if (tipoTransporteId != 0) {
                pageReps = vehiculoRepository.findByCategoria_TipoTransporte_id(tipoTransporteId, paging);
            } else {
                pageReps = vehiculoRepository.findAll(paging);
            }

            vehiculo_ = pageReps.getContent();
            Map<String, Object> response = new HashMap<>();

            response.put("vehiculoList", vehiculo_);
            response.put("currentPage", pageReps.getNumber());
            response.put("totalItems", pageReps.getTotalElements());
            response.put("totalPages", pageReps.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}