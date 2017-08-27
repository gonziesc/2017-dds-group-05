package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Observable
public class Metodologia2 {

	private String nombre;
	private String operandoOrdenamiento = ">";
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public List<Comparador> getComparadoresFiltrado() {
		return comparadoresFiltrado;
	}

	public void setComparadoresFiltrado(List<Comparador> comparadoresFiltrado) {
		this.comparadoresFiltrado = comparadoresFiltrado;
	}

	public List<Comparador> getComparadoresOrdenamiento() {
		return comparadoresOrdenamiento;
	}

	public void setComparadoresOrdenamiento(
			List<Comparador> comparadoresOrdenamiento) {
		this.comparadoresOrdenamiento = comparadoresOrdenamiento;
	}

	private int valor;
	private int periodoInicio;
	private int periodoFin;
	private Indicador unIndicador;
	private Indicador otroIndicador;
	private List<Comparador> comparadoresFiltrado;
	private List<Comparador> comparadoresOrdenamiento;
	public Metodologia2(String unNombre) {
		setNombre(unNombre);
		comparadoresFiltrado = new LinkedList<Comparador>();
		comparadoresOrdenamiento = new LinkedList<Comparador>();
	}

	public void calcularMetodologia2(List<Empresa> listaEmpresas) {
		filtrarEmpresas(listaEmpresas);
		ordenarEmpresas(listaEmpresas);
	}

	protected void filtrarEmpresas(List<Empresa> listaEmpresas) {
		comparadoresFiltrado.forEach(comparador -> 
				filtrarEmpresasParcial(listaEmpresas, comparador));
	}

	protected void filtrarEmpresasParcial(List<Empresa> listaEmpresas,
			Comparador comparador) {
		List<Empresa> listaAuxiliar = new ArrayList<Empresa>();
		for (int j = 0; j < listaEmpresas.size(); j++) {
			if (calcularMetodologia(listaEmpresas.get(j), null, comparador) != null) {
				listaAuxiliar.add(listaEmpresas.get(j));
			}
		}
		listaEmpresas = listaAuxiliar;
	}

	protected void ordenarEmpresas(List<Empresa> listaEmpresas) {
			comparadoresOrdenamiento.forEach(comparador ->
					ordenarEmpresasParcial(listaEmpresas,comparador));
		
	}

	protected void ordenarEmpresasParcial(List<Empresa> listaEmpresas,
			Comparador comparador) {
		Collections.sort(listaEmpresas, new Comparator<Empresa>() {
			@Override
			public int compare(Empresa empresa1, Empresa empresa2) {
				Empresa empresaMejor = calcularMetodologia(empresa1, empresa2,
						comparador);
				if (empresaMejor.equals(empresa1)) {
					return 1;
				} else if (empresaMejor.equals(empresa2)) {
					return -1;
				}
				return 0;
			}
		});
	}

	protected Empresa calcularMetodologia(Empresa empresa1, Empresa empresa2,
			Comparador comparador) {
		return comparador.calcularMetodologia(empresa1, empresa2, unIndicador,
				otroIndicador, valor, operandoOrdenamiento, periodoInicio,
				periodoFin);
	}
	public void addComparadorParaFilatrado(Comparador unComparador) {
		comparadoresFiltrado.add(unComparador);
	}

	public void addComparadorParaOrden(Comparador unComparador) {
		comparadoresOrdenamiento.add(unComparador);
	}





}
