package com.example.app.Repositories;

import com.example.app.Models.Vehiculo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long>, PagingAndSortingRepository<Vehiculo, Long> {
    Vehiculo findByNoEconomico(String folio);
    Optional<Vehiculo> findById(Long id);
    Page<Vehiculo> findAll(Pageable pageable);

    Boolean existsByNoEconomico(String noEconomico);

    Integer countByEstatusVehiculo_id(Long estatusVehiculoId);
    Integer countByCategoria_TipoTransporte_id(Long tipoTransporteId);
    Integer countByCategoria_id(Long categoriaId);

    List<Vehiculo> findByCategoria_TipoTransporte_id(Long tipoTransporteId);
    Page<Vehiculo> findByCategoria_TipoTransporte_id(Long tipoTransporteId, Pageable paging);

    //Dashboard filters
    Page<Vehiculo> findByCategoria_TipoTransporte_idAndUltimoDigitoOrUltimoDigito (Long tipoTransporteId, Integer ultimoDigito1, Integer ultimoDigito2, Pageable paging);
    Page<Vehiculo> findByCategoria_TipoTransporte_idAndUltimoDigitoOrUltimoDigitoOrUltimoDigitoOrUltimoDigito (Long tipoTransporteId, Integer ultimoDigito1, Integer ultimoDigito2, Integer ultimoDigito3, Integer ultimoDigito4, Pageable paging);
    Page<Vehiculo> findByProximoMantenimientoNotNull(Pageable paging);
    Page<Vehiculo> findByCategoria_TipoTransporte_idAndProximoCambioNeumaticosNotNull(Long tipoTransporteId, Pageable paging);
    Page<Vehiculo> findByFechaRenovacionNotNullOrFechaRenovacion2NotNull(Pageable paging);

    //NoEconomico filters
    Page<Vehiculo> findByNoEconomicoContaining(String noEconomico, Pageable paging);
    Page<Vehiculo> findByNoEconomicoContainingAndResguardante_id(String noEconomico, Long resguardanteId, Pageable paging);
    Page<Vehiculo> findByNoEconomicoContainingAndArea_id(String noEconomico, Long areaId, Pageable paging);

    //1 Filter
    Page<Vehiculo> findByCategoria_idAndCategoria_TipoTransporte_id(Long categoriaId, Long tipoTransporteId, Pageable paging);//0001
    Page<Vehiculo> findByEstatusVehiculo_idAndCategoria_TipoTransporte_id(Long estatusVehiculoId, Long tipoTransporteId, Pageable paging);//0010
    Page<Vehiculo> findByResguardante_idAndCategoria_TipoTransporte_id(Long resguardanteId, Long tipoTransporteId, Pageable paging);//0100
    Page<Vehiculo> findByArea_idAndCategoria_TipoTransporte_id(Long areaId, Long tipoTransporteId, Pageable paging);//1000

    //2 Filters
    Page<Vehiculo> findByEstatusVehiculo_idAndCategoria_idAndCategoria_TipoTransporte_id(Long estatusVehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//0011
    Page<Vehiculo> findByResguardante_idAndCategoria_idAndCategoria_TipoTransporte_id(Long resguardanteId, Long categoriaId, Long tipoTransporteId, Pageable paging);//0101
    Page<Vehiculo> findByResguardante_idAndEstatusVehiculo_idAndCategoria_TipoTransporte_id(Long resguardanteId, Long estatusVehiculoId, Long tipoTransporteId, Pageable paging);//0110
    Page<Vehiculo> findByArea_idAndCategoria_idAndCategoria_TipoTransporte_id(Long areaId, Long categoriaId, Long tipoTransporteId, Pageable paging);//1001
    Page<Vehiculo> findByArea_idAndEstatusVehiculo_idAndCategoria_TipoTransporte_id(Long areaId, Long estatusVehiculoId, Long tipoTransporteId, Pageable paging);//1010
    Page<Vehiculo> findByArea_idAndResguardante_idAndCategoria_TipoTransporte_id(Long areaId, Long resguardanteId, Long tipoTransporteId, Pageable paging);//1100

    //3 Filters
    Page<Vehiculo> findByResguardante_idAndEstatusVehiculo_idAndCategoria_idAndCategoria_TipoTransporte_id(Long resguardanteId, Long estatusVehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//0111
    Page<Vehiculo> findByArea_idAndEstatusVehiculo_idAndCategoria_idAndCategoria_TipoTransporte_id(Long areaId, Long estatusVehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//1011
    Page<Vehiculo> findByArea_idAndResguardante_idAndCategoria_idAndCategoria_TipoTransporte_id(Long areaId, Long resguardanteId, Long categoriaId, Long tipoTransporteId, Pageable paging);//1101
    Page<Vehiculo> findByArea_idAndResguardante_idAndEstatusVehiculo_idAndCategoria_TipoTransporte_id(Long areaId, Long resguardanteId, Long estatusVehiculoId, Long tipoTransporteId, Pageable paging);//1110

    //4 Filters
    Page<Vehiculo> findByArea_idAndResguardante_idAndEstatusVehiculo_idAndCategoria_idAndCategoria_TipoTransporte_id(Long areaId, Long resguardanteId, Long estatusVehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//1111
}