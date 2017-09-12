package model;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Observable
public abstract class Comparador {
	
	private String nombreComparador;
	private int periodoInicio;
	private int periodoFin;
	private String operando;
	private int valor;
	
	public abstract Empresa comparar(Empresa unaEmpresa, Empresa otraEmpresa, Indicador unIndicador);

	public String getNombreComparador() {
		return nombreComparador;
	}

	public int getPeriodoInicio() {
		return periodoInicio;
	}

	public void setPeriodoInicio(int periodoInicio) {
		this.periodoInicio = periodoInicio;
	}

	public int getPeriodoFin() {
		return periodoFin;
	}

	public void setPeriodoFin(int periodoFin) {
		this.periodoFin = periodoFin;
	}

	public String getOperando() {
		return operando;
	}

	public void setOperando(String operando) {
		this.operando = operando;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public void setNombreComparador(String nombreComparador) {
		this.nombreComparador = nombreComparador;
	}
}
