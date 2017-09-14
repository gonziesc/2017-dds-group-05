package builder;

import java.util.LinkedList;
import java.util.List;

import model.Comparador;
import model.ComparadorFiltro;
import model.ComparadorOrden;
import model.Indicador;
import model.Metodologia;

public class BuilderMetodologia {
	private String nombre;
	private List<ComparadorFiltro>  comparadoresFiltrado = new LinkedList<ComparadorFiltro>();
	private ComparadorOrden comparadorOrden;
	private String operandoOrdenamiento = ">";
	private int periodoInicio;
	private int periodoFin;
	private Indicador unIndicador;
		
	public Metodologia build(){
		Metodologia metodologia = new Metodologia();
		metodologia.setUnIndicador(unIndicador);
		metodologia.setComparadorOrden(comparadorOrden);
		metodologia.setComparadoresFiltrado(comparadoresFiltrado);
		metodologia.setNombre(nombre);
		metodologia.setPeriodoFin(periodoFin);
		metodologia.setPeriodoInicio(periodoInicio);
		return metodologia;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<ComparadorFiltro> getComparadoresFiltrado() {
		return comparadoresFiltrado;
	}
	public void setComparadoresFiltrado(List<ComparadorFiltro> comparadoresFiltrado) {
		this.comparadoresFiltrado = comparadoresFiltrado;
	}
	/*public List<Comparador> getComparadoresOrdenamiento() {
		return comparadoresOrdenamiento;
	}
	public void setComparadoresOrdenamiento(List<Comparador> comparadoresOrdenamiento) {
		this.comparadoresOrdenamiento = comparadoresOrdenamiento;
	}*/
	public String getOperandoOrdenamiento() {
		return operandoOrdenamiento;
	}
	public void setOperandoOrdenamiento(String operandoOrdenamiento) {
		this.operandoOrdenamiento = operandoOrdenamiento;
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
	public Indicador getUnIndicador() {
		return unIndicador;
	}
	public void setUnIndicador(Indicador unIndicador) {
		this.unIndicador = unIndicador;
	}
	
	public void addComparadorParaFiltrado(ComparadorFiltro unComparador){
		comparadoresFiltrado.add(unComparador);
	}
	
	/*public void addComparadorParaOrden(Comparador unComparador){
		comparadoresOrdenamiento.add(unComparador);
	}*/


	public ComparadorOrden getComparadorOrden() {
		return comparadorOrden;
	}
	

	public void setComparadorOrden(ComparadorOrden comparadorOrden) {
		this.comparadorOrden = comparadorOrden;
	}
}
