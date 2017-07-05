package model;

import org.uqbar.commons.utils.Observable;

@Observable
public class ComparadorPromedio extends Comparador{
	
	public Empresa calcularMetodologia(Empresa unaEmpresa, Empresa otraEmpresa, Indicador unIndicador, Indicador otroIndicador, int valor, String comparador, int periodoInicio, int periodoFin) {
		int promedio = unaEmpresa
				.cuentasSegunTiempo(periodoInicio, periodoFin).stream()
				.map(c -> cargarIndicador(c, unIndicador).getValor())
				.mapToInt(i -> i).sum()
				/ unaEmpresa.cuentasSegunTiempo(periodoInicio, periodoFin)
						.size();
		Boolean condicion = Operadores.compararOperacion(promedio, valor,
				comparador);
		return procesarRetorno(unaEmpresa, otraEmpresa, condicion);
	}

	public String getNombreComparador(){
		return "Comparador promedio";
	}

}
