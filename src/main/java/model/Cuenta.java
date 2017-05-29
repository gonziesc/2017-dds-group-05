package model;

import java.io.IOException;
import java.util.Date;

import org.uqbar.commons.utils.Observable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.jsontype.SubtypeResolver;

@Observable
public class Cuenta extends Parametro{

	public Boolean perteneceA (int periodo){
		return super.getAnioCuenta() == periodo;
	}
	
	public int getValor() {
		return valor;
	}
	public int obtenerValor() {
		return valor;
	}
	
	public void setValor(int unValor) {
		valor = unValor;
	}
	/*private int anioCuenta;
	private String nombreCuenta;

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

	*/

}
