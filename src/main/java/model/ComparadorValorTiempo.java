package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.uqbar.commons.utils.Observable;

@Entity
@DiscriminatorValue(value = "ComparadorValorTiempo")
@Observable
public class ComparadorValorTiempo extends ComparadorFiltro{
	
	@Override
	public Boolean comparar(Empresa unaEmpresa, Indicador unIndicador, int anioDesde, int anioHasta) {
		
		return unaEmpresa.cuentasSegunTiempo(anioDesde, anioHasta).stream().map(c -> cargarIndicador(c, unIndicador)).allMatch(
						i -> Operadores.compararOperacion(i.getValor(),
								getValor(), getOperando()));
		
	}
	
	@Override
	public String getNombreComparador(){
		return "Comparador por valor en tiempo";
	}
}
