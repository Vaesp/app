package com.example.app.Repositories;

import com.example.app.Models.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria,Long>, PagingAndSortingRepository<Categoria,Long> {
    Optional<Categoria> findById(Long id);
    Page<Categoria> findAll(Pageable pageable);
    List<Categoria> findByTipoTransporte_id(Long id);
}