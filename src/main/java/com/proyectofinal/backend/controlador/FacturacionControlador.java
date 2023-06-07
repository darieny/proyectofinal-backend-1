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

import com.proyectofinal.backend.modelo.Facturacion;
import com.proyectofinal.backend.repositorio.FacturacionRepositorio;

@RestController
@RequestMapping("/Facturacion")
@CrossOrigin(origins = "http://localhost:4200/") //permite intercambiar recursos entre frontend y backend
public class FacturacionControlador {
    @Autowired
    private FacturacionRepositorio repositorio;

    @GetMapping("/ListarFacturacion")
    public List<Facturacion> ListarTodasLasFacturas(){
        return repositorio.findAll();
    }
    //Metodo para guardar
    @PostMapping("/IngresarFactura")
	public Facturacion ingresarFactura(@RequestBody Facturacion facturacion) {
		return repositorio.save(facturacion);
	}

    //Metodo para actualizar
    @PutMapping("/ActualizarFactura/{id}")
    public Facturacion actualizarFactura(@PathVariable int id, @RequestBody Facturacion facturacionActualizado) {

		Facturacion facturacion = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe la factura con el id:" + id));

        facturacion.setCantidadPasajeros(facturacionActualizado.getCantidadPasajeros());
        facturacion.setFechaEmision(facturacionActualizado.getFechaEmision());
        facturacion.setMontoTotal(facturacionActualizado.getMontoTotal());
        facturacion.setFk_Id_Boleto(facturacionActualizado.getFk_Id_Boleto());
        facturacion.setFk_Id_Cliente(facturacionActualizado.getFk_Id_Cliente());
        facturacion.setFk_Id_Embalaje(facturacionActualizado.getFk_Id_Embalaje());

        Facturacion facturacionActual = repositorio.save(facturacion);
		        return facturacionActual;
			}

    //Metodo para eliminar
    @DeleteMapping("/EliminarFactura/{id}")
    public String eliminarFactura(@PathVariable int id) {
        Facturacion facturacion = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe una factura con el id: " + id));
        repositorio.delete(facturacion);
        return "Factura eliminada con el id: " + id + " Monto: " + facturacion.getMontoTotal();}
}
