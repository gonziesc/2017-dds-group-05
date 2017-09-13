package viewmodel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

import Services.IndicadoresService;
import Services.MetodologiasService;
import builder.BuilderMetodologia;
import model.Comparador;
import model.Indicador;
import model.repositories.Repositorios;

@Observable
public class IngresarMetodologiaViewModel {
	private List<Indicador> indicadores;
	private Indicador indicadorSeleccionado;
	private Comparador comparadorSeleccionado;
	private Integer valorComparador;
	private List<Comparador> comparadores;
	private String nombreMetodologia;
	private Boolean esFiltrable = false;
	private Boolean esOrdenable = false;
	private BuilderMetodologia builderMetodologia = new BuilderMetodologia();
	
	public IngresarMetodologiaViewModel(BuilderMetodologia builder) {
		builderMetodologia = builder;
	}

	public void obtenerComparadores(){
		comparadores = Repositorios.metodologias.allComparadores();
	}
	
	public void ingresarMetodologia() {
			MetodologiasService.guardarMetodologiaEnServicioExterno(builderMetodologia.build());
	}

	public void setearMetodologia() {
		builderMetodologia.setNombre(nombreMetodologia);
		builderMetodologia.setUnIndicador(indicadorSeleccionado);
		
		agregarComparadores();
		
	}

	public void agregarComparadores() {
		if(esFiltrable){
		builderMetodologia.addComparadorParaFiltrado(comparadorSeleccionado);
		}
		if(esOrdenable){
		builderMetodologia.setComparadorOrden(comparadorSeleccionado);
		}
	}
	
	public void obtenerIndicadores() {
			indicadores = IndicadoresService.obtenerInicadoresDeServicioExterno();
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
		ObservableUtils.firePropertyChanged(this, "comparadorSeleccionado", this.getComparadorSeleccionado());
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
	public void validarNombre(){
		this.validarIngreso("Ingrese el nombre de la metodologia", this.nombreMetodologia);
	}

	public BuilderMetodologia getBuilderMetodologia() {
		return builderMetodologia;
	}

	public void setBuilderMetodologia(BuilderMetodologia builderMetodologia) {
		this.builderMetodologia = builderMetodologia;
	}

	public Boolean getEsFiltrable() {
		return esFiltrable;
	}

	public void setEsFiltrable(Boolean esFiltrable) {
		this.esFiltrable = esFiltrable;
		ObservableUtils.firePropertyChanged(this, "esFiltrable", this.getEsFiltrable());
	}

	public Boolean getEsOrdenable() {
		return esOrdenable;
	}

	public void setEsOrdenable(Boolean esOrdenable) {
		this.esOrdenable = esOrdenable;
		ObservableUtils.firePropertyChanged(this, "esFiltrable", this.getEsFiltrable());
	}
	
}
