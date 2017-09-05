package model;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Observable
public abstract class Comparador {
	private String nombreComparador;

	public Empresa calcularMetodologia(Empresa unaEmpresa, Empresa otraEmpresa, Indicador unIndicador, Indicador otroIndicador, int valor, String comparador, int periodoInicio, int periodoFin) {
		return procesarRetorno(unaEmpresa, otraEmpresa, false);
	}
	
	protected Boolean cumpleConSuCuentaPareja(Cuenta cuenta,
			List<Cuenta> cuentasPeriodoOtraEmpresa, String comparador2, Indicador unIndicador, Indicador otroIndicador) {
		return cuentasPeriodoOtraEmpresa.stream().allMatch(
				c -> cumpleCuentaPareja(cuenta, c, comparador2, unIndicador, otroIndicador));
	}

	private Boolean cumpleCuentaPareja(Cuenta cuenta, Cuenta otraCuenta,
			String comparador2, Indicador unIndicador, Indicador otroIndicador) {
		if (cuenta.getAnioCuenta() == otraCuenta.getAnioCuenta()) {
			return Operadores.compararOperacion(
					cargarIndicador(cuenta, unIndicador).getValor(),
					cargarIndicador(otraCuenta, otroIndicador).getValor(),
					comparador2);
		}
		return true;
	}

	protected Empresa procesarRetorno(Empresa unaEmpresa2, Empresa otraEmpresa2,
			Boolean condicion) {
		if (otraEmpresa2 == null) {
			if (condicion)
				return unaEmpresa2;
		} else {
			if (condicion)
				return unaEmpresa2;
			else
				return otraEmpresa2;
		}
		return null;
	}

	protected Indicador cargarIndicador(Cuenta c, Indicador indicador) {
		indicador.setValorCuenta(c);
		return indicador;
	}
	
	public String getNombreComparador() {
		return nombreComparador;
	}

}
