package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Cuenta;
import model.Empresa;
import model.Indicador;

public class IndicadoresHandle {
	Map<String, List<Cuenta>> cuentas= new HashMap<>();
	Map<String, List<Indicador>> indicadores = new HashMap<>();

	public Map<String, List<Cuenta>> getCuentas() {
		return cuentas;
	}
	public void setCuentas(Map<String, List<Cuenta>> cuentas) {
		this.cuentas = cuentas;
	}
	public Map<String, List<Indicador>> getIndicadores() {
		return indicadores;
	}
	public void setIndicadores(Map<String, List<Indicador>> indicadores) {
		this.indicadores = indicadores;
	}
}
