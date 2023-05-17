package com.example.app.Repositories.Tramites;

import com.example.app.Models.Tramites.SolicitudCombustible;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface SolicitudCombustibleRepository extends JpaRepository<SolicitudCombustible,Long>, PagingAndSortingRepository<SolicitudCombustible,Long> {
    Optional<SolicitudCombustible> findById(Long id);
    Optional<SolicitudCombustible> findByFolio(String folio);
    Page<SolicitudCombustible> findAll(Pageable paging);

    Page<SolicitudCombustible> findByVehiculo_Categoria_TipoTransporte_id(Long tipoTransporteId, Pageable paging);

    //Folio filters
    Page<SolicitudCombustible> findByFolioContaining(String folio, Pageable paging);
    Page<SolicitudCombustible> findByFolioContainingAndVehiculo_id(String folio, Long vehiculoId, Pageable paging);
    Page<SolicitudCombustible> findByFolioContainingAndArea_id(String folio, Long areaId, Pageable paging);


    //1 Filter
    Page<SolicitudCombustible> findByVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long categoriaId, Long tipoTransporteId, Pageable paging);//000001
    Page<SolicitudCombustible> findByVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(Long vehiculoId, Long tipoTransporteId, Pageable paging);//000010
    Page<SolicitudCombustible> findByTipoSolicitud_idAndVehiculo_Categoria_TipoTransporte_id(Long tipoSolicitudId, Long tipoTransporteId,Pageable paging);//000100
    Page<SolicitudCombustible> findByMunicipio_idAndVehiculo_Categoria_TipoTransporte_id(Long municipioId, Long tipoTransporteId, Pageable paging);//001000
    Page<SolicitudCombustible> findByArea_idAndVehiculo_Categoria_TipoTransporte_id(Long areaId, Long tipoTransporteId, Pageable pageable);//010000
    Page<SolicitudCombustible> findByFechaBetweenAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long tipoTransporteId, Pageable paging);//100000

    //2 Filters
    Page<SolicitudCombustible> findByVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//000011
    Page<SolicitudCombustible> findByTipoSolicitud_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long tipoSolicitudId, Long categoriaId, Long tipoTransporteId, Pageable paging);//000101
    Page<SolicitudCombustible> findByTipoSolicitud_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(Long tipoSolicitudId, Long vehiculoId, Long tipoTransporteId, Pageable paging);//000110
    Page<SolicitudCombustible> findByMunicipio_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long municipioId, Long categoriaId, Long tipoTransporteId, Pageable paging);//001001
    Page<SolicitudCombustible> findByMunicipio_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(Long municipioId, Long vehiculoId, Long tipoTransporteId, Pageable paging);//001010
    Page<SolicitudCombustible> findByMunicipio_idAndTipoSolicitud_idAndVehiculo_Categoria_TipoTransporte_id(Long municipioId, Long tipoSolicitudId, Long tipoTransporteId, Pageable paging);//001100
    Page<SolicitudCombustible> findByArea_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long areaId, Long categoriaId, Long tipoTransporteId, Pageable paging);//010001
    Page<SolicitudCombustible> findByArea_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(Long areaId, Long vehiculoId, Long tipoTransporteId, Pageable paging);//010010
    Page<SolicitudCombustible> findByArea_idAndTipoSolicitud_idAndVehiculo_Categoria_TipoTransporte_id(Long areaId, Long tipoSolicitudId, Long tipoTransporteId, Pageable paging);//010100
    Page<SolicitudCombustible> findByArea_idAndMunicipio_idAndVehiculo_Categoria_TipoTransporte_id(Long areaId, Long municipioId, Long tipoTransporteId, Pageable paging);//011000
    Page<SolicitudCombustible> findByFechaBetweenAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long categoriaId, Long tipoTransporteId, Pageable paging);//100001
    Page<SolicitudCombustible> findByFechaBetweenAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long vehiculoId, Long tipoTransporteId, Pageable paging);//100010
    Page<SolicitudCombustible> findByFechaBetweenAndTipoSolicitud_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long tipoSolicitudId, Long tipoTransporteId, Pageable paging);//100100
    Page<SolicitudCombustible> findByFechaBetweenAndMunicipio_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long municipioId, Long tipoTransporteId, Pageable paging);//101000
    Page<SolicitudCombustible> findByFechaBetweenAndArea_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long areaId, Long tipoTransporteId, Pageable paging);//110000

    //3 Filters
    Page<SolicitudCombustible> findByTipoSolicitud_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long tipoSolicitudId, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//000111
    Page<SolicitudCombustible> findByMunicipio_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long municipioId, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//001011
    Page<SolicitudCombustible> findByMunicipio_idAndTipoSolicitud_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long municipioId, Long tipoSolicitudId, Long categoriaId, Long tipoTransporteId, Pageable paging);//001101
    Page<SolicitudCombustible> findByMunicipio_idAndTipoSolicitud_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(Long municipioId, Long tipoSolicitudId, Long vehiculoId, Long tipoTransporteId, Pageable paging);//001110
    Page<SolicitudCombustible> findByArea_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long areaId, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//010011
    Page<SolicitudCombustible> findByArea_idAndTipoSolicitud_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long areaId, Long tipoSolicitudId, Long categoriaId, Long tipoTransporteId, Pageable paging);//010101
    Page<SolicitudCombustible> findByArea_idAndTipoSolicitud_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(Long areaId, Long tipoSolicitudId, Long vehiculoId, Long tipoTransporteId, Pageable paging);//010110
    Page<SolicitudCombustible> findByArea_idAndMunicipio_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long areaId, Long municipioId, Long categoriaId, Long tipoTransporteId, Pageable paging);//011001
    Page<SolicitudCombustible> findByArea_idAndMunicipio_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(Long areaId, Long municipioId, Long vehiculoId, Long tipoTransporteId, Pageable paging);//011010
    Page<SolicitudCombustible> findByArea_idAndMunicipio_idAndTipoSolicitud_idAndVehiculo_Categoria_TipoTransporte_id(Long areaId, Long municipioId, Long tipoSolicitudId, Long tipoTransporteId, Pageable paging); //011100
    Page<SolicitudCombustible> findByFechaBetweenAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//100011
    Page<SolicitudCombustible> findByFechaBetweenAndTipoSolicitud_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long tipoSolicitudId, Long categoriaId, Long tipoTransporteId, Pageable paging);//100101
    Page<SolicitudCombustible> findByFechaBetweenAndTipoSolicitud_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long tipoSolicitudId, Long vehiculoId, Long tipoTransporteId, Pageable paging);//100110
    Page<SolicitudCombustible> findByFechaBetweenAndMunicipio_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long municipioId, Long categoriaId, Long tipoTransporteId, Pageable paging);//101001
    Page<SolicitudCombustible> findByFechaBetweenAndMunicipio_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long municipioId, Long vehiculoId, Long tipoTransporteId, Pageable paging);//101010
    Page<SolicitudCombustible> findByFechaBetweenAndMunicipio_idAndTipoSolicitud_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long municipioId, Long tipoSolicitudId, Long tipoTransporteId, Pageable paging);//101100
    Page<SolicitudCombustible> findByFechaBetweenAndArea_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long areaId, Long categoriaId, Long tipoTransporteId, Pageable paging);//110001
    Page<SolicitudCombustible> findByFechaBetweenAndArea_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long areaId, Long vehiculoId, Long tipoTransporteId, Pageable paging);//110010
    Page<SolicitudCombustible> findByFechaBetweenAndArea_idAndTipoSolicitud_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long areaId, Long tipoSolicitudId, Long tipoTransporteId, Pageable paging);//110100
    Page<SolicitudCombustible> findByFechaBetweenAndArea_idAndMunicipio_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long areaId, Long municipioId, Long tipoTransporteId, Pageable paging);//111000

    //4 Filters
    Page<SolicitudCombustible> findByMunicipio_idAndTipoSolicitud_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long municipioId, Long tipoSolicitudId, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//001111
    Page<SolicitudCombustible> findByArea_idAndTipoSolicitud_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long areaId, Long tipoSolicitudId, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//010111
    Page<SolicitudCombustible> findByArea_idAndMunicipio_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long areaId, Long municipioId, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//011011
    Page<SolicitudCombustible> findByArea_idAndMunicipio_idAndTipoSolicitud_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long areaId, Long municipioId, Long tipoSolicitudId, Long categoriaId, Long tipoTransporteId, Pageable paging);//011101
    Page<SolicitudCombustible> findByArea_idAndMunicipio_idAndTipoSolicitud_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(Long areaId, Long municipioId, Long tipoSolicitudId, Long vehiculoId, Long tipoTransporteId, Pageable paging);//011110
    Page<SolicitudCombustible> findByFechaBetweenAndTipoSolicitud_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long tipoSolicitudId, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//100111
    Page<SolicitudCombustible> findByFechaBetweenAndMunicipio_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long municipioId, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//101011
    Page<SolicitudCombustible> findByFechaBetweenAndMunicipio_idAndTipoSolicitud_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long municipioId, Long tipoSolicitudId, Long categoriaId, Long tipoTransporteId, Pageable paging);//101101
    Page<SolicitudCombustible> findByFechaBetweenAndMunicipio_idAndTipoSolicitud_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long municipioId, Long tipoSolicitudId, Long vehiculoId, Long tipoTransporteId, Pageable paging);//101110
    Page<SolicitudCombustible> findByFechaBetweenAndArea_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long areaId, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//110011
    Page<SolicitudCombustible> findByFechaBetweenAndArea_idAndTipoSolicitud_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long areaId, Long tipoSolicitudId, Long categoriaId, Long tipoTransporteId, Pageable paging);//110101
    Page<SolicitudCombustible> findByFechaBetweenAndArea_idAndTipoSolicitud_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long areaId, Long tipoSolicitudId, Long vehiculoId, Long tipoTransporteId, Pageable paging);//110110
    Page<SolicitudCombustible> findByFechaBetweenAndArea_idAndMunicipio_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long areaId, Long municipioId, Long categoriaId, Long tipoTransporteId, Pageable paging);//111001
    Page<SolicitudCombustible> findByFechaBetweenAndArea_idAndMunicipio_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long areaId, Long municipioId, Long vehiculoId, Long tipoTransporteId, Pageable paging);//111010
    Page<SolicitudCombustible> findByFechaBetweenAndArea_idAndMunicipio_idAndTipoSolicitud_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long areaId, Long municipioId, Long tipoSolicitudId, Long tipoTransporteId, Pageable paging); //111100

    //5 Filters
    Page<SolicitudCombustible> findByArea_idAndMunicipio_idAndTipoSolicitud_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long areaId, Long municipioId, Long tipoSolicitudId, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//011111
    Page<SolicitudCombustible> findByFechaBetweenAndMunicipio_idAndTipoSolicitud_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long municipioId, Long tipoSolicitudId, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//101111
    Page<SolicitudCombustible> findByFechaBetweenAndArea_idAndTipoSolicitud_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long areaId, Long tipoSolicitudId, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//110111
    Page<SolicitudCombustible> findByFechaBetweenAndArea_idAndMunicipio_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long areaId, Long municipioId, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//111011
    Page<SolicitudCombustible> findByFechaBetweenAndArea_idAndMunicipio_idAndTipoSolicitud_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long areaId, Long municipioId, Long tipoSolicitudId, Long categoriaId, Long tipoTransporteId, Pageable paging);//111101
    Page<SolicitudCombustible> findByFechaBetweenAndArea_idAndMunicipio_idAndTipoSolicitud_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long areaId, Long municipioId, Long tipoSolicitudId, Long vehiculoId, Long tipoTransporteId, Pageable paging);//111110

    //6 Filters
    Page<SolicitudCombustible> findByFechaBetweenAndArea_idAndMunicipio_idAndTipoSolicitud_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long areaId, Long municipioId, Long tipoSolicitudId, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//111111
}