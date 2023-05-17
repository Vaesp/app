package com.example.app.Repositories;

import com.example.app.Models.EstatusCarroceria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface EstatusCarroceriaRepository extends JpaRepository<EstatusCarroceria,Long>, PagingAndSortingRepository<EstatusCarroceria,Long> {
    Optional<EstatusCarroceria> findById(Long id);
    Page<EstatusCarroceria> findAll(Pageable pageable);
}