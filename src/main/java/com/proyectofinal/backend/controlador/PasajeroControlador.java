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

import com.proyectofinal.backend.modelo.Pasajero;
import com.proyectofinal.backend.repositorio.PasajeroRepositorio;

@RestController
@RequestMapping("/Pasajero")
@CrossOrigin(origins = "http://localhost:4200/") //permite intercambiar recursos entre frontend y backend
public class PasajeroControlador {
    @Autowired
    private PasajeroRepositorio repositorio;

    @GetMapping("/ListarPasajeros")
    public List<Pasajero> ListarTodosLosPasajeros(){
        return repositorio.findAll();
    }
    //Metodo para guardar
    @PostMapping("/IngresarPasajero")
	public Pasajero ingresarAvion(@RequestBody Pasajero pasajero) {
		return repositorio.save(pasajero);
	}

    //Metodo para actualizar
    @PutMapping("/ActualizarPasajero/{id}")
    public Pasajero actualizarPasajero(@PathVariable int id, @RequestBody Pasajero pasajeroActualizado) {

        Pasajero pasajero = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el pasajero con el id:" + id));

        pasajero.setNombrePasajero(pasajeroActualizado.getNombrePasajero());
        pasajero.setFecha_NacimientoPas(pasajeroActualizado.getFecha_NacimientoPas());
        pasajero.setTelefonoPasajero(pasajeroActualizado.getTelefonoPasajero());
        pasajero.setDireccionPasajero(pasajeroActualizado.getDireccionPasajero());
        pasajero.setGeneroPasajero(pasajeroActualizado.getGeneroPasajero());
        pasajero.setNacionalidadPas(pasajeroActualizado.getNacionalidadPas());

        Pasajero pasajeroActual = repositorio.save(pasajero);
        return pasajeroActual;
    }

    //Metodo para eliminar
    @DeleteMapping("/EliminarPasajero/{id}")
    public String eliminarPasajero(@PathVariable int id) {
        Pasajero pasajero = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el pasajero con el id: " + id));
        repositorio.delete(pasajero);
        return "Pasajero eliminado con el id: " + id + " nombre: " + pasajero.getNombrePasajero();}
    
}
