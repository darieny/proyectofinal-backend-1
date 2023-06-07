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

import com.proyectofinal.backend.modelo.Vuelo;
import com.proyectofinal.backend.repositorio.VueloRepositorio;

@RestController
@RequestMapping("/Vuelo")
@CrossOrigin(origins = "http://localhost:4200/") //permite intercambiar recursos entre frontend y backend
public class VueloControlador {
    @Autowired
    private VueloRepositorio repositorio;

    @GetMapping("/ListarVuelos")
    public List<Vuelo> ListarTodosLosVuelos(){
        return repositorio.findAll();
    }
    //Metodo para guardar
    @PostMapping("/IngresarVuelos")
	public Vuelo ingresarVuelo(@RequestBody Vuelo vuelo) {
		return repositorio.save(vuelo);
	}

    //Metodo para actualizar
    @PutMapping("/ActualizarVuelos/{id}")
    public Vuelo actualizarVuelo(@PathVariable int id, @RequestBody Vuelo vueloActualizado) {

        Vuelo vuelo = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el vuelo con el id:" + id));

        vuelo.setOrigenVuelo(vueloActualizado.getOrigenVuelo());
        vuelo.setFecha_Salida(vueloActualizado.getFecha_Salida());
        vuelo.setHoraSalida(vueloActualizado.getHoraSalida());
        vuelo.setDestinoVuelo(vueloActualizado.getDestinoVuelo());
        vuelo.setFecha_Llegada(vueloActualizado.getFecha_Llegada());
        vuelo.setHoraLlegada(vueloActualizado.getHoraLlegada());
        vuelo.setHoraRevision(vueloActualizado.getHoraRevision());
        vuelo.setNumero_Puerta(vueloActualizado.getNumero_Puerta());

        Vuelo vueloActual = repositorio.save(vuelo);
        return vueloActual;
    }

    //Metodo para eliminar
    @DeleteMapping("/EliminarVuelo/{id}")
    public String eliminarVuelo(@PathVariable int id) {
        Vuelo vuelo = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el vuelo con el id: " + id));
        repositorio.delete(vuelo);
        return "Vuelo eliminado con el id: " + id + " Vuelo Origen: " + vuelo.getOrigenVuelo();}
    
}
