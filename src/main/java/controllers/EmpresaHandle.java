package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import model.Empresa;
import model.Indicador;

public class EmpresaHandle {
	Map<String, List<Empresa>> empresas = new HashMap<>();
	Integer valor;

	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	public Map<String, List<Empresa>> getEmpresas() {
		return empresas;
	}
	public void setEmpresas(Map<String, List<Empresa>> empresas) {
		this.empresas = empresas;
	}
	
	
}
