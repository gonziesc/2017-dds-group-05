package model;

import org.uqbar.commons.utils.Observable;

@Observable
public class ComparadorAnios extends Comparador{
	
	public Empresa calcularMetodologia(Empresa unaEmpresa, Empresa otraEmpresa, Indicador unIndicador, Indicador otroIndicador, int valor, String comparador, int periodoInicio, int periodoFin) {
		Boolean condicion = Operadores.compararOperacion(unaEmpresa.aniosEmpresa(),
				valor, comparador);
		return procesarRetorno(unaEmpresa, otraEmpresa, condicion);
	}

	public String getNombreComparador(){
		return "Comparador por anios";
	}

}
