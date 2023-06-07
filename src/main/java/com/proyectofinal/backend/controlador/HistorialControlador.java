package com.proyectofinal.backend.controlador;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectofinal.backend.modelo.Historial;
import com.proyectofinal.backend.repositorio.HistorialRepositorio;

@RestController
@RequestMapping("/Historial")
@CrossOrigin(origins = "http://localhost:4200/") //permite intercambiar recursos entre frontend y backend
public class HistorialControlador {
    @Autowired
    private HistorialRepositorio repositorio;

    @GetMapping("/ListarHistorial")
    public List<Historial> ListarTodoElHistorial(){
        return repositorio.findAll();
    }
    
}
