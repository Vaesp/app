package com.example.app.Repositories;

import com.example.app.Models.Area;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface AreaRepository extends JpaRepository<Area,Long>, PagingAndSortingRepository<Area,Long> {
    List<Area> findByOrderByNombreArea();
    Optional<Area> findById(Long id);
    Page<Area> findAll(Pageable pageable);

    //1 Filter
    Page<Area> findByNombreAreaContaining(String nombreArea, Pageable paging);//01
    Page<Area> findByNombreJefeContaining(String nombreJefe, Pageable paging);//10

    //2 Filters
    Page<Area> findByNombreAreaContainingAndNombreJefeContaining(String nombreArea, String nombreJefe, Pageable paging);//11
}