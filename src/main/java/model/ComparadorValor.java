package model;

import org.uqbar.commons.utils.Observable;

@Observable
public class ComparadorValor extends ComparadorOrden {

	@Override
	public Empresa comparar(Empresa unaEmpresa, Empresa otraEmpresa, Indicador unIndicador) {
		unaEmpresa.getCuentas().stream().forEach(c -> cargarIndicador(c, unIndicador));
		Boolean condicion = Operadores.compararOperacion(unIndicador.getValor(), this.getValor(), this.getOperando());
		return procesarRetorno(unaEmpresa, otraEmpresa, condicion);
	}

	@Override
	public String getNombreComparador() {
		return "Comparador por valor";
	}
}
