package com.example.app.Controller.Tramites;

import com.example.app.Models.Contador;
import com.example.app.Models.Tramites.ResguardoTemporal;
import com.example.app.Repositories.ContadorRepository;
import com.example.app.Repositories.Tramites.ResguardoTemporalRepository;
import com.example.app.Services.Tramites.ResguardoTemporalService;
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
@RequestMapping(path = "/api/auth/resguardoTemporal")
//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public class ResguardoTemporalController {

    private final ResguardoTemporalService resguardoTemporalService;

    @Autowired
    ResguardoTemporalRepository resguardoTemporalRepository;

    @Autowired
    ContadorRepository contadorRepository;

    public ResguardoTemporalController(ResguardoTemporalService resguardoTemporalService) {
        this.resguardoTemporalService = resguardoTemporalService;
    }

    @PostMapping
    public ResponseEntity<ResguardoTemporal> addResguardoTemporal(@RequestBody ResguardoTemporal resguardoTemporal) {
        ResguardoTemporal _resguardoTemporal = new ResguardoTemporal();
        Contador _contador = contadorRepository.getById(4L);

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

        _resguardoTemporal.setFolio(AbreviaturaFolio + ShortYear + FormatedContador);
        _resguardoTemporal.setSolicitante(resguardoTemporal.getSolicitante());
        _resguardoTemporal.setComodatario(resguardoTemporal.getComodatario());
        _resguardoTemporal.setNoOficio(resguardoTemporal.getNoOficio());
        _resguardoTemporal.setMotivo(resguardoTemporal.getMotivo());
        _resguardoTemporal.setFechaSalida(resguardoTemporal.getFechaSalida());
        _resguardoTemporal.setFechaLlegada(resguardoTemporal.getFechaLlegada());
        _resguardoTemporal.setKmSalida(resguardoTemporal.getKmSalida());
        _resguardoTemporal.setKmLlegada(resguardoTemporal.getKmLlegada());
        _resguardoTemporal.setObservacionesSalida(resguardoTemporal.getObservacionesSalida());
        _resguardoTemporal.setObservacionesLlegada(resguardoTemporal.getObservacionesLlegada());
        _resguardoTemporal.setAntenaRadioS(resguardoTemporal.getAntenaRadioS());
        _resguardoTemporal.setPlumasParabrisasS(resguardoTemporal.getPlumasParabrisasS());
        _resguardoTemporal.setLlantaRefaccionS(resguardoTemporal.getLlantaRefaccionS());
        _resguardoTemporal.setTaponGasolinaS(resguardoTemporal.getTaponGasolinaS());
        _resguardoTemporal.setTaponAceiteS(resguardoTemporal.getTaponAceiteS());
        _resguardoTemporal.setPlacaDelanteraS(resguardoTemporal.getPlacaDelanteraS());
        _resguardoTemporal.setPlacaTraseraS(resguardoTemporal.getPlacaTraseraS());
        _resguardoTemporal.setEspejoDerechoS(resguardoTemporal.getEspejoDerechoS());
        _resguardoTemporal.setEspejoIzquierdoS(resguardoTemporal.getEspejoIzquierdoS());
        _resguardoTemporal.setTaponesLlantaS(resguardoTemporal.getTaponesLlantaS());
        _resguardoTemporal.setAntenaVHFS(resguardoTemporal.getAntenaVHFS());
        _resguardoTemporal.setHerramientaS(resguardoTemporal.getHerramientaS());
        _resguardoTemporal.setReflejantesS(resguardoTemporal.getReflejantesS());
        _resguardoTemporal.setAireAcondicionadoS(resguardoTemporal.getAireAcondicionadoS());
        _resguardoTemporal.setExtintorS(resguardoTemporal.getExtintorS());
        _resguardoTemporal.setGatoS(resguardoTemporal.getGatoS());
        _resguardoTemporal.setPolizaSeguroS(resguardoTemporal.getPolizaSeguroS());
        _resguardoTemporal.setCalcomaniaVerificacionS(resguardoTemporal.getCalcomaniaVerificacionS());
        _resguardoTemporal.setJuegoLlavesS(resguardoTemporal.getJuegoLlavesS());
        _resguardoTemporal.setTarjetaCirculacionS(resguardoTemporal.getTarjetaCirculacionS());
        _resguardoTemporal.setLicenciaManejoS(resguardoTemporal.getLicenciaManejoS());
        _resguardoTemporal.setBolaArrastreS(resguardoTemporal.getBolaArrastreS());
        _resguardoTemporal.setAntenaRadioL(resguardoTemporal.getAntenaRadioL());
        _resguardoTemporal.setPlumasParabrisasL(resguardoTemporal.getPlumasParabrisasL());
        _resguardoTemporal.setLlantaRefaccionL(resguardoTemporal.getLlantaRefaccionL());
        _resguardoTemporal.setTaponGasolinaL(resguardoTemporal.getTaponGasolinaL());
        _resguardoTemporal.setTaponAceiteL(resguardoTemporal.getTaponAceiteL());
        _resguardoTemporal.setPlacaDelanteraL(resguardoTemporal.getPlacaDelanteraL());
        _resguardoTemporal.setPlacaTraseraL(resguardoTemporal.getPlacaTraseraL());
        _resguardoTemporal.setEspejoDerechoL(resguardoTemporal.getEspejoDerechoL());
        _resguardoTemporal.setEspejoIzquierdoL(resguardoTemporal.getEspejoIzquierdoL());
        _resguardoTemporal.setTaponesLlantaL(resguardoTemporal.getTaponesLlantaL());
        _resguardoTemporal.setAntenaVHFL(resguardoTemporal.getAntenaVHFL());
        _resguardoTemporal.setHerramientaL(resguardoTemporal.getHerramientaL());
        _resguardoTemporal.setReflejantesL(resguardoTemporal.getReflejantesL());
        _resguardoTemporal.setAireAcondicionadoL(resguardoTemporal.getAireAcondicionadoL());
        _resguardoTemporal.setExtintorL(resguardoTemporal.getExtintorL());
        _resguardoTemporal.setGatoL(resguardoTemporal.getGatoL());
        _resguardoTemporal.setPolizaSeguroL(resguardoTemporal.getPolizaSeguroL());
        _resguardoTemporal.setCalcomaniaVerificacionL(resguardoTemporal.getCalcomaniaVerificacionL());
        _resguardoTemporal.setJuegoLlavesL(resguardoTemporal.getJuegoLlavesL());
        _resguardoTemporal.setTarjetaCirculacionL(resguardoTemporal.getTarjetaCirculacionL());
        _resguardoTemporal.setLicenciaManejoL(resguardoTemporal.getLicenciaManejoL());
        _resguardoTemporal.setBolaArrastreL(resguardoTemporal.getBolaArrastreL());
        _resguardoTemporal.setNivelFrenosS(resguardoTemporal.getNivelFrenosS());
        _resguardoTemporal.setNivelFrenosL(resguardoTemporal.getNivelFrenosL());
        _resguardoTemporal.setNivelAceiteS(resguardoTemporal.getNivelAceiteS());
        _resguardoTemporal.setNivelAceiteL(resguardoTemporal.getNivelAceiteL());
        _resguardoTemporal.setNivelAnticongelanteS(resguardoTemporal.getNivelAnticongelanteS());
        _resguardoTemporal.setNivelAnticongelanteL(resguardoTemporal.getNivelAnticongelanteL());
        _resguardoTemporal.setNivelGasolinaS(resguardoTemporal.getNivelGasolinaS());
        _resguardoTemporal.setNivelGasolinaL(resguardoTemporal.getNivelGasolinaL());
        _resguardoTemporal.setVehiculo(resguardoTemporal.getVehiculo());
        _resguardoTemporal.setArea(resguardoTemporal.getArea());
        _resguardoTemporal.setEstatusTramite(resguardoTemporal.getEstatusTramite());
        _resguardoTemporal.setMunicipio(resguardoTemporal.getMunicipio());

        _resguardoTemporal.setTimestamp(LocalDateTime.now().withNano(0));
        _resguardoTemporal.setUserstamp(resguardoTemporal.getUserstamp());

        try {
            resguardoTemporalRepository.save(_resguardoTemporal);
            return new ResponseEntity<>(_resguardoTemporal, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping(path = "/{rId}")
    public ResponseEntity<ResguardoTemporal> deleteResguardoTemporal(@PathVariable("rId") Long rId) {
        try {
            resguardoTemporalService.deleteResguardoTemporal(rId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping(path = "/{rId}")
    public ResponseEntity<ResguardoTemporal> updateResguardoTemporal(@PathVariable("rId") Long rId, @RequestBody ResguardoTemporal resguardoTemporal) {
        Optional<ResguardoTemporal> resguardoData = resguardoTemporalRepository.findById(rId);
        try {
            if (resguardoData.isPresent()) {
                ResguardoTemporal _resguardoTemporal = resguardoData.get();

                _resguardoTemporal.setSolicitante(resguardoTemporal.getSolicitante());
                _resguardoTemporal.setComodatario(resguardoTemporal.getComodatario());
                _resguardoTemporal.setNoOficio(resguardoTemporal.getNoOficio());
                _resguardoTemporal.setMotivo(resguardoTemporal.getMotivo());
                _resguardoTemporal.setFechaSalida(resguardoTemporal.getFechaSalida());
                _resguardoTemporal.setFechaLlegada(resguardoTemporal.getFechaLlegada());
                _resguardoTemporal.setKmSalida(resguardoTemporal.getKmSalida());
                _resguardoTemporal.setKmLlegada(resguardoTemporal.getKmLlegada());
                _resguardoTemporal.setObservacionesSalida(resguardoTemporal.getObservacionesSalida());
                _resguardoTemporal.setObservacionesLlegada(resguardoTemporal.getObservacionesLlegada());
                _resguardoTemporal.setAntenaRadioS(resguardoTemporal.getAntenaRadioS());
                _resguardoTemporal.setPlumasParabrisasS(resguardoTemporal.getPlumasParabrisasS());
                _resguardoTemporal.setLlantaRefaccionS(resguardoTemporal.getLlantaRefaccionS());
                _resguardoTemporal.setTaponGasolinaS(resguardoTemporal.getTaponGasolinaS());
                _resguardoTemporal.setTaponAceiteS(resguardoTemporal.getTaponAceiteS());
                _resguardoTemporal.setPlacaDelanteraS(resguardoTemporal.getPlacaDelanteraS());
                _resguardoTemporal.setPlacaTraseraS(resguardoTemporal.getPlacaTraseraS());
                _resguardoTemporal.setEspejoDerechoS(resguardoTemporal.getEspejoDerechoS());
                _resguardoTemporal.setEspejoIzquierdoS(resguardoTemporal.getEspejoIzquierdoS());
                _resguardoTemporal.setTaponesLlantaS(resguardoTemporal.getTaponesLlantaS());
                _resguardoTemporal.setAntenaVHFS(resguardoTemporal.getAntenaVHFS());
                _resguardoTemporal.setHerramientaS(resguardoTemporal.getHerramientaS());
                _resguardoTemporal.setReflejantesS(resguardoTemporal.getReflejantesS());
                _resguardoTemporal.setAireAcondicionadoS(resguardoTemporal.getAireAcondicionadoS());
                _resguardoTemporal.setExtintorS(resguardoTemporal.getExtintorS());
                _resguardoTemporal.setGatoS(resguardoTemporal.getGatoS());
                _resguardoTemporal.setPolizaSeguroS(resguardoTemporal.getPolizaSeguroS());
                _resguardoTemporal.setCalcomaniaVerificacionS(resguardoTemporal.getCalcomaniaVerificacionS());
                _resguardoTemporal.setJuegoLlavesS(resguardoTemporal.getJuegoLlavesS());
                _resguardoTemporal.setTarjetaCirculacionS(resguardoTemporal.getTarjetaCirculacionS());
                _resguardoTemporal.setLicenciaManejoS(resguardoTemporal.getLicenciaManejoS());
                _resguardoTemporal.setBolaArrastreS(resguardoTemporal.getBolaArrastreS());
                _resguardoTemporal.setAntenaRadioL(resguardoTemporal.getAntenaRadioL());
                _resguardoTemporal.setPlumasParabrisasL(resguardoTemporal.getPlumasParabrisasL());
                _resguardoTemporal.setLlantaRefaccionL(resguardoTemporal.getLlantaRefaccionL());
                _resguardoTemporal.setTaponGasolinaL(resguardoTemporal.getTaponGasolinaL());
                _resguardoTemporal.setTaponAceiteL(resguardoTemporal.getTaponAceiteL());
                _resguardoTemporal.setPlacaDelanteraL(resguardoTemporal.getPlacaDelanteraL());
                _resguardoTemporal.setPlacaTraseraL(resguardoTemporal.getPlacaTraseraL());
                _resguardoTemporal.setEspejoDerechoL(resguardoTemporal.getEspejoDerechoL());
                _resguardoTemporal.setEspejoIzquierdoL(resguardoTemporal.getEspejoIzquierdoL());
                _resguardoTemporal.setTaponesLlantaL(resguardoTemporal.getTaponesLlantaL());
                _resguardoTemporal.setAntenaVHFL(resguardoTemporal.getAntenaVHFL());
                _resguardoTemporal.setHerramientaL(resguardoTemporal.getHerramientaL());
                _resguardoTemporal.setReflejantesL(resguardoTemporal.getReflejantesL());
                _resguardoTemporal.setAireAcondicionadoL(resguardoTemporal.getAireAcondicionadoL());
                _resguardoTemporal.setExtintorL(resguardoTemporal.getExtintorL());
                _resguardoTemporal.setGatoL(resguardoTemporal.getGatoL());
                _resguardoTemporal.setPolizaSeguroL(resguardoTemporal.getPolizaSeguroL());
                _resguardoTemporal.setCalcomaniaVerificacionL(resguardoTemporal.getCalcomaniaVerificacionL());
                _resguardoTemporal.setJuegoLlavesL(resguardoTemporal.getJuegoLlavesL());
                _resguardoTemporal.setTarjetaCirculacionL(resguardoTemporal.getTarjetaCirculacionL());
                _resguardoTemporal.setLicenciaManejoL(resguardoTemporal.getLicenciaManejoL());
                _resguardoTemporal.setBolaArrastreL(resguardoTemporal.getBolaArrastreL());
                _resguardoTemporal.setNivelFrenosS(resguardoTemporal.getNivelFrenosS());
                _resguardoTemporal.setNivelFrenosL(resguardoTemporal.getNivelFrenosL());
                _resguardoTemporal.setNivelAceiteS(resguardoTemporal.getNivelAceiteS());
                _resguardoTemporal.setNivelAceiteL(resguardoTemporal.getNivelAceiteL());
                _resguardoTemporal.setNivelAnticongelanteS(resguardoTemporal.getNivelAnticongelanteS());
                _resguardoTemporal.setNivelAnticongelanteL(resguardoTemporal.getNivelAnticongelanteL());
                _resguardoTemporal.setNivelGasolinaS(resguardoTemporal.getNivelGasolinaS());
                _resguardoTemporal.setNivelGasolinaL(resguardoTemporal.getNivelGasolinaL());
                _resguardoTemporal.setVehiculo(resguardoTemporal.getVehiculo());
                _resguardoTemporal.setArea(resguardoTemporal.getArea());
                _resguardoTemporal.setEstatusTramite(resguardoTemporal.getEstatusTramite());
                _resguardoTemporal.setMunicipio(resguardoTemporal.getMunicipio());

                _resguardoTemporal.setTimestampEdit(LocalDateTime.now().withNano(0));
                _resguardoTemporal.setUserstamp(resguardoTemporal.getUserstamp());

                return new ResponseEntity<>(resguardoTemporalRepository.save(_resguardoTemporal), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(path = "/{rId}")
    public ResponseEntity<ResguardoTemporal> getResguardoTemporalById(@PathVariable("rId") Long rId) {
        Optional<ResguardoTemporal> resguardoData = resguardoTemporalRepository.findById(rId);

        if (resguardoData.isPresent()) {
            return new ResponseEntity<>(resguardoData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getResguardosTemporales(
            @RequestParam(required = false) String folio,

            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaIni,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            @RequestParam(defaultValue = "0") Long areaId,
            @RequestParam(defaultValue = "0") Long municipioId,
            @RequestParam(defaultValue = "0") Long estatusTramiteId,
            @RequestParam(defaultValue = "0") Long vehiculoId,
            @RequestParam(defaultValue = "0") Long categoriaId,
            @RequestParam(defaultValue = "1") Long tipoTransporteId,

            @RequestParam(defaultValue = "folio") String filter,
            @RequestParam(defaultValue = "ASC") Sort.Direction direction,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size
    ) {
        List<ResguardoTemporal> resguardoTemporal_;
        Pageable paging = PageRequest.of(page, size, Sort.by(direction, filter));
        Page<ResguardoTemporal> pageReps;

        try {
            if (folio != null && areaId != 0) {
                pageReps = resguardoTemporalRepository.findByFolioContainingAndArea_id(folio, areaId, paging);
            } else if (folio != null && vehiculoId != 0) {
                pageReps = resguardoTemporalRepository.findByFolioContainingAndVehiculo_id(folio, vehiculoId, paging);
            } else if (folio != null) {
                pageReps = resguardoTemporalRepository.findByFolioContaining(folio, paging);
            } else if (fechaIni != null && fechaFin != null && areaId != 0 && municipioId != 0 && estatusTramiteId != 0 && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByFechaSalidaBetweenAndArea_idAndMunicipio_idAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, areaId, municipioId, estatusTramiteId, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && areaId != 0 && municipioId != 0 && estatusTramiteId != 0 && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByFechaSalidaBetweenAndArea_idAndMunicipio_idAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, areaId, municipioId, estatusTramiteId, vehiculoId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && areaId != 0 && municipioId != 0 && estatusTramiteId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByFechaSalidaBetweenAndArea_idAndMunicipio_idAndEstatusTramite_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, areaId, municipioId, estatusTramiteId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && areaId != 0 && municipioId != 0 && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByFechaSalidaBetweenAndArea_idAndMunicipio_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, areaId, municipioId, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && areaId != 0 && estatusTramiteId != 0 && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByFechaSalidaBetweenAndArea_idAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, areaId, estatusTramiteId, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && municipioId != 0 && estatusTramiteId != 0 && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByFechaSalidaBetweenAndMunicipio_idAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, municipioId, estatusTramiteId, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (areaId != 0 && municipioId != 0 && estatusTramiteId != 0 && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByArea_idAndMunicipio_idAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(areaId, municipioId, estatusTramiteId, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && areaId != 0 && municipioId != 0 && estatusTramiteId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByFechaSalidaBetweenAndArea_idAndMunicipio_idAndEstatusTramite_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, areaId, municipioId, estatusTramiteId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && areaId != 0 && municipioId != 0 && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByFechaSalidaBetweenAndArea_idAndMunicipio_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, areaId, municipioId, vehiculoId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && areaId != 0 && municipioId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByFechaSalidaBetweenAndArea_idAndMunicipio_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, areaId, municipioId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && areaId != 0 && estatusTramiteId != 0 && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByFechaSalidaBetweenAndArea_idAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, areaId, estatusTramiteId, vehiculoId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && areaId != 0 && estatusTramiteId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByFechaSalidaBetweenAndArea_idAndEstatusTramite_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, areaId, estatusTramiteId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && areaId != 0 && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByFechaSalidaBetweenAndArea_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, areaId, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && municipioId != 0 && estatusTramiteId != 0 && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByFechaSalidaBetweenAndMunicipio_idAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, municipioId, estatusTramiteId, vehiculoId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && municipioId != 0 && estatusTramiteId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByFechaSalidaBetweenAndMunicipio_idAndEstatusTramite_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, municipioId, estatusTramiteId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && municipioId != 0 && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByFechaSalidaBetweenAndMunicipio_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, municipioId, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && estatusTramiteId != 0 && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByFechaSalidaBetweenAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, estatusTramiteId, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (areaId != 0 && municipioId != 0 && estatusTramiteId != 0 && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByArea_idAndMunicipio_idAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(areaId, municipioId, estatusTramiteId, vehiculoId, tipoTransporteId, paging);
            } else if (areaId != 0 && municipioId != 0 && estatusTramiteId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByArea_idAndMunicipio_idAndEstatusTramite_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(areaId, municipioId, estatusTramiteId, categoriaId, tipoTransporteId, paging);
            } else if (areaId != 0 && municipioId != 0 && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByArea_idAndMunicipio_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(areaId, municipioId, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (areaId != 0 && estatusTramiteId != 0 && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByArea_idAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(areaId, estatusTramiteId, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (municipioId != 0 && estatusTramiteId != 0 && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByMunicipio_idAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(municipioId, estatusTramiteId, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && areaId != 0 && municipioId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByFechaSalidaBetweenAndArea_idAndMunicipio_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, areaId, municipioId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && areaId != 0 && estatusTramiteId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByFechaSalidaBetweenAndArea_idAndEstatusTramite_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, areaId, estatusTramiteId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && areaId != 0 && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByFechaSalidaBetweenAndArea_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, areaId, vehiculoId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && areaId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByFechaSalidaBetweenAndArea_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, areaId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && municipioId != 0 && estatusTramiteId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByFechaSalidaBetweenAndMunicipio_idAndEstatusTramite_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, municipioId, estatusTramiteId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && municipioId != 0 && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByFechaSalidaBetweenAndMunicipio_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, municipioId, vehiculoId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && municipioId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByFechaSalidaBetweenAndMunicipio_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, municipioId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && estatusTramiteId != 0 && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByFechaSalidaBetweenAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, estatusTramiteId, vehiculoId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && estatusTramiteId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByFechaSalidaBetweenAndEstatusTramite_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, estatusTramiteId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByFechaSalidaBetweenAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (areaId != 0 && municipioId != 0 && estatusTramiteId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByArea_idAndMunicipio_idAndEstatusTramite_idAndVehiculo_Categoria_TipoTransporte_id(areaId, municipioId, estatusTramiteId, tipoTransporteId, paging);
            } else if (areaId != 0 && municipioId != 0 && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByArea_idAndMunicipio_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(areaId, municipioId, vehiculoId, tipoTransporteId, paging);
            } else if (areaId != 0 && municipioId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByArea_idAndMunicipio_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(areaId, municipioId, categoriaId, tipoTransporteId, paging);
            } else if (areaId != 0 && estatusTramiteId != 0 && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByArea_idAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(areaId, estatusTramiteId, vehiculoId, tipoTransporteId, paging);
            } else if (areaId != 0 && estatusTramiteId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByArea_idAndEstatusTramite_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(areaId, estatusTramiteId, categoriaId, tipoTransporteId, paging);
            } else if (areaId != 0 && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByArea_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(areaId, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (municipioId != 0 && estatusTramiteId != 0 && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByMunicipio_idAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(municipioId, estatusTramiteId, vehiculoId, tipoTransporteId, paging);
            } else if (municipioId != 0 && estatusTramiteId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByMunicipio_idAndEstatusTramite_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(municipioId, estatusTramiteId, categoriaId, tipoTransporteId, paging);
            } else if (municipioId != 0 && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByMunicipio_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(municipioId, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (estatusTramiteId != 0 && vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(estatusTramiteId, vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && areaId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByFechaSalidaBetweenAndArea_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, areaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && municipioId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByFechaSalidaBetweenAndMunicipio_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, municipioId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && estatusTramiteId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByFechaSalidaBetweenAndEstatusTramite_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, estatusTramiteId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByFechaSalidaBetweenAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, vehiculoId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByFechaSalidaBetweenAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, categoriaId, tipoTransporteId, paging);
            } else if (areaId != 0 && municipioId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByArea_idAndMunicipio_idAndVehiculo_Categoria_TipoTransporte_id(areaId, municipioId, tipoTransporteId, paging);
            } else if (areaId != 0 && estatusTramiteId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByArea_idAndEstatusTramite_idAndVehiculo_Categoria_TipoTransporte_id(areaId, estatusTramiteId, tipoTransporteId, paging);
            } else if (areaId != 0 && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByArea_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(areaId, vehiculoId, tipoTransporteId, paging);
            } else if (areaId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByArea_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(areaId, categoriaId, tipoTransporteId, paging);
            } else if (municipioId != 0 && estatusTramiteId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByMunicipio_idAndEstatusTramite_idAndVehiculo_Categoria_TipoTransporte_id(municipioId, estatusTramiteId, tipoTransporteId, paging);
            } else if (municipioId != 0 && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByMunicipio_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(municipioId, vehiculoId, tipoTransporteId, paging);
            } else if (municipioId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByMunicipio_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(municipioId, categoriaId, tipoTransporteId, paging);
            } else if (estatusTramiteId != 0 && vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(estatusTramiteId, vehiculoId, tipoTransporteId, paging);
            } else if (estatusTramiteId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByEstatusTramite_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(estatusTramiteId, categoriaId, tipoTransporteId, paging);
            } else if (vehiculoId != 0 && categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(vehiculoId, categoriaId, tipoTransporteId, paging);
            } else if (fechaIni != null && fechaFin != null && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByFechaSalidaBetweenAndVehiculo_Categoria_TipoTransporte_id(fechaIni, fechaFin, tipoTransporteId, paging);
            } else if (areaId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByArea_idAndVehiculo_Categoria_TipoTransporte_id(areaId, tipoTransporteId, paging);
            } else if (municipioId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByMunicipio_idAndVehiculo_Categoria_TipoTransporte_id(municipioId, tipoTransporteId, paging);
            } else if (estatusTramiteId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByEstatusTramite_idAndVehiculo_Categoria_TipoTransporte_id(estatusTramiteId, tipoTransporteId, paging);
            } else if (vehiculoId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(vehiculoId, tipoTransporteId, paging);
            } else if (categoriaId != 0 && tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(categoriaId, tipoTransporteId, paging);
            } else if (tipoTransporteId != 0) {
                pageReps = resguardoTemporalRepository.findByVehiculo_Categoria_TipoTransporte_id(tipoTransporteId, paging);
            } else {
                pageReps = resguardoTemporalRepository.findAll(paging);
            }

            resguardoTemporal_ = pageReps.getContent();
            Map<String, Object> response = new HashMap<>();

            response.put("resguardoTemporalList", resguardoTemporal_);
            response.put("currentPage", pageReps.getNumber());
            response.put("totalItems", pageReps.getTotalElements());
            response.put("totalPages", pageReps.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}