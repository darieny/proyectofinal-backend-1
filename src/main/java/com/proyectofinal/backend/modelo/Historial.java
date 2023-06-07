package com.proyectofinal.backend.modelo;
import java.security.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "historial")
public class Historial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Evento;
    private Timestamp FechaHora;
    
    @ManyToOne
    @JoinColumn(name = "Fk_Id_Usuario")
    private Usuario Fk_Id_Usuario;

    // Constructor vacío
    public Historial() {
    }

    //Constructor Normal
    public Historial(Long id, String evento, Timestamp fechaHora, Usuario fk_Id_Usuario) {
        this.id = id;
        Evento = evento;
        FechaHora = fechaHora;
        Fk_Id_Usuario = fk_Id_Usuario;
    }

    //Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEvento() {
        return Evento;
    }

    public void setEvento(String evento) {
        Evento = evento;
    }

    public Timestamp getFechaHora() {
        return FechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        FechaHora = fechaHora;
    }

    public Usuario getFk_Id_Usuario() {
        return Fk_Id_Usuario;
    }

    public void setFk_Id_Usuario(Usuario fk_Id_Usuario) {
        Fk_Id_Usuario = fk_Id_Usuario;
    }
    
    
}
