package model;

import org.uqbar.commons.utils.Observable;

@Observable
public class ComparadorValorTiempo extends Comparador{
	
	public Empresa calcularMetodologia(Empresa unaEmpresa, Empresa otraEmpresa, Indicador unIndicador, Indicador otroIndicador, int valor, String comparador, int periodoInicio, int periodoFin) {
		Boolean condicion = unaEmpresa
				.cuentasSegunTiempo(periodoInicio, periodoFin)
				.stream()
				.map(c -> cargarIndicador(c, unIndicador))
				.allMatch(
						i -> Operadores.compararOperacion(i.getValor(),
								valor, comparador));
		return procesarRetorno(unaEmpresa, otraEmpresa, condicion);
	}
	
	public String getNombreComparador(){
		return "Comparador por valor en tiempo";
	}
}
