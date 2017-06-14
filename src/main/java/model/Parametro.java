package model;

import org.uqbar.commons.utils.Observable;

@Observable
public class Parametro extends parametroGeneral{
	protected int valor;
	private String nombre = ""; /*solo si es una cuenta */
	
	public void init(){
		valor = 0;
	}
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
