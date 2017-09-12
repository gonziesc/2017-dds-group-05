package model;

import org.uqbar.commons.utils.Observable;

@Observable
public class ComparadorPromedio extends ComparadorOrden{
	
	@Override
	public Empresa comparar(Empresa unaEmpresa, Empresa otraEmpresa, Indicador unIndicador) {
		int promedio = unaEmpresa
				.cuentasSegunTiempo(getPeriodoInicio(), getPeriodoFin()).stream()
				.map(c -> cargarIndicador(c, unIndicador).getValor())
				.mapToInt(i -> i).sum()
				/ unaEmpresa.cuentasSegunTiempo(getPeriodoInicio(), getPeriodoFin())
						.size();
		Boolean condicion = Operadores.compararOperacion(promedio, getValor(),getOperando());
		return this.procesarRetorno(unaEmpresa, otraEmpresa, condicion);
	}

	@Override
	public String getNombreComparador(){
		return "Comparador promedio";
	}

}
