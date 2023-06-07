package com.proyectofinal.backend.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyectofinal.backend.modelo.Boleto;

@Repository
public interface BoletoRepositorio extends JpaRepository<Boleto, Integer> {
    
}
