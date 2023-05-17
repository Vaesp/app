package com.example.app.Repositories.Tramites;

import com.example.app.Models.Tramites.Mantenimiento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface MantenimientoRepository extends JpaRepository<Mantenimiento, Long>, PagingAndSortingRepository<Mantenimiento, Long> {
    Optional<Mantenimiento> findById(Long id);
    Page<Mantenimiento> findAll(Pageable pageable);

    Page<Mantenimiento> findByVehiculo_Categoria_TipoTransporte_id(Long tipoTransporteId, Pageable paging);

    //Folio filters
    Page<Mantenimiento> findByFolioContaining(String folio, Pageable paging);
    Page<Mantenimiento> findByFolioContainingAndVehiculo_id(String folio, Long vehiculoId, Pageable paging);

    //1 Filter
    Page<Mantenimiento> findByVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long categoriaId, Long tipoTransporteId, Pageable paging);//00001
    Page<Mantenimiento> findByVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(Long vehiculoId, Long tipoTransporteId, Pageable paging);//00010
    Page<Mantenimiento> findByEstatusTramite_idAndVehiculo_Categoria_TipoTransporte_id(Long estatusTramiteId, Long tipoTransporteid, Pageable paging);//00100
    Page<Mantenimiento> findByTipoMantenimiento_idAndVehiculo_Categoria_TipoTransporte_id(Long tipoMantenimientoId, Long tipoTransporteId, Pageable pageable);//01000
    Page<Mantenimiento> findByFechaBetweenAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long tipoTransporteId, Pageable paging);//10000

    //2 Filters
    Page<Mantenimiento> findByVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//00011
    Page<Mantenimiento> findByEstatusTramite_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long estatusTramiteId, Long categoriaId, Long tipoTransporteId, Pageable paging);//00101
    Page<Mantenimiento> findByEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(Long estatusTramiteId, Long vehiculoId, Long tipoTransporteId, Pageable paging);//00110
    Page<Mantenimiento> findByTipoMantenimiento_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long tipoMantenimientoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//01001
    Page<Mantenimiento> findByTipoMantenimiento_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(Long tipoMantenimientoId, Long vehiculoId, Long tipoTransporteId, Pageable paging);//01010
    Page<Mantenimiento> findByTipoMantenimiento_idAndEstatusTramite_idAndVehiculo_Categoria_TipoTransporte_id(Long tipoMantenimientoId, Long estatusTramiteId, Long tipoTransporteId, Pageable paging);//01100
    Page<Mantenimiento> findByFechaBetweenAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long categoriaId, Long tipoTransporteId, Pageable paging);//10001
    Page<Mantenimiento> findByFechaBetweenAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long vehiculoId, Long tipoTransporteId, Pageable paging);//10010
    Page<Mantenimiento> findByFechaBetweenAndEstatusTramite_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long estatusTramiteId, Long tipoTransporteId, Pageable paging);//10100
    Page<Mantenimiento> findByFechaBetweenAndTipoMantenimiento_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long tipoMantenimientoId, Long tipoTransporteId, Pageable paging);//11000

    //3 Filters
    Page<Mantenimiento> findByEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long estatusTramiteId, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//00111
    Page<Mantenimiento> findByTipoMantenimiento_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long tipoMantenimientoId, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//01011
    Page<Mantenimiento> findByTipoMantenimiento_idAndEstatusTramite_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long tipoMantenimientoId, Long estatusTramiteId, Long categoriaId, Long tipoTransporteId, Pageable paging);//01101
    Page<Mantenimiento> findByTipoMantenimiento_idAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(Long tipoMantenimientoId, Long estatusTramiteId, Long vehiculoId, Long tipoTransporteId, Pageable paging);//01110
    Page<Mantenimiento> findByFechaBetweenAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//10011
    Page<Mantenimiento> findByFechaBetweenAndEstatusTramite_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long estatusTramiteId, Long categoriaId, Long tipoTransporteId, Pageable paging);//10101
    Page<Mantenimiento> findByFechaBetweenAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long estatusTramiteId, Long vehiculoId, Long tipoTransporteId, Pageable paging);//10110
    Page<Mantenimiento> findByFechaBetweenAndTipoMantenimiento_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long tipoMantenimientoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//11001
    Page<Mantenimiento> findByFechaBetweenAndTipoMantenimiento_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long tipoMantenimientoId, Long vehiculoId, Long tipoTransporteId, Pageable paging);//11010
    Page<Mantenimiento> findByFechaBetweenAndTipoMantenimiento_idAndEstatusTramite_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long tipoMantenimientoId, Long estatusTramiteId, Long tipoTransporteId, Pageable paging);//11100

    //4 Filters
    Page<Mantenimiento> findByTipoMantenimiento_idAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long tipoMantenimientoId, Long estatusTramiteId, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//01111
    Page<Mantenimiento> findByFechaBetweenAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long estatusTramiteId, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//10111
    Page<Mantenimiento> findByFechaBetweenAndTipoMantenimiento_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long tipoMantenimientoId, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//11011
    Page<Mantenimiento> findByFechaBetweenAndTipoMantenimiento_idAndEstatusTramite_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long tipoMantenimientoId, Long estatusTramiteId, Long categoriaId, Long tipoTransporteId, Pageable paging);//11101
    Page<Mantenimiento> findByFechaBetweenAndTipoMantenimiento_idAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long tipoMantenimientoId, Long estatusTramiteId, Long vehiculoId, Long tipoTransporteId, Pageable paging);//11110

    //5 Filters
    Page<Mantenimiento> findByFechaBetweenAndTipoMantenimiento_idAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long tipoMantenimientoId, Long estatusTramiteId, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//11111
}
