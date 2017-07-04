package viewmodel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.uqbar.commons.utils.Observable;

import Services.IndicadoresService;
import Services.MetodologiasService;
import model.Comparador;
import model.ComparadorUnoMayorQueOtro;
import model.Indicador;
import model.Metodologia;
import model.repositories.Repositorios;

@Observable
public class IngresarMetodologiaViewModel {
	private List<Indicador> indicadores;
	private Indicador indicadorSeleccionado;
	private Comparador comparadorSeleccionado;
	private Metodologia metodologia = new Metodologia(null);
	private List<Comparador> comparadores;
	
	public void obtenerComparadores(){
		comparadores = Repositorios.metodologias.allComparadores();
	}
	
	public void ingresarMetodologia() {
		metodologia.setComparador(comparadorSeleccionado);
		try {
			MetodologiasService.guardarMetodologiaEnServicioExterno(metodologia);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void obtenerIndicadores() {
		try {
			indicadores = IndicadoresService.obtenerInicadoresDeServicioExterno();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public List<Indicador> getIndicadores() {
		return indicadores;
	}
	public void setIndicadores(List<Indicador> indicadores) {
		this.indicadores = indicadores;
	}
	public Indicador getIndicadorSeleccionado() {
		return indicadorSeleccionado;
	}
	public void setIndicadorSeleccionado(Indicador indicadorSeleccionado) {
		this.indicadorSeleccionado = indicadorSeleccionado;
	}
	public Comparador getComparadorSeleccionado() {
		return comparadorSeleccionado;
	}
	public void setComparadorSeleccionado(Comparador comparadorSeleccionado) {
		this.comparadorSeleccionado = comparadorSeleccionado;
	}

	public List<Comparador> getComparadores() {
		return comparadores;
	}

	public void setComparadores(List<Comparador> comparadores) {
		this.comparadores = comparadores;
	}
	
}
