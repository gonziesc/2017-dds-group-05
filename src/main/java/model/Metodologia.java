package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.uqbar.commons.utils.Observable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import scala.Array;

@Entity @Table(name="metodologias")
@Observable
public class Metodologia {

	@Id @GeneratedValue
	private Long id;
	private String nombre;
	private int periodoInicio;
	private int periodoFin;
	@OneToOne(cascade = CascadeType.PERSIST)
	private Indicador unIndicador;
	@OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER) @JoinColumn(name="metodologia_id")
	private List<ComparadorFiltro> comparadoresFiltrado = new ArrayList<ComparadorFiltro>();
	@OneToOne (cascade = CascadeType.ALL)
	private ComparadorOrden comparadorOrden;

	public Metodologia(){}
	
	//de prueba
	public void setId(int id){
		this.id = (long) id;
	}
	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public List<ComparadorFiltro> getComparadoresFiltrado() {
		return comparadoresFiltrado;
	}

	public void setComparadoresFiltrado(List<ComparadorFiltro> comparadoresFiltrado) {
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
	protected List<Empresa> filtrarEmpresasParcial(List<Empresa> listaEmpresas,ComparadorFiltro comparador) {
		return listaEmpresas.stream().filter(empresa -> calcularMetodologia(empresa, comparador)).collect(Collectors.toList());
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
			ComparadorOrden comparadorOrden2) {
		return comparadorOrden2.comparar(empresa1, empresa2, unIndicador, periodoInicio, periodoFin);
	}
	
	protected Boolean calcularMetodologia(Empresa empresa1, ComparadorFiltro comparador) {
		return comparador.comparar(empresa1, unIndicador, periodoInicio, periodoFin);
	}
	public void addComparadorParaFilatrado(ComparadorFiltro unComparador) {
		comparadoresFiltrado.add(unComparador);
	}

	public ComparadorOrden getComparadorOrden() {
		return comparadorOrden;
	}

	public void setComparadorOrden(ComparadorOrden comparadorOrden) {
		this.comparadorOrden = comparadorOrden;
	}

}
