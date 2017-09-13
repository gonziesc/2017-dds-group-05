package model.repositories;

import java.util.LinkedList;
import java.util.List;

import model.Comparador;
import model.ComparadorAnios;
import model.ComparadorPromedio;
import model.ComparadorUnoMayorQueOtro;
import model.ComparadorUnoMayorQueOtroEnElTiempo;
import model.ComparadorValor;
import model.ComparadorValorTiempo;
import model.Empresa;
import model.Metodologia;

public class MetodologiasRepository {
	private List<Metodologia> metodologias = new LinkedList<>();
	private List<Comparador> comparadores = new LinkedList<>();
	
	public List<Comparador> allComparadoresFiltro(){
		comparadores.add(new ComparadorAnios());
		comparadores.add(new ComparadorPromedio());
		comparadores.add(new ComparadorValor());
		comparadores.add(new ComparadorValorTiempo());
		return comparadores;
	}

	public List<Metodologia> allMetodologias() {
		return metodologias;
	}
	
	public List<Comparador> allComparadoresOrden(){
		comparadores.add(new ComparadorUnoMayorQueOtro());
		comparadores.add(new ComparadorUnoMayorQueOtroEnElTiempo());
		return comparadores;
	}
}
