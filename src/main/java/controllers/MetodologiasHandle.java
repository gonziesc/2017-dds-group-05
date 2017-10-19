package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Comparador;
import model.ComparadorFiltro;
import model.ComparadorOrden;
import model.Indicador;

public class MetodologiasHandle{
	Map<String, List<ComparadorOrden>> comparadorOrden= new HashMap<>();
	Map<String, List<ComparadorFiltro>> comparadorFiltro= new HashMap<>();
	Map<String, List<Indicador>> indicadores = new HashMap<>();
	
	public Map<String, List<Indicador>> getIndicadores() {
		return indicadores;
	}
	public void setIndicadores(Map<String, List<Indicador>> indicadores) {
		this.indicadores = indicadores;
	}
	public Map<String, List<ComparadorOrden>> getComparadorOrden() {
		return comparadorOrden;
	}
	public void setComparadorOrden(Map<String, List<ComparadorOrden>> comparadorOrden) {
		this.comparadorOrden = comparadorOrden;
	}
	public Map<String, List<ComparadorFiltro>> getComparadorFiltro() {
		return comparadorFiltro;
	}
	public void setComparadorFiltro(Map<String, List<ComparadorFiltro>> comparadorFiltro) {
		this.comparadorFiltro = comparadorFiltro;
	}
	
}
