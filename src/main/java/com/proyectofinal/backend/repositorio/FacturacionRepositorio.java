package com.proyectofinal.backend.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyectofinal.backend.modelo.Facturacion;

@Repository
public interface FacturacionRepositorio extends JpaRepository<Facturacion, Integer> {
    
}
