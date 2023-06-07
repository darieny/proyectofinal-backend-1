package com.proyectofinal.backend.modelo;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente") //definimos el nombre de la tabla
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //declaración de los campos de la tabla con sus tipos de datos

    private String NombreCliente;
    private Date Fecha_NacimientoCli;
    private String TelefonoCliente; 
    private String DireccionCliente; 
    private String GeneroCliente; 
    private String NacionalidadCli;
    private String NIT;

    // Constructor vacío
    public Cliente() {
    }
    //Constructor Normal
    public Cliente(Long id, String nombreCliente, Date fecha_NacimientoCli, String telefonoCliente,
            String direccionCliente, String generoCliente, String nacionalidadCli, String nIT) {
        this.id = id;
        NombreCliente = nombreCliente;
        Fecha_NacimientoCli = fecha_NacimientoCli;
        TelefonoCliente = telefonoCliente;
        DireccionCliente = direccionCliente;
        GeneroCliente = generoCliente;
        NacionalidadCli = nacionalidadCli;
        NIT = nIT;
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombreCliente() {
        return NombreCliente;
    }
    public void setNombreCliente(String nombreCliente) {
        NombreCliente = nombreCliente;
    }
    public Date getFecha_NacimientoCli() {
        return Fecha_NacimientoCli;
    }
    public void setFecha_NacimientoCli(Date fecha_NacimientoCli) {
        Fecha_NacimientoCli = fecha_NacimientoCli;
    }
    public String getTelefonoCliente() {
        return TelefonoCliente;
    }
    public void setTelefonoCliente(String telefonoCliente) {
        TelefonoCliente = telefonoCliente;
    }
    public String getDireccionCliente() {
        return DireccionCliente;
    }
    public void setDireccionCliente(String direccionCliente) {
        DireccionCliente = direccionCliente;
    }
    public String getGeneroCliente() {
        return GeneroCliente;
    }
    public void setGeneroCliente(String generoCliente) {
        GeneroCliente = generoCliente;
    }
    public String getNacionalidadCli() {
        return NacionalidadCli;
    }
    public void setNacionalidadCli(String nacionalidadCli) {
        NacionalidadCli = nacionalidadCli;
    }
    public String getNIT() {
        return NIT;
    }
    public void setNIT(String nIT) {
        NIT = nIT;
    }

    
}
