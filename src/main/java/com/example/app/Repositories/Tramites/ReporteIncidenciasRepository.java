package com.example.app.Repositories.Tramites;

import com.example.app.Models.Tramites.ReporteIncidencias;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface ReporteIncidenciasRepository extends JpaRepository<ReporteIncidencias, Long>, PagingAndSortingRepository<ReporteIncidencias, Long> {
    Optional<ReporteIncidencias> findById(Long id);
    Page<ReporteIncidencias> findAll(Pageable pageable);

    Page<ReporteIncidencias> findByVehiculo_Categoria_TipoTransporte_id(Long tipoTransporteId, Pageable paging);

    //Folio filters
    Page<ReporteIncidencias> findByFolioContaining(String folio, Pageable paging);
    Page<ReporteIncidencias> findByFolioContainingAndVehiculo_id(String folio, Long vehiculoId, Pageable paging);


    //1 Filter
    Page<ReporteIncidencias> findByVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long categoriaId, Long tipoTransporteId, Pageable paging);//0001
    Page<ReporteIncidencias> findByVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(Long vehiculoId, Long tipoTransporteId, Pageable paging);//0010
    Page<ReporteIncidencias> findByUbicacionContainingAndVehiculo_Categoria_TipoTransporte_id(String ubicacion, Long tipoTransporteId, Pageable paging);//0100
    Page<ReporteIncidencias> findByFechaBetweenAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long tipoTransporteId, Pageable pageable);//1000

    //2 Filters
    Page<ReporteIncidencias> findByVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//0011
    Page<ReporteIncidencias> findByUbicacionContainingAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(String ubicacion, Long categoriaId, Long tipoTransporteId, Pageable paging);//0101
    Page<ReporteIncidencias> findByUbicacionContainingAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(String ubicacion, Long vehiculoId, Long tipoTransporteId, Pageable paging);//0110
    Page<ReporteIncidencias> findByFechaBetweenAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long categoriaId, Long tipoTransporteId, Pageable paging);//1001
    Page<ReporteIncidencias> findByFechaBetweenAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long vehiculoId, Long tipoTransporteId, Pageable paging);//1010
    Page<ReporteIncidencias> findByFechaBetweenAndUbicacionContainingAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, String ubicacion, Long tipoTransporteId, Pageable paging);//1100

    //3 Filters
    Page<ReporteIncidencias> findByUbicacionContainingAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(String ubicacion, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//0111
    Page<ReporteIncidencias> findByFechaBetweenAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//1011
    Page<ReporteIncidencias> findByFechaBetweenAndUbicacionContainingAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, String ubicacion, Long categoriaId, Long tipoTransporteId, Pageable paging);//1101
    Page<ReporteIncidencias> findByFechaBetweenAndUbicacionContainingAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, String ubicacion, Long vehiculoId, Long tipoTransporteId, Pageable paging);//1110

    //4 Filters
    Page<ReporteIncidencias> findByFechaBetweenAndUbicacionContainingAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, String ubicacion, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//1111
}
