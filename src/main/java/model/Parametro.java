package model;

import org.uqbar.commons.utils.Observable;

@Observable
public class Parametro {
	protected int valor;
	
	
	public int getValor() {
		return valor;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}
	
}
