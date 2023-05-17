package com.example.app.Repositories;

import com.example.app.Models.UnidadTanque;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UnidadTanqueRepository extends JpaRepository<UnidadTanque,Long>, PagingAndSortingRepository<UnidadTanque,Long> {
    Optional<UnidadTanque> findById(Long id);
    Page<UnidadTanque> findAll(Pageable pageable);
}