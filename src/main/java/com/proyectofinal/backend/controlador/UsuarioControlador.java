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

import com.proyectofinal.backend.modelo.Usuario;
import com.proyectofinal.backend.repositorio.UsuarioRepositorio;

@RestController
@RequestMapping("/Usuario")
@CrossOrigin(origins = "http://localhost:4200/") //permite intercambiar recursos entre frontend y backend
public class UsuarioControlador {
    
    @Autowired
    private UsuarioRepositorio repositorio;

    @GetMapping("/ListarUsuarios")
    public List<Usuario> ListarTodosLosUsuarios(){
        return repositorio.findAll();
    }
    //Metodo para guardar
    @PostMapping("/IngresarUsuario")
	public Usuario ingresarUsuario(@RequestBody Usuario usuario) {
		return repositorio.save(usuario);
	}

    //Metodo para actualizar
    @PutMapping("/ActualizarUsuario/{id}")
    public Usuario actualizarUsuario(@PathVariable int id, @RequestBody Usuario usuarioActualizado) {

        Usuario usuario = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el usuario con el id:" + id));

        usuario.setNombreUsuario(usuarioActualizado.getNombreUsuario());
        usuario.setContraseña(usuarioActualizado.getContraseña());
        usuario.setFk_Id_Rol(usuarioActualizado.getFk_Id_Rol());
        usuario.setFk_Id_Empleado(usuarioActualizado.getFk_Id_Empleado());

        Usuario usuarioActual = repositorio.save(usuario);
        return usuarioActual;
    }

    //Metodo para eliminar
    @DeleteMapping("/EliminarUsuario/{id}")
    public String eliminarUsuario(@PathVariable int id) {
        Usuario usuario = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el usuario con el id: " + id));
        repositorio.delete(usuario);
        return "Usuario eliminado con el id: " + id + " nombre: " + usuario.getNombreUsuario();}
    }
