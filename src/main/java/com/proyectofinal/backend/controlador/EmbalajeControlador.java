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

import com.proyectofinal.backend.modelo.Embalaje;
import com.proyectofinal.backend.repositorio.EmbalajeRepositorio;

@RestController
@RequestMapping("/Embalaje")
@CrossOrigin(origins = "http://localhost:4200/") //permite intercambiar recursos entre frontend y backend
public class EmbalajeControlador {
    @Autowired
    private EmbalajeRepositorio repositorio;

    @GetMapping ("/ListarEmbalaje")
    public List<Embalaje> ListarTodosLosEmbalajes(){
        return repositorio.findAll();
    }
    //Metodo para guardar
    @PostMapping("/IngresarEmbalaje")
	public Embalaje ingresarAvion(@RequestBody Embalaje embalaje) {
		return repositorio.save(embalaje);
	}

    //Metodo para actualizar
    @PutMapping("/ActualizarEmbalaje/{id}")
    public Embalaje actualizarEmbalaje(@PathVariable int id, @RequestBody Embalaje embalajeActualizado) {

        Embalaje embalaje = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el embalaje con el id:" + id));

        embalaje.setCantidadMaletas(embalajeActualizado.getCantidadMaletas());
        embalaje.setPesoMaletas(embalajeActualizado.getPesoMaletas());
        embalaje.setPrecioMaletas(embalajeActualizado.getPrecioMaletas());

        Embalaje embalajeActual = repositorio.save(embalaje);
        return embalajeActual;
    }

    //Metodo para eliminar
    @DeleteMapping("/EliminarEmbalaje/{id}")
    public String eliminarEmbalaje(@PathVariable int id) {
        Embalaje embalaje = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el embalaje con el id: " + id));
        repositorio.delete(embalaje);
        return "Embalaje eliminado con el id: " + id + " cantidad: " + embalaje.getCantidadMaletas();}
}
