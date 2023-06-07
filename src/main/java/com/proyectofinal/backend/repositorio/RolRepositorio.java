package com.proyectofinal.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyectofinal.backend.modelo.Rol;

@Repository
public interface RolRepositorio extends JpaRepository<Rol, Integer> {
    
}
