package com.proyectofinal.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyectofinal.backend.modelo.Embalaje;

@Repository
public interface EmbalajeRepositorio extends JpaRepository<Embalaje, Integer> {
    
}
