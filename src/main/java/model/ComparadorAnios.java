package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "ComparadorAnios")
public class ComparadorAnios extends ComparadorFiltro{
	
	@Override
	public Boolean comparar(Empresa unaEmpresa, Indicador unIndicador, int anioDesde, int anioHasta) {
		return Operadores.compararOperacion(unaEmpresa.aniosEmpresa(),
				getValor(), getOperando());
	}

	@Override
	public String getNombreComparador(){
		return "Comparador por anios";
	}

}
