package com.proyectofinal.backend.modelo;


import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pasajero")
public class Pasajero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String NombrePasajero;
    private Date Fecha_NacimientoPas;
    private String TelefonoPasajero; 
    private String DireccionPasajero; 
    private String GeneroPasajero; 
    private String NacionalidadPas;

    // Constructor vacío
    public Pasajero() {
    }
    
    //Constructor normal
    public Pasajero(Long id, String nombrePasajero, Date fecha_NacimientoPas, String telefonoPasajero,
            String direccionPasajero, String generoPasajero, String nacionalidadPas) {
        this.id = id;
        NombrePasajero = nombrePasajero;
        Fecha_NacimientoPas = fecha_NacimientoPas;
        TelefonoPasajero = telefonoPasajero;
        DireccionPasajero = direccionPasajero;
        GeneroPasajero = generoPasajero;
        NacionalidadPas = nacionalidadPas;
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrePasajero() {
        return NombrePasajero;
    }

    public void setNombrePasajero(String nombrePasajero) {
        NombrePasajero = nombrePasajero;
    }

    public Date getFecha_NacimientoPas() {
        return Fecha_NacimientoPas;
    }

    public void setFecha_NacimientoPas(Date fecha_NacimientoPas) {
        Fecha_NacimientoPas = fecha_NacimientoPas;
    }

    public String getTelefonoPasajero() {
        return TelefonoPasajero;
    }

    public void setTelefonoPasajero(String telefonoPasajero) {
        TelefonoPasajero = telefonoPasajero;
    }

    public String getDireccionPasajero() {
        return DireccionPasajero;
    }

    public void setDireccionPasajero(String direccionPasajero) {
        DireccionPasajero = direccionPasajero;
    }

    public String getGeneroPasajero() {
        return GeneroPasajero;
    }

    public void setGeneroPasajero(String generoPasajero) {
        GeneroPasajero = generoPasajero;
    }

    public String getNacionalidadPas() {
        return NacionalidadPas;
    }

    public void setNacionalidadPas(String nacionalidadPas) {
        NacionalidadPas = nacionalidadPas;
    }
    
    
}
