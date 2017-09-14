package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.uqbar.commons.utils.Observable;

@Entity
@DiscriminatorValue(value = "ComparadorPromedio")
@Observable
public class ComparadorPromedio extends ComparadorFiltro{
	
	@Override
	public Boolean comparar(Empresa unaEmpresa, Indicador unIndicador, int anioDesde, int anioHasta) {
		int promedio = unaEmpresa
				.cuentasSegunTiempo(anioDesde, anioHasta).stream()
				.map(c -> cargarIndicador(c, unIndicador).getValor())
				.mapToInt(i -> i).sum()
				/ unaEmpresa.cuentasSegunTiempo(anioDesde, anioHasta)
						.size();
		return Operadores.compararOperacion(promedio, getValor(),getOperando());

	}

	@Override
	public String getNombreComparador(){
		return "Comparador promedio";
	}

}
