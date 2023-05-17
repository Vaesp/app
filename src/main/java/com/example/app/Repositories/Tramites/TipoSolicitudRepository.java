package com.example.app.Repositories.Tramites;

import com.example.app.Models.Tramites.TipoSolicitud;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface TipoSolicitudRepository extends JpaRepository<TipoSolicitud,Long>, PagingAndSortingRepository<TipoSolicitud,Long> {
    Optional<TipoSolicitud> findById(Long id);
    Page<TipoSolicitud> findAll(Pageable pageable);
}