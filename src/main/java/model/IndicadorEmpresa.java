package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity @Table(name="indicador_empresa")
public class IndicadorEmpresa {
	@Id @GeneratedValue
	public Long id;
	@ManyToOne
	@JoinColumn(name="empresa_id")
	public Empresa empresa;
	@ManyToOne
	@JoinColumn(name="indicador_id")
	public Indicador indicador;
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public Indicador getIndicador() {
		return indicador;
	}
	public void setIndicador(Indicador indicador) {
		this.indicador = indicador;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public int valor;
}
