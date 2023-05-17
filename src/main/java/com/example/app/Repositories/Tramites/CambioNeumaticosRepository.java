package com.example.app.Repositories.Tramites;

import com.example.app.Models.Tramites.CambioNeumaticos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface CambioNeumaticosRepository extends JpaRepository<CambioNeumaticos, Long>, PagingAndSortingRepository<CambioNeumaticos, Long> {
    Optional<CambioNeumaticos> findById(Long id);
    Page<CambioNeumaticos> findAll(Pageable pageable);

    Page<CambioNeumaticos> findByVehiculo_Categoria_TipoTransporte_id(Long tipoTransporteId, Pageable paging);

    //Folio filters
    Page<CambioNeumaticos> findByFolioContaining(String folio, Pageable paging);
    Page<CambioNeumaticos> findByFolioContainingAndVehiculo_id(String folio, Long vehiculoId, Pageable paging);

    //1 Filter
    Page<CambioNeumaticos> findByVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long categoriaId, Long tipoTransporteId, Pageable paging);//001
    Page<CambioNeumaticos> findByVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(Long vehiculoId, Long tipoTransporteId, Pageable paging);//010
    Page<CambioNeumaticos> findByFechaBetweenAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long tipoTransporteId, Pageable pageable);//100

    //2 Filters
    Page<CambioNeumaticos> findByVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging); //011
    Page<CambioNeumaticos> findByFechaBetweenAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long categoriaId, Long tipoTransporteId, Pageable paging);//101
    Page<CambioNeumaticos> findByFechaBetweenAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long vehiculoId, Long tipoTransporteId, Pageable paging);//110

    //3 Filters
    Page<CambioNeumaticos> findByFechaBetweenAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//111
}
