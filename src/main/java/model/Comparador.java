package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.uqbar.commons.utils.Observable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity 
@Table(name="comparadores")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Observable
public abstract class Comparador {

	public Comparador(){}

	@Id @GeneratedValue
	private Long id;
	@Column(name = "nombre_comparador")
	private String nombreComparador;
	private int periodoInicio;
	private int periodoFin;
	@Column(name = "operando")
	private String operando;
	private int valor;
	
	public abstract Empresa comparar(Empresa unaEmpresa, Empresa otraEmpresa, Indicador unIndicador);

	public String getNombreComparador() {
		return nombreComparador;
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

	public String getOperando() {
		return operando;
	}

	public void setOperando(String operando) {
		this.operando = operando;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
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
}
