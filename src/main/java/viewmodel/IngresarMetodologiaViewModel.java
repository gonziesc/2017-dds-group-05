package viewmodel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

import Services.IndicadoresService;
import Services.MetodologiasService;
import model.Comparador;
import model.Indicador;
import model.Metodologia;
import model.repositories.Repositorios;

@Observable
public class IngresarMetodologiaViewModel {
	private List<Indicador> indicadores;
	private Indicador indicadorSeleccionado;
	private Comparador comparadorSeleccionado;
	private Integer valorComparador;
	private Metodologia metodologia;
	private List<Comparador> comparadores;
	private String nombreMetodologia;
	
	public void obtenerComparadores(){
		comparadores = Repositorios.metodologias.allComparadores();
	}
	
	public void ingresarMetodologia() {
		setearMetodologia();

		try {
			MetodologiasService.guardarMetodologiaEnServicioExterno(metodologia);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setearMetodologia() {
		metodologia = new Metodologia(comparadorSeleccionado);
		metodologia.setUnIndicador(indicadorSeleccionado);
		metodologia.setOtroIndicador(indicadorSeleccionado);
		metodologia.setValor(valorComparador);
		metodologia.setNombre(nombreMetodologia);
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

	public Integer getValorComparador() {
		return valorComparador;
	}

	public void setValorComparador(Integer valorComparador) {
		this.valorComparador = valorComparador;
	}

	public String getNombreMetodologia() {
		return nombreMetodologia;
	}

	public void setNombreMetodologia(String nombreMetodologia) {
		this.nombreMetodologia = nombreMetodologia;
	}

	public void validarIngreso(String mensaje, Object atributoAEvaluar) {
		if (atributoAEvaluar == null){
			throw new UserException(mensaje);
		}
	}
	public void validarComparadorSeleccionado(){
		this.validarIngreso("Ingrese comparador", this.comparadorSeleccionado);		
	}
	public void validarIndicadorSeleccionado(){
		this.validarIngreso("Ingrese indicador", this.indicadorSeleccionado);
	}
	
}
