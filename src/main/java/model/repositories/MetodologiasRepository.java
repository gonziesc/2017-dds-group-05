package model.repositories;

import java.util.LinkedList;
import java.util.List;

import model.Comparador;
import model.ComparadorAnios;
import model.ComparadorFiltro;
import model.ComparadorOrden;
import model.ComparadorPromedio;
import model.ComparadorUnoMayorQueOtro;
import model.ComparadorUnoMayorQueOtroEnElTiempo;
import model.ComparadorValor;
import model.ComparadorValorTiempo;
import model.Empresa;
import model.Metodologia;

public class MetodologiasRepository {
	private List<Metodologia> metodologias = new LinkedList<>();
	private List<ComparadorFiltro> comparadoresFiltro = new LinkedList<>();
	private List<ComparadorOrden> comparadoresOrden = new LinkedList<>();
	
	public List<ComparadorFiltro> allComparadoresFiltro(){
		comparadoresFiltro.add(new ComparadorAnios());
		comparadoresFiltro.add(new ComparadorPromedio());
		comparadoresFiltro.add(new ComparadorValor());
		comparadoresFiltro.add(new ComparadorValorTiempo());
		return comparadoresFiltro;
	}

	public List<Metodologia> allMetodologias() {
		return metodologias;
	}
	
	public List<ComparadorOrden> allComparadoresOrden(){
		comparadoresOrden.add(new ComparadorUnoMayorQueOtro());
		comparadoresOrden.add(new ComparadorUnoMayorQueOtroEnElTiempo());
		return comparadoresOrden;
	}
}
