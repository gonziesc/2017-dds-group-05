package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import scala.Array;

@Observable
public class Metodologia {
	
	private int periodoInicio;
	private int periodoFin;
	private Indicador unIndicador;
	private List<Comparador> comparadoresFiltrado = new ArrayList<Comparador>();
	private Comparador comparadorOrden;

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

	public List<Comparador> getComparadoresFiltrado() {
		return comparadoresFiltrado;
	}

	public void setComparadoresFiltrado(List<Comparador> comparadoresFiltrado) {
		this.comparadoresFiltrado = comparadoresFiltrado;
	}

	public List<Empresa> calcularMetodologia(List<Empresa> listaEmpresas) {
		return ordenarEmpresasParcial(filtrarEmpresas(listaEmpresas));
	}

	protected List<Empresa> filtrarEmpresas(List<Empresa> listaEmpresas) {
		comparadoresFiltrado.forEach(comparador -> 
			filtrarEmpresasParcial(listaEmpresas, comparador));
		return listaEmpresas;
	}

	@SuppressWarnings("unchecked")
	protected List<Empresa> filtrarEmpresasParcial(List<Empresa> listaEmpresas,Comparador comparador) {
		return (List<Empresa>) listaEmpresas.stream().filter(empresa -> calcularMetodologia(empresa, null, comparador) != null);
	}

	/*protected List<Empresa> ordenarEmpresas(List<Empresa> listaEmpresas) {
		comparadoresOrdenamiento.forEach(comparador -> 
					ordenarEmpresasParcial(listaEmpresas,comparador));
		return listaEmpresas;
	}*/

	protected List<Empresa> ordenarEmpresasParcial(List<Empresa> listaEmpresas) {
		Collections.sort(listaEmpresas, new Comparator<Empresa>() {
			@Override
			public int compare(Empresa empresa1, Empresa empresa2) {
				Empresa empresaMejor = calcularMetodologia(empresa1, empresa2,
						comparadorOrden);
				if (empresaMejor.equals(empresa1)) {
					return 1;
				} else if (empresaMejor.equals(empresa2)) {
					return -1;
				}
				return 0;
			}
		});
		return listaEmpresas;
	}

	protected Empresa calcularMetodologia(Empresa empresa1, Empresa empresa2,
			Comparador comparador) {
		return comparador.comparar(empresa1, empresa2, unIndicador);
	}
	public void addComparadorParaFilatrado(Comparador unComparador) {
		comparadoresFiltrado.add(unComparador);
	}

	public Comparador getComparadorOrden() {
		return comparadorOrden;
	}

	public void setComparadorOrden(Comparador comparadorOrden) {
		this.comparadorOrden = comparadorOrden;
	}

}
