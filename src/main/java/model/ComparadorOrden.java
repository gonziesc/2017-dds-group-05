package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import org.uqbar.commons.utils.Observable;

@Observable
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
public abstract class ComparadorOrden{
	
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
	
	protected Empresa procesarRetorno(Empresa unaEmpresa, Empresa otraEmpresa, Boolean condicion) {
		if (condicion)
			return unaEmpresa;
		else
			return otraEmpresa;
	}

	public abstract Empresa comparar(Empresa unaEmpresa, Empresa otraEmpresa, Indicador unIndicador, int fechaDesde, int fechaHasta);
	
}
