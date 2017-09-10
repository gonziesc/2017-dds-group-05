package model;

import java.io.IOException;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.uqbar.commons.utils.Observable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.jsontype.SubtypeResolver;

@Entity @Table(name="cuentas")
@Observable
public class Cuenta{
	@Id @GeneratedValue
	private Long id;
	private String nombreCuenta;
	private int anioCuenta;
	private int valor;

	public Cuenta(){
		
	}
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
