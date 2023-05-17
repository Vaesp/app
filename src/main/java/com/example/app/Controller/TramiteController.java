package com.example.app.Controller;

import com.example.app.Repositories.Tramites.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET}, maxAge = 3600)

@RestController
@RequestMapping(path = "/api/auth/tramite")
//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public class TramiteController {
    @Autowired
    CambioNeumaticosRepository cambioNeumaticosRepository;
    @Autowired
    MantenimientoRepository mantenimientoRepository;
    @Autowired
    ReporteIncidenciasRepository reporteIncidenciasRepository;
    @Autowired
    ResguardoTemporalRepository resguardoTemporalRepository;
    @Autowired
    SolicitudCombustibleRepository solicitudCombustibleRepository;
    @Autowired
    VerificacionRepository verificacionRepository;

    @GetMapping(path = "/count")
    public ResponseEntity<Map<String, Object>> countTramiteList() {
        try {
            long cambioNeumaticosCount = cambioNeumaticosRepository.count();
            long mantenimientoCount = mantenimientoRepository.count();
            long reporteIncidenciasCount = reporteIncidenciasRepository.count();
            long resguardoTemporalCount = resguardoTemporalRepository.count();
            long solicitudCombustibleCount = solicitudCombustibleRepository.count();
            long verificacionCount = verificacionRepository.count();

            long[] tramitesCount = new long[]{cambioNeumaticosCount, mantenimientoCount, reporteIncidenciasCount, resguardoTemporalCount, solicitudCombustibleCount, verificacionCount};
            long totalCount = cambioNeumaticosCount + mantenimientoCount + reporteIncidenciasCount + resguardoTemporalCount + solicitudCombustibleCount + verificacionCount;

            Map<String, Object> response = new HashMap<>();

            response.put("tramitesCount", tramitesCount);
            response.put("totalCount", totalCount);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}