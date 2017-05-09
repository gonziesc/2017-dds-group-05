package model;

import java.io.IOException;
import java.util.Date;

import org.uqbar.commons.utils.Observable;

import com.fasterxml.jackson.annotation.JsonProperty;

@Observable
public class Cuenta {
	private String nombreCuenta;
	private int valor;
	private int anioCuenta;


	public Boolean perteneceA(int periodo){
		return this.anioCuenta == periodo;
	}


	public String getNombreCuenta() {
		return nombreCuenta;
	}


	public void setNombreCuenta(String nombreCuenta) {
		nombreCuenta = nombreCuenta;
	}


	public int getAnioCuenta() {
		return anioCuenta;
	}


	public void setAnioCuenta(int anioCuenta) {
		anioCuenta = anioCuenta;
	}


	public int getValor() {
		return valor;
	}


	public void setValor(int valor) {
		valor = valor;
	}

	

}
