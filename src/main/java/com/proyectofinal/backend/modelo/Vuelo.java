package com.proyectofinal.backend.modelo;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vuelo")
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String OrigenVuelo;
    private Date Fecha_Salida;
    private String HoraSalida;
    private String DestinoVuelo;
    private Date Fecha_Llegada;
    private String HoraLlegada;
    private String HoraRevision;
    private String Numero_Puerta;

    // Constructor vacío
    public Vuelo() {
    }

    //Constructor normal
    public Vuelo(Long id, String origenVuelo, Date fecha_Salida, String horaSalida, String destinoVuelo,
            Date fecha_Llegada, String horaLlegada, String horaRevision, String numero_Puerta) {
        this.id = id;
        OrigenVuelo = origenVuelo;
        Fecha_Salida = fecha_Salida;
        HoraSalida = horaSalida;
        DestinoVuelo = destinoVuelo;
        Fecha_Llegada = fecha_Llegada;
        HoraLlegada = horaLlegada;
        HoraRevision = horaRevision;
        Numero_Puerta = numero_Puerta;
    }
    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigenVuelo() {
        return OrigenVuelo;
    }

    public void setOrigenVuelo(String origenVuelo) {
        OrigenVuelo = origenVuelo;
    }

    public Date getFecha_Salida() {
        return Fecha_Salida;
    }

    public void setFecha_Salida(Date fecha_Salida) {
        Fecha_Salida = fecha_Salida;
    }

    public String getHoraSalida() {
        return HoraSalida;
    }

    public void setHoraSalida(String horaSalida) {
        HoraSalida = horaSalida;
    }

    public String getDestinoVuelo() {
        return DestinoVuelo;
    }

    public void setDestinoVuelo(String destinoVuelo) {
        DestinoVuelo = destinoVuelo;
    }

    public Date getFecha_Llegada() {
        return Fecha_Llegada;
    }

    public void setFecha_Llegada(Date fecha_Llegada) {
        Fecha_Llegada = fecha_Llegada;
    }

    public String getHoraLlegada() {
        return HoraLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        HoraLlegada = horaLlegada;
    }

    public String getHoraRevision() {
        return HoraRevision;
    }

    public void setHoraRevision(String horaRevision) {
        HoraRevision = horaRevision;
    }

    public String getNumero_Puerta() {
        return Numero_Puerta;
    }

    public void setNumero_Puerta(String numero_Puerta) {
        Numero_Puerta = numero_Puerta;
    }
    
}
