package com.example.app.Files;

import com.example.app.Models.Resguardante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FIleResguardanteRepository extends JpaRepository<FileResguardante, String> {
    List<FileResguardante> findById(Resguardante resguardante);
}
