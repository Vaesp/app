package com.example.app.Repositories.Tramites;

import com.example.app.Models.Tramites.CambioNeumaticos;
import com.example.app.Models.Tramites.Verificacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface VerificacionRepository extends JpaRepository<Verificacion,Long>, PagingAndSortingRepository<Verificacion,Long> {
    Optional<Verificacion> findById(Long id);
    Page<Verificacion> findAll(Pageable pageable);

    Page<Verificacion> findByVehiculo_Categoria_TipoTransporte_id(Long tipoTransporteId, Pageable paging);

    //Folio filters
    Page<Verificacion> findByFolioContaining(String folio, Pageable paging);
    Page<Verificacion> findByFolioContainingAndVehiculo_id(String folio, Long vehiculoId, Pageable paging);


    //1 Filter
    Page<Verificacion> findByVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long categoriaId, Long tipoTransporteId, Pageable paging);//0001
    Page<Verificacion> findByVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(Long vehiculoId, Long tipoTransporteId, Pageable paging);//0010
    Page<Verificacion> findByPeriodoVerificacion_idAndVehiculo_Categoria_TipoTransporte_id(Long periodoVerificacionId, Long tipoTransporteId, Pageable paging);//0100
    Page<Verificacion> findByFechaBetweenAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long tipoTransporteId, Pageable pageable);//1000

    //2 Filters
    Page<Verificacion> findByVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//0011
    Page<Verificacion> findByPeriodoVerificacion_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long periodoVerificacionId, Long categoriaId, Long tipoTransporteId, Pageable paging);//0101
    Page<Verificacion> findByPeriodoVerificacion_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(Long periodoVerificacionId, Long vehiculoId, Long tipoTransporteId, Pageable paging);//0110
    Page<Verificacion> findByFechaBetweenAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long categoriaId, Long tipoTransporteId, Pageable paging);//1001
    Page<Verificacion> findByFechaBetweenAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long vehiculoId, Long tipoTransporteId, Pageable paging);//1010
    Page<Verificacion> findByFechaBetweenAndPeriodoVerificacion_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long periodoVerificacionId, Long tipoTransporteId, Pageable paging);//1100

    //3 Filters
    Page<Verificacion> findByPeriodoVerificacion_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long periodoVerificacionId, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//0111
    Page<Verificacion> findByFechaBetweenAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//1011
    Page<Verificacion> findByFechaBetweenAndPeriodoVerificacion_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long periodoVerificacionId, Long categoriaId, Long tipoTransporteId, Pageable paging);//1101
    Page<Verificacion> findByFechaBetweenAndPeriodoVerificacion_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long periodoVerificacionId, Long vehiculoId, Long tipoTransporteId, Pageable paging);//1110

    //4 Filters
    Page<Verificacion> findByFechaBetweenAndPeriodoVerificacion_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long periodoVerificacionId, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//1111
}

