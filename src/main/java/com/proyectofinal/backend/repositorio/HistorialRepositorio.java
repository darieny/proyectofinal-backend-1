package com.proyectofinal.backend.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyectofinal.backend.modelo.Historial;

@Repository
public interface HistorialRepositorio extends JpaRepository<Historial, Integer> {
    
}
