package com.example.app.Repositories;

import com.example.app.Models.Municipio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface MunicipioRepository extends JpaRepository<Municipio,Long>, PagingAndSortingRepository<Municipio,Long> {
    List<Municipio> findByOrderByMunicipio();
    Optional<Municipio> findById(Long id);
    Page<Municipio> findAll(Pageable pageable);
}