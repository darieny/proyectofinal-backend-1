package com.proyectofinal.backend.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String NombreEmpleado;
    private String TelefonoEmpleado;
	private String DireccionEmpleado;
	private String GeneroEmpleado;
	private String NacionalidadEmpleado;
	private String CargoEmpleado;

	public Empleado() {

	}

	
	public Empleado(Long id, String nombreEmpleado, String telefonoEmpleado, String direccionEmpleado,
			String generoEmpleado, String nacionalidadEmpleado, String cargoEmpleado) {
		this.id = id;
		NombreEmpleado = nombreEmpleado;
		TelefonoEmpleado = telefonoEmpleado;
		DireccionEmpleado = direccionEmpleado;
		GeneroEmpleado = generoEmpleado;
		NacionalidadEmpleado = nacionalidadEmpleado;
		CargoEmpleado = cargoEmpleado;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombreEmpleado() {
		return NombreEmpleado;
	}


	public void setNombreEmpleado(String nombreEmpleado) {
		NombreEmpleado = nombreEmpleado;
	}


	public String getTelefonoEmpleado() {
		return TelefonoEmpleado;
	}


	public void setTelefonoEmpleado(String telefonoEmpleado) {
		TelefonoEmpleado = telefonoEmpleado;
	}


	public String getDireccionEmpleado() {
		return DireccionEmpleado;
	}


	public void setDireccionEmpleado(String direccionEmpleado) {
		DireccionEmpleado = direccionEmpleado;
	}


	public String getGeneroEmpleado() {
		return GeneroEmpleado;
	}


	public void setGeneroEmpleado(String generoEmpleado) {
		GeneroEmpleado = generoEmpleado;
	}


	public String getNacionalidadEmpleado() {
		return NacionalidadEmpleado;
	}


	public void setNacionalidadEmpleado(String nacionalidadEmpleado) {
		NacionalidadEmpleado = nacionalidadEmpleado;
	}


	public String getCargoEmpleado() {
		return CargoEmpleado;
	}


	public void setCargoEmpleado(String cargoEmpleado) {
		CargoEmpleado = cargoEmpleado;
	}



}
