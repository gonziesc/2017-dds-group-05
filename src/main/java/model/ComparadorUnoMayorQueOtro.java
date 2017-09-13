package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.uqbar.commons.utils.Observable;

@Entity
@DiscriminatorValue(value = "ComparadorUno>QueOtro")
@Observable
public class ComparadorUnoMayorQueOtro extends ComparadorOrden{
	
	@Override
	public Empresa comparar(Empresa unaEmpresa, Empresa otraEmpresa, Indicador unIndicador) {
		otraEmpresa.getCuentas().stream()
				.forEach(c -> cargarIndicador(c, unIndicador));
		unaEmpresa.getCuentas().stream()
				.forEach(c -> cargarIndicador(c, unIndicador));
		Boolean condicion = Operadores.compararOperacion(unIndicador.getValor(),
				unIndicador.getValor(), getOperando());
		return this.procesarRetorno(unaEmpresa, otraEmpresa, condicion);
	}
	
	@Override
	public String getNombreComparador(){
		return "Comparador uno mayor que otro";
	}

}
