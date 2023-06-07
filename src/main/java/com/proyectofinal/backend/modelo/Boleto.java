package com.proyectofinal.backend.modelo;
import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "boleto")
public class Boleto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date FechaEmision;
    private Date FechaValidacion;
    private Float PrecioBoleto;
    private Time HoraPrechequeo;
    
    @ManyToOne
    @JoinColumn(name = "Fk_Id_Reserva")
    private Reserva Fk_Id_Reserva;

    // Constructor vacío
    public Boleto() {
    }
    //Constructor Normal
    public Boleto(Long id, Date fechaEmision, Date fechaValidacion, Float precioBoleto, Time horaPrechequeo,
            Reserva fk_Id_Reserva) {
        this.id = id;
        FechaEmision = fechaEmision;
        FechaValidacion = fechaValidacion;
        PrecioBoleto = precioBoleto;
        HoraPrechequeo = horaPrechequeo;
        Fk_Id_Reserva = fk_Id_Reserva;
    }
    //Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaEmision() {
        return FechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        FechaEmision = fechaEmision;
    }

    public Date getFechaValidacion() {
        return FechaValidacion;
    }

    public void setFechaValidacion(Date fechaValidacion) {
        FechaValidacion = fechaValidacion;
    }

    public Float getPrecioBoleto() {
        return PrecioBoleto;
    }

    public void setPrecioBoleto(Float precioBoleto) {
        PrecioBoleto = precioBoleto;
    }

    public Time getHoraPrechequeo() {
        return HoraPrechequeo;
    }

    public void setHoraPrechequeo(Time horaPrechequeo) {
        HoraPrechequeo = horaPrechequeo;
    }

    public Reserva getFk_Id_Reserva() {
        return Fk_Id_Reserva;
    }

    public void setFk_Id_Reserva(Reserva fk_Id_Reserva) {
        Fk_Id_Reserva = fk_Id_Reserva;
    }

    
}
