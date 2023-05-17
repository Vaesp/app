package com.example.app.Repositories.Tramites;

import com.example.app.Models.Tramites.EstatusTramite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface EstatusTramiteRepository extends JpaRepository<EstatusTramite,Long>, PagingAndSortingRepository<EstatusTramite,Long> {
    Optional<EstatusTramite> findById(Long id);
    Page<EstatusTramite> findAll(Pageable pageable);
}