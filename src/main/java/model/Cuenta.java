package model;

import java.io.IOException;
import java.util.Date;

import org.uqbar.commons.utils.Observable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.jsontype.SubtypeResolver;

@Observable

public class Cuenta{
	private String nombreCuenta;
	private int anioCuenta;
	private int valor;

	public Boolean perteneceA (int periodo){
		return this.getAnioCuenta() == periodo;
	}
	
	public int getValor() {
		return valor;
	}
	
	public void setValor(int unValor) {
		valor = unValor;
	}

	public String getNombreCuenta() {
		return nombreCuenta;
	}

	public void setNombreCuenta(String unNombreCuenta) {
		nombreCuenta = unNombreCuenta;
	}


	public int getAnioCuenta() {
		return anioCuenta;
	}


	public void setAnioCuenta(int unAnioCuenta) {
		anioCuenta = unAnioCuenta;
	}



}
