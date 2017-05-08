package model;

import java.io.IOException;
import java.util.Date;

import org.uqbar.commons.utils.Observable;

import com.fasterxml.jackson.annotation.JsonProperty;

@Observable
public class Cuenta {
	private String nombre_cuenta;
	private int valor;
	private int anio_cuenta;


	public Boolean perteneceA(int periodo){
		return this.anio_cuenta == periodo;
	}

	// getters and setters
	public String getNombre_cuenta() {
		return nombre_cuenta;
	}

	public void setNombre_cuenta(String nombre_cuenta) {
		this.nombre_cuenta = nombre_cuenta;
	}
	

	public int getAnio_cuenta() {
		return anio_cuenta;
	}

	public void setAnio_cuenta(int anio_cuenta) {
		this.anio_cuenta = anio_cuenta;
	}

}
