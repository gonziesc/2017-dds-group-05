package viewmodel;

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
	private Comparador comparadorOrdenSeleccionado;
	private Comparador comparadorFiltroSeleccionado;
	private Integer valorComparador;
	private List<Comparador> comparadoresOrden;
	private List<Comparador> comparadoresFiltro;
	private String nombreMetodologia;
	private Boolean esFiltrable = false;
	private Boolean esOrdenable = false;
	private int fechaInicio;
	private int fechaFin;
	private BuilderMetodologia builderMetodologia = new BuilderMetodologia();
	
	public IngresarMetodologiaViewModel(BuilderMetodologia builder) {
		builderMetodologia = builder;
	}

	public void obtenerComparadores(){
		comparadoresFiltro = Repositorios.metodologias.allComparadoresFiltro();
		comparadoresOrden = Repositorios.metodologias.allComparadoresOrden();
	}
	
	public void ingresarMetodologia() {
		MetodologiasService.guardarMetodologiaEnServicioExterno(builderMetodologia.build());
	}

	public void setearMetodologia() {
		builderMetodologia.setNombre(nombreMetodologia);
		builderMetodologia.setUnIndicador(indicadorSeleccionado);
		builderMetodologia.setPeriodoFin(fechaFin);
		builderMetodologia.setPeriodoInicio(fechaInicio);
		agregarComparadores();
	}

	public void agregarComparadores() {
		if(esFiltrable){
		builderMetodologia.addComparadorParaFiltrado(comparadorFiltroSeleccionado);
		}
		if(esOrdenable && builderMetodologia.getComparadorOrden() !=  null){
		builderMetodologia.setComparadorOrden(comparadorOrdenSeleccionado);
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
		if(!esOrdenable && !esFiltrable){
			throw new UserException("Ingrese algun comparador");	
		}
	}
	
	public void validarIndicadorSeleccionado(){
		this.validarIngreso("Ingrese indicador", this.indicadorSeleccionado);
	}
	
	public void validarNombre(){
		this.validarIngreso("Ingrese el nombre de la metodologia", this.nombreMetodologia);
	}

	public void validarFechas(){
		this.validarIngreso("Ingrese fecha inicio metodologia", this.fechaInicio);
		this.validarIngreso("Ingrese fecha fin metodologia", this.fechaFin);
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

	public List<Comparador> getComparadoresFiltro() {
		return comparadoresFiltro;
	}

	public void setComparadoresFiltro(List<Comparador> comparadoresFiltro) {
		this.comparadoresFiltro = comparadoresFiltro;
	}

	public Comparador getComparadorOrdenSeleccionado() {
		return comparadorOrdenSeleccionado;
	}

	public void setComparadorOrdenSeleccionado(Comparador comparadorOrdenSeleccionado) {
		this.comparadorOrdenSeleccionado = comparadorOrdenSeleccionado;
		ObservableUtils.firePropertyChanged(this, "comparadorOrdenSeleccionado", this.getComparadorOrdenSeleccionado());
	}

	public Comparador getComparadorFiltroSeleccionado() {
		return comparadorFiltroSeleccionado;
	}

	public void setComparadorFiltroSeleccionado(Comparador comparadorFiltroSeleccionado) {
		this.comparadorFiltroSeleccionado = comparadorFiltroSeleccionado;
		ObservableUtils.firePropertyChanged(this, "comparadorFiltroSeleccionado", this.getComparadorFiltroSeleccionado());
	}

	public List<Comparador> getComparadoresOrden() {
		return comparadoresOrden;
	}

	public int getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(int fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public int getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(int fechaFin) {
		this.fechaFin = fechaFin;
	}
	
}
