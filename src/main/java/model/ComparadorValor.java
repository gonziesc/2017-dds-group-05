package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.uqbar.commons.utils.Observable;

@Entity
@DiscriminatorValue(value = "ComparadorValor")
@Observable
public class ComparadorValor extends ComparadorFiltro{

	@Override
	public Boolean comparar(Empresa unaEmpresa, Indicador unIndicador, int anioDesde, int anioHasta) {
		unaEmpresa.getCuentas().stream().forEach(c -> cargarIndicador(c, unIndicador));
		return Operadores.compararOperacion(unIndicador.getValor(), getValor(), this.getOperando());

	}

	@Override
	public String getNombreComparador() {
		return "Comparador por valor";
	}
}
