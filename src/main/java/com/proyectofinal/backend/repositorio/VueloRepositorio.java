package com.proyectofinal.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyectofinal.backend.modelo.Vuelo;

@Repository
public interface VueloRepositorio extends JpaRepository<Vuelo, Integer> {
    
}
