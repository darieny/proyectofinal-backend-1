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

import com.proyectofinal.backend.modelo.Boleto;
import com.proyectofinal.backend.repositorio.BoletoRepositorio;

@RestController
@RequestMapping("/Boleto")
@CrossOrigin(origins = "http://localhost:4200/") //permite intercambiar recursos entre frontend y backend
public class BoletoControlador {
    @Autowired
    private BoletoRepositorio repositorio;

    @GetMapping("/ListarBoletos")
    public List<Boleto> ListarTodosLosBoletos(){
        return repositorio.findAll();
    }
    //Metodo para ingresar
    @PostMapping("/IngresarBoleto")
	public Boleto ingresarBoleto(@RequestBody Boleto Boleto) {
		return repositorio.save(Boleto);}

    //Metodo para actualizar
    @PutMapping("/ActualizarBoleto/{id}")
    public Boleto actualizarBoleto(@PathVariable int id, @RequestBody Boleto boletoActualizado) {

        Boleto boleto = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el boleto con el id:" + id));

        boleto.setFechaEmision(boletoActualizado.getFechaEmision());
        boleto.setFechaValidacion(boletoActualizado.getFechaEmision());
        boleto.setHoraPrechequeo(boletoActualizado.getHoraPrechequeo());
        boleto.setPrecioBoleto(boletoActualizado.getPrecioBoleto());

        Boleto boletoActual = repositorio.save(boleto);
        return boletoActual;
    }

    //Metodo para eliminar
    @DeleteMapping("/EliminarBoleto/{id}")
    public String eliminarBoleto(@PathVariable int id) {
        Boleto boleto = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No ex3iste el boleto con el id: " + id));
        repositorio.delete(boleto);
        return "Boleto eliminado con el id: " + id + " precio: " + boleto.getPrecioBoleto();}
}
