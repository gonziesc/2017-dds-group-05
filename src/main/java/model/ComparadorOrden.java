package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ComparadorOrden extends Comparador{
		
	public abstract Empresa comparar(Empresa unaEmpresa, Empresa otraEmpresa, Indicador unIndicador);
	
	protected Empresa procesarRetorno(Empresa unaEmpresa2, Empresa otraEmpresa2, Boolean condicion) {
		if (condicion)
			return unaEmpresa2;
		else
			return otraEmpresa2;
	}
	
	protected Boolean cumpleConSuCuentaPareja(Cuenta cuenta,
			List<Cuenta> cuentasPeriodoOtraEmpresa, String comparador2, Indicador unIndicador) {
		return cuentasPeriodoOtraEmpresa.stream().allMatch(
				c -> cumpleCuentaPareja(cuenta, c, comparador2, unIndicador));
	}

	private Boolean cumpleCuentaPareja(Cuenta cuenta, Cuenta otraCuenta,
			String comparador2, Indicador unIndicador) {
		if (cuenta.getAnioCuenta() == otraCuenta.getAnioCuenta()) {
			return Operadores.compararOperacion(
					cargarIndicador(cuenta, unIndicador).getValor(),
					cargarIndicador(otraCuenta, unIndicador).getValor(),
					comparador2);
		}
		return true;
	}

	protected Indicador cargarIndicador(Cuenta c, Indicador indicador) {
		indicador.setValorCuenta(c);
		return indicador;
	}
	
	
}
