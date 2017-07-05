package model;

import org.uqbar.commons.utils.Observable;

@Observable
public class ComparadorUnoMayorQueOtro extends Comparador{
	
	public Empresa calcularMetodologia(Empresa unaEmpresa, Empresa otraEmpresa, Indicador unIndicador, Indicador otroIndicador, int valor, String comparador, int periodoInicio, int periodoFin) {
		otraEmpresa.getCuentas().stream()
				.forEach(c -> cargarIndicador(c, otroIndicador));
		unaEmpresa.getCuentas().stream()
				.forEach(c -> cargarIndicador(c, unIndicador));
		Boolean condicion = Operadores.compararOperacion(unIndicador.getValor(),
				otroIndicador.getValor(), comparador);
		return procesarRetorno(unaEmpresa, otraEmpresa, condicion);
	}
	@Override
	public String getNombreComparador(){
		return "Comparador uno mayor que otro";
	}

}
