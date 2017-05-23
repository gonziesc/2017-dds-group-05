package model;

import org.uqbar.commons.utils.Observable;

@Observable
public class Indicador {
	private double valor;
	private String operador;
	
	//getters & setters
	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
}
