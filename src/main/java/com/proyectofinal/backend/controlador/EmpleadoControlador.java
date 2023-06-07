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

import com.proyectofinal.backend.modelo.Empleado;
import com.proyectofinal.backend.repositorio.EmpleadoRepositorio;

@RestController
@RequestMapping("/Empleado")
@CrossOrigin(origins = "http://localhost:4200/") //permite intercambiar recursos entre frontend y backend
public class EmpleadoControlador {

	
	@Autowired
	private EmpleadoRepositorio repositorio;
	
	@GetMapping("/ListarEmpleados")
	public List<Empleado> listarTodosLosEmpleados(){
		return repositorio.findAll();
		
	}
	//Metodo para guardar
    @PostMapping("/IngresarEmpleados")
	public Empleado ingresarAvion(@RequestBody Empleado empleado) {
		return repositorio.save(empleado);
	}

    //Metodo para actualizar
    @PutMapping("/ActualizarEmpleados/{id}")
    public Empleado actualizarEmpleado(@PathVariable int id, @RequestBody Empleado empleadoActualizado) {

		Empleado empleado = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el empleado con el id:" + id));

        empleado.setNombreEmpleado(empleadoActualizado.getNombreEmpleado());
        empleado.setTelefonoEmpleado(empleadoActualizado.getTelefonoEmpleado());
        empleado.setDireccionEmpleado(empleadoActualizado.getDireccionEmpleado());
		empleado.setGeneroEmpleado(empleadoActualizado.getGeneroEmpleado());
		empleado.setNacionalidadEmpleado(empleadoActualizado.getNacionalidadEmpleado());
		empleado.setCargoEmpleado(empleadoActualizado.getCargoEmpleado());

        Empleado empleadoActual = repositorio.save(empleado);
		        return empleadoActual;
			}

    //Metodo para eliminar
    @DeleteMapping("/EliminarEmpleados/{id}")
    public String eliminarAvion(@PathVariable int id) {
        Empleado empleado = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el empleado con el id: " + id));
        repositorio.delete(empleado);
        return "Empleado eliminado con el id: " + id + " nombre: " + empleado.getNombreEmpleado();}
}
