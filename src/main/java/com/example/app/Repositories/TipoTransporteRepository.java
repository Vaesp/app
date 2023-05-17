package com.example.app.Repositories;

import com.example.app.Models.TipoTransporte;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface TipoTransporteRepository extends JpaRepository<TipoTransporte,Long>, PagingAndSortingRepository<TipoTransporte,Long> {
    Optional<TipoTransporte> findById(Long id);
    Page<TipoTransporte> findAll(Pageable pageable);
}