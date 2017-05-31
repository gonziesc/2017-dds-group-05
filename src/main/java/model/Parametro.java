package model;

import org.uqbar.commons.utils.Observable;

@Observable
public class Parametro {
	protected int valor;
	private String nombre = ""; /*solo si es una cuenta */
	
	public int getValor() {
		return valor;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


}
