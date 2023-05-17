package com.example.app.Repositories;

import com.example.app.Models.Resguardante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface ResguardanteRepository extends JpaRepository<Resguardante, Long>, PagingAndSortingRepository<Resguardante, Long> {
    List<Resguardante> findByOrderByNombre();
    Optional<Resguardante> findById(Long id);
    Page<Resguardante> findAll(Pageable pageable);

    //1 Filter
    Page<Resguardante> findByNombreContaining(String nombre, Pageable paging);//01
    Page<Resguardante> findByNoLicenciaContaining(String noLicencia, Pageable paging);//10

    //2 Filters
    Page<Resguardante> findByNombreContainingAndNoLicenciaContaining(String nombre, String noLicencia, Pageable paging);//11
}