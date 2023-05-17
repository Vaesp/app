package com.example.app.Repositories.Tramites;

import com.example.app.Models.Tramites.PeriodoVerificacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface PeriodoVerificacionRepository extends JpaRepository<PeriodoVerificacion,Long>, PagingAndSortingRepository<PeriodoVerificacion,Long> {
    Optional<PeriodoVerificacion> findById(Long id);
    Page<PeriodoVerificacion> findAll(Pageable pageable);
}