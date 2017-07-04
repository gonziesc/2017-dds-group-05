package model;

import org.uqbar.commons.utils.Observable;

@Observable
public class ComparadorValor extends Comparador{
	public Empresa calcularMetodologia(Empresa unaEmpresa, Empresa otraEmpresa, Indicador unIndicador, Indicador otroIndicador, int valor, String comparador, int periodoInicio, int periodoFin) {
		unaEmpresa.getCuentas().stream()
		.forEach(c -> cargarIndicador(c, unIndicador));
		Boolean condicion = Operadores.compararOperacion(unIndicador.getValor(),
		valor, comparador);
		return procesarRetorno(unaEmpresa, otraEmpresa, condicion);
	}

	public String getNombreComparador(){
		return "Comparador por valor";
	}
}
