package com.example.app.Repositories.Tramites;

import com.example.app.Models.Tramites.TipoMantenimiento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface TipoMantenimientoRepository extends JpaRepository<TipoMantenimiento,Long>, PagingAndSortingRepository<TipoMantenimiento,Long> {
    Optional<TipoMantenimiento> findById(Long id);
    Page<TipoMantenimiento> findAll(Pageable pageable);
}