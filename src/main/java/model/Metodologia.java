package model;

import org.uqbar.commons.utils.Observable;

@Observable
public class Metodologia {
	
	public Empresa getUnaEmpresa() {
		return unaEmpresa;
	}

	public void setUnaEmpresa(Empresa unaEmpresa) {
		this.unaEmpresa = unaEmpresa;
	}

	public Empresa getOtraEmpresa() {
		return otraEmpresa;
	}

	public void setOtraEmpresa(Empresa otraEmpresa) {
		this.otraEmpresa = otraEmpresa;
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

	public Comparador getComparador() {
		return comparador;
	}

	public void setComparador(Comparador comparador) {
		this.comparador = comparador;
	}

	public String getComparadorOperando() {
		return comparadorOperando;
	}

	public void setComparadorOperando(String comparadorOperando) {
		this.comparadorOperando = comparadorOperando;
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
	public Empresa unaEmpresa;
	private Empresa otraEmpresa;
	private Indicador unIndicador;
	private Indicador otroIndicador;
	private Comparador comparador;
	private String comparadorOperando = ">";
	private int valor;
	private int periodoInicio;
	private int periodoFin;

	public Metodologia(Comparador unComparador) {
		comparador = unComparador;
	}

	public Empresa calcularMetodologia() {
		return comparador.calcularMetodologia(unaEmpresa, otraEmpresa,
				unIndicador, otroIndicador, valor, comparadorOperando,
				periodoInicio, periodoFin);
	}
}
