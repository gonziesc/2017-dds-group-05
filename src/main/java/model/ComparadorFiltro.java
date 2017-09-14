package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.uqbar.commons.utils.Observable;

@Observable
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
public abstract class ComparadorFiltro{
	@Id @GeneratedValue
	private Long id;
	
	@Column(name = "nombre_comparador")
	private String nombreComparador;
	
	@Column(name = "operando")
	private String operando = ">";
	
	protected Indicador cargarIndicador(Cuenta c, Indicador indicador) {
		indicador.setValorCuenta(c);
		return indicador;
	}
	
	public String getOperando() {
		return operando;
	}

	public void setOperando(String operando) {
		this.operando = operando;
	}

	public String getNombreComparador() {
		return nombreComparador;
	}

	public void setNombreComparador(String nombreComparador) {
		this.nombreComparador = nombreComparador;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	private int valor;

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public abstract Boolean comparar(Empresa unaEmpresa, Indicador unIndicador, int fechaDesde, int fechaHasta);
}
