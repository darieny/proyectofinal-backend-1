package com.proyectofinal.backend.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ClaseVuelo;
    private String Asiento;
    
    @ManyToOne
    @JoinColumn(name = "Fk_Id_Pasajero")
    private Pasajero Fk_Id_Pasajero;

    @ManyToOne
    @JoinColumn(name = "Fk_Id_Vuelo")
    private Vuelo Fk_Id_Vuelo;

    // Constructor vacío
    public Reserva() {
    }
    //Constructor Normal
    public Reserva(Long id, String claseVuelo, String asiento, Pasajero fk_Id_Pasajero, Vuelo fk_Id_Vuelo) {
        this.id = id;
        ClaseVuelo = claseVuelo;
        Asiento = asiento;
        Fk_Id_Pasajero = fk_Id_Pasajero;
        Fk_Id_Vuelo = fk_Id_Vuelo;
    }
    //Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClaseVuelo() {
        return ClaseVuelo;
    }

    public void setClaseVuelo(String claseVuelo) {
        ClaseVuelo = claseVuelo;
    }

    public String getAsiento() {
        return Asiento;
    }

    public void setAsiento(String asiento) {
        Asiento = asiento;
    }

    public Pasajero getFk_Id_Pasajero() {
        return Fk_Id_Pasajero;
    }

    public void setFk_Id_Pasajero(Pasajero fk_Id_Pasajero) {
        Fk_Id_Pasajero = fk_Id_Pasajero;
    }

    public Vuelo getFk_Id_Vuelo() {
        return Fk_Id_Vuelo;
    }

    public void setFk_Id_Vuelo(Vuelo fk_Id_Vuelo) {
        Fk_Id_Vuelo = fk_Id_Vuelo;
    }

    
}
