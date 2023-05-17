package com.example.app.Repositories;

import com.example.app.Models.Contador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ContadorRepository extends JpaRepository<Contador,Long>, PagingAndSortingRepository<Contador,Long> {
    Optional<Contador> findById(Long id);
    Page<Contador> findAll(Pageable pageable);
}