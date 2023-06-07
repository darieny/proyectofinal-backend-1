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


import com.proyectofinal.backend.modelo.Cliente;
import com.proyectofinal.backend.repositorio.ClienteRepositorio;

@RestController
@RequestMapping("/Cliente")
@CrossOrigin(origins = "http://localhost:4200/") //permite intercambiar recursos entre frontend y backend
public class ClienteControlador {
    @Autowired
    private ClienteRepositorio repositorio;

    @GetMapping("/ListarClientes")
    public List<Cliente> ListarTodosLosClientes(){
        return repositorio.findAll();
    }
    
    //Metodo para ingresar
    @PostMapping("/IngresarClientes")
	public Cliente ingresarCliente(@RequestBody Cliente cliente) {
		return repositorio.save(cliente);
	}

    //Metodo para actualizar
    @PutMapping("/ActualizarCliente/{id}")
    public Cliente actualizarCliente(@PathVariable int id, @RequestBody Cliente clienteActualizado) {

        Cliente cliente = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el cliente con el id:" + id));

        cliente.setNombreCliente(clienteActualizado.getNombreCliente());
        cliente.setFecha_NacimientoCli(clienteActualizado.getFecha_NacimientoCli());
        cliente.setTelefonoCliente(clienteActualizado.getTelefonoCliente());
        cliente.setDireccionCliente(clienteActualizado.getDireccionCliente());
        cliente.setGeneroCliente(clienteActualizado.getGeneroCliente());
        cliente.setNacionalidadCli(clienteActualizado.getNacionalidadCli());
        cliente.setNIT(clienteActualizado.getNIT());

        Cliente clienteActual = repositorio.save(cliente);
        return clienteActual;
    }

    //Metodo para eliminar
    @DeleteMapping("/EliminarCliente/{id}")
    public String eliminarCliente(@PathVariable int id) {
        Cliente cliente = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el cliente con el id: " + id));
        repositorio.delete(cliente);
        return "Cliente eliminado con el id: " + id + " nombre: " + cliente.getNombreCliente();}

}
