package com.example.app.Security.RepositoryJWT;

import java.util.Optional;

import com.example.app.Security.ModelsJWT.ERole;
import com.example.app.Security.ModelsJWT.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
    Page<Role> findAll(Pageable pageable);
}