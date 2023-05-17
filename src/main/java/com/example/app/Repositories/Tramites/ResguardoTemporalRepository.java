package com.example.app.Repositories.Tramites;

import com.example.app.Models.Tramites.ResguardoTemporal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface ResguardoTemporalRepository extends JpaRepository<ResguardoTemporal, Long>, PagingAndSortingRepository<ResguardoTemporal, Long> {
    Optional<ResguardoTemporal> findById(Long id);
    Page<ResguardoTemporal> findAll(Pageable paging);

    Page<ResguardoTemporal> findByVehiculo_Categoria_TipoTransporte_id(Long tipoTransporteId, Pageable paging);

    //Folio filters
    Page<ResguardoTemporal> findByFolioContaining(String folio, Pageable paging);
    Page<ResguardoTemporal> findByFolioContainingAndVehiculo_id(String folio, Long vehiculoId, Pageable paging);
    Page<ResguardoTemporal> findByFolioContainingAndArea_id(String folio, Long areaId, Pageable paging);


    //1 Filter
    Page<ResguardoTemporal> findByVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long categoriaId, Long tipoTransporteId, Pageable paging);//000001
    Page<ResguardoTemporal> findByVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(Long vehiculoId, Long tipoTransporteId, Pageable paging);//000010
    Page<ResguardoTemporal> findByEstatusTramite_idAndVehiculo_Categoria_TipoTransporte_id(Long estatusTramiteId, Long tipoTransporteid, Pageable paging);//000100
    Page<ResguardoTemporal> findByMunicipio_idAndVehiculo_Categoria_TipoTransporte_id(Long municipioId, Long tipoTransporteId, Pageable paging);//001000
    Page<ResguardoTemporal> findByArea_idAndVehiculo_Categoria_TipoTransporte_id(Long areaId, Long tipoTransporteId, Pageable pageable);//010000
    Page<ResguardoTemporal> findByFechaSalidaBetweenAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long tipoTransporteId, Pageable paging);//100000

    //2 Filters
    Page<ResguardoTemporal> findByVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//000011
    Page<ResguardoTemporal> findByEstatusTramite_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long estatusTramiteId, Long categoriaId, Long tipoTransporteId, Pageable paging);//000101
    Page<ResguardoTemporal> findByEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(Long estatusTramiteId, Long vehiculoId, Long tipoTransporteId, Pageable paging);//000110
    Page<ResguardoTemporal> findByMunicipio_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long municipioId, Long categoriaId, Long tipoTransporteId, Pageable paging);//001001
    Page<ResguardoTemporal> findByMunicipio_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(Long municipioId, Long vehiculoId, Long tipoTransporteId, Pageable paging);//001010
    Page<ResguardoTemporal> findByMunicipio_idAndEstatusTramite_idAndVehiculo_Categoria_TipoTransporte_id(Long municipioId, Long estatusTramiteId, Long tipoTransporteId, Pageable paging);//001100
    Page<ResguardoTemporal> findByArea_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long areaId, Long categoriaId, Long tipoTransporteId, Pageable paging);//010001
    Page<ResguardoTemporal> findByArea_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(Long areaId, Long vehiculoId, Long tipoTransporteId, Pageable paging);//010010
    Page<ResguardoTemporal> findByArea_idAndEstatusTramite_idAndVehiculo_Categoria_TipoTransporte_id(Long areaId, Long estatusTramiteId, Long tipoTransporteId, Pageable paging);//010100
    Page<ResguardoTemporal> findByArea_idAndMunicipio_idAndVehiculo_Categoria_TipoTransporte_id(Long areaId, Long municipioId, Long tipoTransporteId, Pageable paging);//011000
    Page<ResguardoTemporal> findByFechaSalidaBetweenAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long categoriaId, Long tipoTransporteId, Pageable paging);//100001
    Page<ResguardoTemporal> findByFechaSalidaBetweenAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long vehiculoId, Long tipoTransporteId, Pageable paging);//100010
    Page<ResguardoTemporal> findByFechaSalidaBetweenAndEstatusTramite_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long estatusTramiteId, Long tipoTransporteId, Pageable paging);//100100
    Page<ResguardoTemporal> findByFechaSalidaBetweenAndMunicipio_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long municipioId, Long tipoTransporteId, Pageable paging);//101000
    Page<ResguardoTemporal> findByFechaSalidaBetweenAndArea_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long areaId, Long tipoTransporteId, Pageable paging);//110000

    //3 Filters
    Page<ResguardoTemporal> findByEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long estatusTramiteId, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//000111
    Page<ResguardoTemporal> findByMunicipio_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long municipioId, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//001011
    Page<ResguardoTemporal> findByMunicipio_idAndEstatusTramite_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long municipioId, Long estatusTramiteId, Long categoriaId, Long tipoTransporteId, Pageable paging);//001101
    Page<ResguardoTemporal> findByMunicipio_idAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(Long municipioId, Long estatusTramiteId, Long vehiculoId, Long tipoTransporteId, Pageable paging);//001110
    Page<ResguardoTemporal> findByArea_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long areaId, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//010011
    Page<ResguardoTemporal> findByArea_idAndEstatusTramite_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long areaId, Long estatusTramiteId, Long categoriaId, Long tipoTransporteId, Pageable paging);//010101
    Page<ResguardoTemporal> findByArea_idAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(Long areaId, Long estatusTramiteId, Long vehiculoId, Long tipoTransporteId, Pageable paging);//010110
    Page<ResguardoTemporal> findByArea_idAndMunicipio_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long areaId, Long municipioId, Long categoriaId, Long tipoTransporteId, Pageable paging);//011001
    Page<ResguardoTemporal> findByArea_idAndMunicipio_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(Long areaId, Long municipioId, Long vehiculoId, Long tipoTransporteId, Pageable paging);//011010
    Page<ResguardoTemporal> findByArea_idAndMunicipio_idAndEstatusTramite_idAndVehiculo_Categoria_TipoTransporte_id(Long areaId, Long municipioId, Long estatusTramiteId, Long tipoTransporteId, Pageable paging); //011100
    Page<ResguardoTemporal> findByFechaSalidaBetweenAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//100011
    Page<ResguardoTemporal> findByFechaSalidaBetweenAndEstatusTramite_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long estatusTramiteId, Long categoriaId, Long tipoTransporteId, Pageable paging);//100101
    Page<ResguardoTemporal> findByFechaSalidaBetweenAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long estatusTramiteId, Long vehiculoId, Long tipoTransporteId, Pageable paging);//100110
    Page<ResguardoTemporal> findByFechaSalidaBetweenAndMunicipio_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long municipioId, Long categoriaId, Long tipoTransporteId, Pageable paging);//101001
    Page<ResguardoTemporal> findByFechaSalidaBetweenAndMunicipio_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long municipioId, Long vehiculoId, Long tipoTransporteId, Pageable paging);//101010
    Page<ResguardoTemporal> findByFechaSalidaBetweenAndMunicipio_idAndEstatusTramite_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long municipioId, Long estatusTramiteId, Long tipoTransporteId, Pageable paging);//101100
    Page<ResguardoTemporal> findByFechaSalidaBetweenAndArea_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long areaId, Long categoriaId, Long tipoTransporteId, Pageable paging);//110001
    Page<ResguardoTemporal> findByFechaSalidaBetweenAndArea_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long areaId, Long vehiculoId, Long tipoTransporteId, Pageable paging);//110010
    Page<ResguardoTemporal> findByFechaSalidaBetweenAndArea_idAndEstatusTramite_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long areaId, Long estatusTramiteId, Long tipoTransporteId, Pageable paging);//110100
    Page<ResguardoTemporal> findByFechaSalidaBetweenAndArea_idAndMunicipio_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long areaId, Long municipioId, Long tipoTransporteId, Pageable paging);//111000

    //4 Filters
    Page<ResguardoTemporal> findByMunicipio_idAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long municipioId, Long estatusTramiteId, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//001111
    Page<ResguardoTemporal> findByArea_idAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long areaId, Long estatusTramiteId, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//010111
    Page<ResguardoTemporal> findByArea_idAndMunicipio_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long areaId, Long municipioId, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//011011
    Page<ResguardoTemporal> findByArea_idAndMunicipio_idAndEstatusTramite_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long areaId, Long municipioId, Long estatusTramiteId, Long categoriaId, Long tipoTransporteId, Pageable paging);//011101
    Page<ResguardoTemporal> findByArea_idAndMunicipio_idAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(Long areaId, Long municipioId, Long estatusTramiteId, Long vehiculoId, Long tipoTransporteId, Pageable paging);//011110
    Page<ResguardoTemporal> findByFechaSalidaBetweenAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long estatusTramiteId, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//100111
    Page<ResguardoTemporal> findByFechaSalidaBetweenAndMunicipio_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long municipioId, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//101011
    Page<ResguardoTemporal> findByFechaSalidaBetweenAndMunicipio_idAndEstatusTramite_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long municipioId, Long estatusTramiteId, Long categoriaId, Long tipoTransporteId, Pageable paging);//101101
    Page<ResguardoTemporal> findByFechaSalidaBetweenAndMunicipio_idAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long municipioId, Long estatusTramiteId, Long vehiculoId, Long tipoTransporteId, Pageable paging);//101110
    Page<ResguardoTemporal> findByFechaSalidaBetweenAndArea_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long areaId, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//110011
    Page<ResguardoTemporal> findByFechaSalidaBetweenAndArea_idAndEstatusTramite_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long areaId, Long estatusTramiteId, Long categoriaId, Long tipoTransporteId, Pageable paging);//110101
    Page<ResguardoTemporal> findByFechaSalidaBetweenAndArea_idAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long areaId, Long estatusTramiteId, Long vehiculoId, Long tipoTransporteId, Pageable paging);//110110
    Page<ResguardoTemporal> findByFechaSalidaBetweenAndArea_idAndMunicipio_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long areaId, Long municipioId, Long categoriaId, Long tipoTransporteId, Pageable paging);//111001
    Page<ResguardoTemporal> findByFechaSalidaBetweenAndArea_idAndMunicipio_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long areaId, Long municipioId, Long vehiculoId, Long tipoTransporteId, Pageable paging);//111010
    Page<ResguardoTemporal> findByFechaSalidaBetweenAndArea_idAndMunicipio_idAndEstatusTramite_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long areaId, Long municipioId, Long estatusTramiteId, Long tipoTransporteId, Pageable paging); //111100

    //5 Filters
    Page<ResguardoTemporal> findByArea_idAndMunicipio_idAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(Long areaId, Long municipioId, Long estatusTramiteId, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//011111
    Page<ResguardoTemporal> findByFechaSalidaBetweenAndMunicipio_idAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long municipioId, Long estatusTramiteId, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//101111
    Page<ResguardoTemporal> findByFechaSalidaBetweenAndArea_idAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long areaId, Long estatusTramiteId, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//110111
    Page<ResguardoTemporal> findByFechaSalidaBetweenAndArea_idAndMunicipio_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long areaId, Long municipioId, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//111011
    Page<ResguardoTemporal> findByFechaSalidaBetweenAndArea_idAndMunicipio_idAndEstatusTramite_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long areaId, Long municipioId, Long estatusTramiteId, Long categoriaId, Long tipoTransporteId, Pageable paging);//111101
    Page<ResguardoTemporal> findByFechaSalidaBetweenAndArea_idAndMunicipio_idAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long areaId, Long municipioId, Long estatusTramiteId, Long vehiculoId, Long tipoTransporteId, Pageable paging);//111110

    //6 Filters
    Page<ResguardoTemporal> findByFechaSalidaBetweenAndArea_idAndMunicipio_idAndEstatusTramite_idAndVehiculo_idAndVehiculo_Categoria_idAndVehiculo_Categoria_TipoTransporte_id(LocalDate fechaIni, LocalDate fechaFin, Long areaId, Long municipioId, Long estatusTramiteId, Long vehiculoId, Long categoriaId, Long tipoTransporteId, Pageable paging);//111111
}