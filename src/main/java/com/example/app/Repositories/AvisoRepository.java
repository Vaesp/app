package com.example.app.Repositories;

import com.example.app.Models.Aviso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface AvisoRepository extends JpaRepository<Aviso,Long>, PagingAndSortingRepository<Aviso,Long> {
    Optional<Aviso> findById(Long id);
    Page<Aviso> findAll(Pageable pageable);
}