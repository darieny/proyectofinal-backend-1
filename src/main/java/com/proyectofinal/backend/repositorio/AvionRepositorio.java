package com.proyectofinal.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyectofinal.backend.modelo.Avion;

@Repository
public interface AvionRepositorio extends JpaRepository<Avion, Integer> {
    
}
