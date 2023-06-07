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

import com.proyectofinal.backend.modelo.Reserva;
import com.proyectofinal.backend.repositorio.ReservaRepositorio;

@RestController
@RequestMapping("/Reserva")
@CrossOrigin(origins = "http://localhost:4200/") //permite intercambiar recursos entre frontend y backend
public class ReservaControlador {
    @Autowired
    private ReservaRepositorio repositorio;

    @GetMapping("/ListarReservas")
    public List<Reserva> ListarTodasLasReservas(){
        return repositorio.findAll();
    }
    //Metodo para guardar
    @PostMapping("/IngresarReserva")
	public Reserva ingresarReserva(@RequestBody Reserva reserva) {
		return repositorio.save(reserva);
	}

    //Metodo para actualizar
    @PutMapping("/ActualizarReserva/{id}")
    public Reserva actualizarReserva(@PathVariable int id, @RequestBody Reserva reservaActualizada) {

        Reserva reserva = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe la reserva con el id:" + id));

        reserva.setClaseVuelo(reservaActualizada.getClaseVuelo());
        reserva.setAsiento(reservaActualizada.getAsiento());
        reserva.setFk_Id_Pasajero(reservaActualizada.getFk_Id_Pasajero());
        reserva.setFk_Id_Vuelo(reservaActualizada.getFk_Id_Vuelo());

        Reserva reservaActual = repositorio.save(reserva);
        return reservaActual;
    }

    //Metodo para eliminar
    @DeleteMapping("/EliminarReserva/{id}")
    public String eliminarReserva(@PathVariable int id) {
        Reserva reserva = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe reserva con el id: " + id));
        repositorio.delete(reserva);
        return "Reserva eliminada con el id: " + id + " asiento: " + reserva.getAsiento();}
}
