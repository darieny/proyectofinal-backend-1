package com.proyectofinal.backend.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyectofinal.backend.modelo.Reserva;

@Repository
public interface ReservaRepositorio extends JpaRepository<Reserva, Integer> {
    
}
