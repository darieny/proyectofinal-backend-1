package com.proyectofinal.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyectofinal.backend.modelo.Pasajero;

@Repository
public interface PasajeroRepositorio extends JpaRepository<Pasajero, Integer> {
    
}
