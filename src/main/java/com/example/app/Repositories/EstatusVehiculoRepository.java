package com.example.app.Repositories;

import com.example.app.Models.EstatusVehiculo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface EstatusVehiculoRepository extends JpaRepository<EstatusVehiculo,Long>, PagingAndSortingRepository<EstatusVehiculo,Long> {
    Optional<EstatusVehiculo> findById(Long id);
    Page<EstatusVehiculo> findAll(Pageable pageable);
}