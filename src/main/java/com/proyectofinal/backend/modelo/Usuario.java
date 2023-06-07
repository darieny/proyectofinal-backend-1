package com.proyectofinal.backend.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String NombreUsuario;
    private String Contraseña;
    
    @ManyToOne
    @JoinColumn(name = "Fk_Id_Rol")
    private Rol Fk_Id_Rol;

    @ManyToOne
    @JoinColumn(name = "Fk_Id_Empleado")
    private Empleado Fk_Id_Empleado;

    // Constructor vacío
    public Usuario() {
    }

    public Usuario(Long id, String nombreUsuario, String contraseña, Rol fk_Id_Rol, Empleado fk_Id_Empleado) {
        this.id = id;
        NombreUsuario = nombreUsuario;
        Contraseña = contraseña;
        Fk_Id_Rol = fk_Id_Rol;
        Fk_Id_Empleado = fk_Id_Empleado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        NombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    public Rol getFk_Id_Rol() {
        return Fk_Id_Rol;
    }

    public void setFk_Id_Rol(Rol fk_Id_Rol) {
        Fk_Id_Rol = fk_Id_Rol;
    }

    public Empleado getFk_Id_Empleado() {
        return Fk_Id_Empleado;
    }

    public void setFk_Id_Empleado(Empleado fk_Id_Empleado) {
        Fk_Id_Empleado = fk_Id_Empleado;
    }

    
    
}
