package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.uqbar.commons.utils.Observable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Observable
public class Metodologia2 {
	
	private String nombre;
	private List<Comparador>  comparadoresFiltrado;
	private List<Comparador>  comparadoresOrdenamiento;
	private String operandoOrdenamiento = ">";
	private int valor;
	private int periodoInicio;
	private int periodoFin;
	private Indicador unIndicador;
	private Indicador otroIndicador;
	

	public Metodologia2(String unNombre) {
		nombre = unNombre;
		comparadoresFiltrado = new ArrayList<Comparador>();
		comparadoresOrdenamiento = new ArrayList<Comparador>();
	}

	public void calcularMetodologia2(List<Empresa> listaEmpresas){
		filtrarEmpresas(listaEmpresas);
		ordenarEmpresas(listaEmpresas);
	}
	
	protected void filtrarEmpresas(List<Empresa> listaEmpresas){
		for(int i =0; i < comparadoresFiltrado.size(); i++){ 
			filtrarEmpresasParcial(listaEmpresas, comparadoresFiltrado.get(i));
		}
	}
	
	protected void filtrarEmpresasParcial(List<Empresa> listaEmpresas, Comparador comparador){
		List<Empresa> listaAuxiliar = new ArrayList<Empresa>();
		for(int j=0 ; j< listaEmpresas.size(); j++){
			if(calcularMetodologia(listaEmpresas.get(j), null, comparador) != null){
				listaAuxiliar.add(listaEmpresas.get(j));
			}
		}
		listaEmpresas = listaAuxiliar;
	}
	
	protected void ordenarEmpresas(List<Empresa> listaEmpresas){
		for(int i =0; i < comparadoresOrdenamiento.size(); i++){ 
			ordenarEmpresasParcial(listaEmpresas, comparadoresOrdenamiento.get(i));
		}
	}
	
	protected void ordenarEmpresasParcial(List<Empresa> listaEmpresas, Comparador comparador){
		 Collections.sort(listaEmpresas, new Comparator<Empresa>() {
	        @Override
	        public int compare(Empresa empresa1, Empresa empresa2)
	        {
	            Empresa empresaMejor = calcularMetodologia(empresa1, empresa2, comparador);
	            if(empresaMejor.equals(empresa1)){
	            	return 1;
	            }
	            else if(empresaMejor.equals(empresa2)){
	            	return -1;
	            }
	            return 0;
	        }
	    });
	}
	
	protected Empresa calcularMetodologia(Empresa empresa1, Empresa empresa2, Comparador comparador) {
		return comparador.calcularMetodologia(empresa1, empresa2,
				unIndicador, otroIndicador, valor, operandoOrdenamiento,
				periodoInicio, periodoFin);
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

	public List<Comparador> getComparadoresFiltrado() {
		return comparadoresFiltrado;
	}

	public void setComparadorFiltrado(List<Comparador> comparadoresFiltrado) {
		this.comparadoresFiltrado = comparadoresFiltrado;
	}
	
	public List<Comparador> getComparadoresOrdenamiento() {
		return comparadoresOrdenamiento;
	}

	public void setComparadorOrdenamiento(List<Comparador> comparadoresOrdenamiento) {
		this.comparadoresOrdenamiento = comparadoresOrdenamiento;
	}

	public String getComparadorOperando() {
		return operandoOrdenamiento;
	}

	public void setComparadorOperando(String comparadorOperando) {
		this.operandoOrdenamiento = comparadorOperando;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
