package com.example.app.Files;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface TipoFileVehiculoRepository extends JpaRepository<TipoFileVehiculo,Long>, PagingAndSortingRepository<TipoFileVehiculo,Long> {
    Optional<TipoFileVehiculo> findById(Long id);
    Page<TipoFileVehiculo> findAll(Pageable pageable);
}
