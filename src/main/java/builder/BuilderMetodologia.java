package builder;

import java.util.LinkedList;
import java.util.List;

import model.Comparador;
import model.Indicador;
import model.Metodologia2;

public class BuilderMetodologia {
	private String nombre;
	private List<Comparador>  comparadoresFiltrado = new LinkedList<Comparador>();
	private List<Comparador>  comparadoresOrdenamiento = new LinkedList<Comparador>();
	private String operandoOrdenamiento = ">";
	private int valor;
	private int periodoInicio;
	private int periodoFin;
	private Indicador unIndicador;
	private Indicador otroIndicador;
	
	public Metodologia2 build(){
		Metodologia2 metodologia = new Metodologia2(nombre);
		metodologia.setUnIndicador(unIndicador);
		metodologia.setOtroIndicador(otroIndicador);
		metodologia.setComparadoresOrdenamiento(comparadoresOrdenamiento);
		metodologia.setComparadoresFiltrado(comparadoresFiltrado);
		return metodologia;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Comparador> getComparadoresFiltrado() {
		return comparadoresFiltrado;
	}
	public void setComparadoresFiltrado(List<Comparador> comparadoresFiltrado) {
		this.comparadoresFiltrado = comparadoresFiltrado;
	}
	public List<Comparador> getComparadoresOrdenamiento() {
		return comparadoresOrdenamiento;
	}
	public void setComparadoresOrdenamiento(List<Comparador> comparadoresOrdenamiento) {
		this.comparadoresOrdenamiento = comparadoresOrdenamiento;
	}
	public String getOperandoOrdenamiento() {
		return operandoOrdenamiento;
	}
	public void setOperandoOrdenamiento(String operandoOrdenamiento) {
		this.operandoOrdenamiento = operandoOrdenamiento;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
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
	public Indicador getOtroIndicador() {
		return otroIndicador;
	}
	public void setOtroIndicador(Indicador otroIndicador) {
		this.otroIndicador = otroIndicador;
	}
	public void addComparadorParaFilatrado(Comparador unComparador){
		comparadoresFiltrado.add(unComparador);
	}
	
	public void addComparadorParaOrden(Comparador unComparador){
		comparadoresOrdenamiento.add(unComparador);
	}
}
