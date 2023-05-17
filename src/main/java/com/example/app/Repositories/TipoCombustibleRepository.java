package com.example.app.Repositories;

import com.example.app.Models.TipoCombustible;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface TipoCombustibleRepository extends JpaRepository<TipoCombustible,Long>, PagingAndSortingRepository<TipoCombustible,Long> {
    Optional<TipoCombustible> findById(Long id);
    Page<TipoCombustible> findAll(Pageable pageable);
}