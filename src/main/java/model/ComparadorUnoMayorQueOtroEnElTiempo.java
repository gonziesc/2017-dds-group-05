package model;

import java.util.List;

import org.uqbar.commons.utils.Observable;

@Observable
public class ComparadorUnoMayorQueOtroEnElTiempo extends ComparadorOrden{
	
	@Override
	public Empresa comparar(Empresa unaEmpresa, Empresa otraEmpresa, Indicador unIndicador) {
		List<Cuenta> cuentasPeriodoOtraEmpresa = otraEmpresa
				.cuentasSegunTiempo(getPeriodoInicio(), getPeriodoFin());
		Boolean condicion = unaEmpresa
				.cuentasSegunTiempo(getPeriodoInicio(), getPeriodoFin())
				.stream()
				.allMatch(
						c -> cumpleConSuCuentaPareja(c,
								cuentasPeriodoOtraEmpresa, getOperando(), unIndicador));
		return this.procesarRetorno(unaEmpresa, otraEmpresa, condicion);
	}

	@Override
	public String getNombreComparador(){
		return "Comparador uno mayor que otro en el tiempo";
	}

}
