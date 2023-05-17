package com.example.app.Controller;

import com.example.app.Models.Area;
import com.example.app.Repositories.AreaRepository;
import com.example.app.Services.AreaService;
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
@RequestMapping("/api/auth/area")
//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public class AreaController {

    private final AreaService Area;

    @Autowired
    AreaRepository areaRepository;

    @Autowired
    public AreaController(AreaService area) {
        Area = area;
    }

    @PostMapping
    public ResponseEntity<Area> addArea(@RequestBody Area area){
        Area _area = new Area();

        _area.setNombreArea(area.getNombreArea());
        _area.setNombreJefe(area.getNombreJefe());

        _area.setTimestamp(LocalDateTime.now().withNano(0));
        _area.setUserstamp(area.getUserstamp());
        try {
            areaRepository.save(_area);
            return new ResponseEntity<>(_area, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping(path = "/{aId}")
    public ResponseEntity<Area> deleteArea(@PathVariable("aId") Long aId) {
        try {
            Area.deleteArea(aId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping(path = "/{aId}")
    public ResponseEntity<Area> updateArea(@PathVariable("aId") Long aId, @RequestBody Area area) {
        Optional<Area> areaData = areaRepository.findById(aId);

        try {
            if (areaData.isPresent()) {
                Area _area = areaData.get();

                _area.setNombreArea(area.getNombreArea());
                _area.setNombreJefe(area.getNombreJefe());

                _area.setTimestampEdit(LocalDateTime.now().withNano(0));
                _area.setUserstamp(area.getUserstamp());
                return new ResponseEntity<>(areaRepository.save(_area), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(path = "/{aId}")
    public ResponseEntity<Area> getAreaById(@PathVariable("aId") Long aId) {
        Optional<Area> areaData = areaRepository.findById(aId);

        if (areaData.isPresent()) {
            return new ResponseEntity<>(areaData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/list")
    public List<Area> areaList(){
        return areaRepository.findByOrderByNombreArea();
    }

    @GetMapping
    public ResponseEntity<Map<String,Object>> getAreas(
            @RequestParam(required = false) String nombreArea,
            @RequestParam(required = false) String nombreJefe,
            @RequestParam(defaultValue = "nombreArea") String filter,
            @RequestParam(defaultValue = "ASC") Sort.Direction direction,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size
    ){
        List<Area> area_;
        Pageable paging = PageRequest.of(page, size, Sort.by(direction, filter));
        Page<Area> pageReps;

        try {
            if (nombreArea != null && nombreJefe != null){
                pageReps = areaRepository.findByNombreAreaContainingAndNombreJefeContaining(nombreArea, nombreJefe, paging);
            } else if (nombreArea != null){
                pageReps = areaRepository.findByNombreAreaContaining(nombreArea, paging);
            } else if (nombreJefe != null){
                pageReps = areaRepository.findByNombreJefeContaining(nombreJefe, paging);
            }
            else{
                pageReps = areaRepository.findAll(paging);
            }
            area_ = pageReps.getContent();
            Map<String, Object> response = new HashMap<>();

            response.put("areaList", area_);
            response.put("currentPage", pageReps.getNumber());
            response.put("totalItems", pageReps.getTotalElements());
            response.put("totalPages", pageReps.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}