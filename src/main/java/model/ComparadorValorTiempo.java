package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.uqbar.commons.utils.Observable;

@Entity
@DiscriminatorValue(value = "ComparadorValorTiempo")
@Observable
public class ComparadorValorTiempo extends ComparadorOrden{
	
	@Override
	public Empresa comparar(Empresa unaEmpresa, Empresa otraEmpresa, Indicador unIndicador) {
		Boolean condicion = unaEmpresa
				.cuentasSegunTiempo(getPeriodoInicio(), getPeriodoFin())
				.stream()
				.map(c -> cargarIndicador(c, unIndicador))
				.allMatch(
						i -> Operadores.compararOperacion(i.getValor(),
								getValor(), getOperando()));
		return this.procesarRetorno(unaEmpresa, otraEmpresa, condicion);
	}
	
	@Override
	public String getNombreComparador(){
		return "Comparador por valor en tiempo";
	}
}
