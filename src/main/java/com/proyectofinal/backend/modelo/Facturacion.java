package com.proyectofinal.backend.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "facturacion")
public class Facturacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int CantidadPasajeros;
    private Date FechaEmision;
    private float MontoTotal;
    
    @ManyToOne
    @JoinColumn(name = "Fk_Id_Boleto")
    private Boleto Fk_Id_Boleto;

    @ManyToOne
    @JoinColumn(name = "Fk_Id_Cliente")
    private Cliente Fk_Id_Cliente;

    @ManyToOne
    @JoinColumn(name = "Fk_Id_Embalaje")
    private Embalaje Fk_Id_Embalaje;

    // Constructor vacío
    public Facturacion() {
    }
    //Constructor Normal
    public Facturacion(Long id, int cantidadPasajeros, Date fechaEmision, float montoTotal, Boleto fk_Id_Boleto,
            Cliente fk_Id_Cliente, Embalaje fk_Id_Embalaje) {
        this.id = id;
        CantidadPasajeros = cantidadPasajeros;
        FechaEmision = fechaEmision;
        MontoTotal = montoTotal;
        Fk_Id_Boleto = fk_Id_Boleto;
        Fk_Id_Cliente = fk_Id_Cliente;
        Fk_Id_Embalaje = fk_Id_Embalaje;
    }

    //Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCantidadPasajeros() {
        return CantidadPasajeros;
    }

    public void setCantidadPasajeros(int cantidadPasajeros) {
        CantidadPasajeros = cantidadPasajeros;
    }

    public Date getFechaEmision() {
        return FechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        FechaEmision = fechaEmision;
    }

    public float getMontoTotal() {
        return MontoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        MontoTotal = montoTotal;
    }

    public Boleto getFk_Id_Boleto() {
        return Fk_Id_Boleto;
    }

    public void setFk_Id_Boleto(Boleto fk_Id_Boleto) {
        Fk_Id_Boleto = fk_Id_Boleto;
    }

    public Cliente getFk_Id_Cliente() {
        return Fk_Id_Cliente;
    }

    public void setFk_Id_Cliente(Cliente fk_Id_Cliente) {
        Fk_Id_Cliente = fk_Id_Cliente;
    }

    public Embalaje getFk_Id_Embalaje() {
        return Fk_Id_Embalaje;
    }

    public void setFk_Id_Embalaje(Embalaje fk_Id_Embalaje) {
        Fk_Id_Embalaje = fk_Id_Embalaje;
    }

    
}
