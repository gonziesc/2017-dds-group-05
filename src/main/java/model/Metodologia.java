package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private int valor;
	private int periodoInicio;
	private int periodoFin;
	@OneToOne
	private Indicador unIndicador;
	@OneToOne
	private Indicador otroIndicador;
	@OneToMany (cascade = CascadeType.ALL)@JoinColumn(name="metodologia_id")
	private List<Comparador> comparadoresFiltrado = new ArrayList<Comparador>();
	@OneToMany (cascade = CascadeType.ALL)@JoinColumn(name="metodologia_id")
	private List<Comparador> comparadoresOrdenamiento= new ArrayList<Comparador>();

	public Metodologia(){}
	
	//de prueba
	public void setId(int id){
		this.id = (long) id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public List<Empresa> calcularMetodologia(List<Empresa> listaEmpresas) {
		return ordenarEmpresas(filtrarEmpresas(listaEmpresas));
	}

	protected List<Empresa> filtrarEmpresas(List<Empresa> listaEmpresas) {
		comparadoresFiltrado.forEach(comparador -> 
			filtrarEmpresasParcial(listaEmpresas, comparador));
		return listaEmpresas;
	}

	@SuppressWarnings("unchecked")
	protected List<Empresa> filtrarEmpresasParcial(List<Empresa> listaEmpresas,
			Comparador comparador) {
		return (List<Empresa>) listaEmpresas.stream().filter(empresa -> calcularMetodologia(empresa, null, comparador) != null);
	}

	protected List<Empresa> ordenarEmpresas(List<Empresa> listaEmpresas) {
		comparadoresOrdenamiento.forEach(comparador -> 
					ordenarEmpresasParcial(listaEmpresas,comparador));
		return listaEmpresas;
	}

	protected List<Empresa> ordenarEmpresasParcial(List<Empresa> listaEmpresas,
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
		return listaEmpresas;
	}

	protected Empresa calcularMetodologia(Empresa empresa1, Empresa empresa2,
			Comparador comparador) {
		return comparador.calcularMetodologia(empresa1, empresa2, unIndicador,
				otroIndicador, valor, ">", periodoInicio,
				periodoFin);
	}
	public void addComparadorParaFilatrado(Comparador unComparador) {
		comparadoresFiltrado.add(unComparador);
	}

	public void addComparadorParaOrden(Comparador unComparador) {
		comparadoresOrdenamiento.add(unComparador);
	}





}
