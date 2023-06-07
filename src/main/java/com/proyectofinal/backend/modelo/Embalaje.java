package com.proyectofinal.backend.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "embalaje")
public class Embalaje {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int CantidadMaletas;
    private Float PesoMaletas;
    private Float PrecioMaletas;

    // Constructor vacío
    public Embalaje() {
    }

    //Constructor Normal
    public Embalaje(Long id, int cantidadMaletas, Float pesoMaletas, Float precioMaletas) {
        this.id = id;
        CantidadMaletas = cantidadMaletas;
        PesoMaletas = pesoMaletas;
        PrecioMaletas = precioMaletas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCantidadMaletas() {
        return CantidadMaletas;
    }

    public void setCantidadMaletas(int cantidadMaletas) {
        CantidadMaletas = cantidadMaletas;
    }

    public Float getPesoMaletas() {
        return PesoMaletas;
    }

    public void setPesoMaletas(Float pesoMaletas) {
        PesoMaletas = pesoMaletas;
    }

    public Float getPrecioMaletas() {
        return PrecioMaletas;
    }

    public void setPrecioMaletas(Float precioMaletas) {
        PrecioMaletas = precioMaletas;
    }

    
    
}
