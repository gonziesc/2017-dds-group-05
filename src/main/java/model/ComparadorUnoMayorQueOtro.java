package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.uqbar.commons.utils.Observable;

@Entity
@DiscriminatorValue(value = "ComparadorUno>QueOtro")
@Observable
public class ComparadorUnoMayorQueOtro extends ComparadorOrden{
	
	@Override
	public Empresa comparar(Empresa unaEmpresa, Empresa otraEmpresa, Indicador unIndicador, int fechaDesde, int fechaHasta) {
		int valorUnaEmpresa;
		int valorOtraEmpresa;
		otraEmpresa.getCuentas().stream()
				.forEach(c -> cargarIndicador(c, unIndicador));
		valorOtraEmpresa = unIndicador.getValor();
		unaEmpresa.getCuentas().stream()
				.forEach(c -> cargarIndicador(c, unIndicador));
		valorUnaEmpresa = unIndicador.getValor();
		Boolean condicion = Operadores.compararOperacion(valorUnaEmpresa,
				valorOtraEmpresa, getOperando());
		return this.procesarRetorno(unaEmpresa, otraEmpresa, condicion);
	}
	
	@Override
	public String getNombreComparador(){
		return "Comparador uno mayor que otro";
	}

}
