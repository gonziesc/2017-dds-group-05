package model;

import java.util.List;

public class ComparadorUnoMayorQueOtroEnElTiempo extends Comparador{
	public Empresa calcularMetodologia(Empresa unaEmpresa, Empresa otraEmpresa, Indicador unIndicador, Indicador otroIndicador, int valor, String comparador, int periodoInicio, int periodoFin) {
		List<Cuenta> cuentasPeriodoOtraEmpresa = otraEmpresa
				.cuentasSegunTiempo(periodoInicio, periodoFin);
		Boolean condicion = unaEmpresa
				.cuentasSegunTiempo(periodoInicio, periodoFin)
				.stream()
				.allMatch(
						c -> cumpleConSuCuentaPareja(c,
								cuentasPeriodoOtraEmpresa, comparador, unIndicador, otroIndicador));
		return procesarRetorno(unaEmpresa, otraEmpresa, condicion);
	}
}
