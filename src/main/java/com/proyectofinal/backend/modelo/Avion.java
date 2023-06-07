package com.proyectofinal.backend.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "avion")
public class Avion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String NombreAvion;
    private String NombreModelo;
    private int Capacidad;

    // Constructor vacío
    public Avion() {
    }
    // Constructor normal
    public Avion(Long id, String nombreAvion, String nombreModelo, int capacidad) {
        this.id = id;
        NombreAvion = nombreAvion;
        NombreModelo = nombreModelo;
        Capacidad = capacidad;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombreAvion() {
        return NombreAvion;
    }
    public void setNombreAvion(String nombreAvion) {
        NombreAvion = nombreAvion;
    }
    public String getNombreModelo() {
        return NombreModelo;
    }
    public void setNombreModelo(String nombreModelo) {
        NombreModelo = nombreModelo;
    }
    public int getCapacidad() {
        return Capacidad;
    }
    public void setCapacidad(int capacidad) {
        Capacidad = capacidad;
    }

    
    
}
