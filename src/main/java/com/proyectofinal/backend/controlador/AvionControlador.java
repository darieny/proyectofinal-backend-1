package com.proyectofinal.backend.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectofinal.backend.modelo.Avion;
import com.proyectofinal.backend.repositorio.AvionRepositorio;

@RestController
@RequestMapping("/Avion")
@CrossOrigin(origins = "http://localhost:4200/") //permite intercambiar recursos entre frontend y backend
public class AvionControlador {
    @Autowired
    private AvionRepositorio repositorio;

    @GetMapping("/ListarAviones")
    public List<Avion> ListarTodosLosAviones(){
        return repositorio.findAll();
    }
    //Metodo para guardar
    @PostMapping("/IngresarAviones")
	public Avion ingresarAvion(@RequestBody Avion Avion) {
		return repositorio.save(Avion);
	}

    //Metodo para actualizar
    @PutMapping("/ActualizarAvion/{id}")
    public Avion actualizarAvion(@PathVariable int id, @RequestBody Avion avionActualizado) {

        Avion avion = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el avion con el id:" + id));

        avion.setNombreAvion(avionActualizado.getNombreAvion());
        avion.setNombreModelo(avionActualizado.getNombreModelo());
        avion.setCapacidad(avionActualizado.getCapacidad());

        Avion avionActual = repositorio.save(avion);
        return avionActual;
    }

    //Metodo para eliminar
    @DeleteMapping("/EliminarAvion/{id}")
    public String eliminarAvion(@PathVariable int id) {
        Avion avion = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el avion con el id: " + id));
        repositorio.delete(avion);
        return "Avion eliminado con el id: " + id + " nombre: " + avion.getNombreAvion();}

}
