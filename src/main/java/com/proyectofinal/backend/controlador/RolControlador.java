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

import com.proyectofinal.backend.modelo.Rol;
import com.proyectofinal.backend.repositorio.RolRepositorio;

@RestController
@RequestMapping("/Rol")
@CrossOrigin(origins = "http://localhost:4200/") //permite intercambiar recursos entre frontend y backend
public class RolControlador {
    @Autowired
    private RolRepositorio repositorio;

    @GetMapping("/ListarRoles")
    public List<Rol> ListarTodosLosRoles(){
        return repositorio.findAll();
    }
    //Metodo para guardar
    @PostMapping("/IngresarRol")
	public Rol ingresarRol(@RequestBody Rol rol) {
		return repositorio.save(rol);
	}

    //Metodo para actualizar
    @PutMapping("/ActualizarRol/{id}")
    public Rol actualizarRol(@PathVariable int id, @RequestBody Rol rolActualizado) {

        Rol rol = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el rol con el id:" + id));

        rol.setNombreRol(rolActualizado.getNombreRol());

        Rol rolActual = repositorio.save(rol);
        return rolActual;
    }

    //Metodo para eliminar
    @DeleteMapping("/EliminarRol/{id}")
    public String eliminarRol(@PathVariable int id) {
        Rol rol = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el rol con el id: " + id));
        repositorio.delete(rol);
        return "Rol eliminado con el id: " + id + " nombre: " + rol.getNombreRol();}
}
