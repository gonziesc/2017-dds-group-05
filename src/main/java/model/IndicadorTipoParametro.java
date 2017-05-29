package model;

import org.uqbar.commons.utils.Observable;

@Observable
public class IndicadorTipoParametro extends Parametro{
	public IndicadorTipoParametro(Parametro unParametro1, Parametro unParametro2, Parametro unParametro3, String unaOperacion1, String unaOperacion2){
		parametro1 = unParametro1;
		parametro2 = unParametro2;
		parametro3 = unParametro3;
		operacion1 = unaOperacion1;
		operacion2 = unaOperacion2;
		this.definirCalculador();
	}
	public int obtenerValor(){
		return calculador.getValor(parametro1, parametro2, parametro3, operacion1, operacion2);
	}
	public void definirCalculador(){
		if(parametro2 != null && operacion2 == null){
			calculador = new CalcularIndicadorUnaOperacion();
		} else if (parametro3 != null && operacion2 != null) {
			calculador = new CalcularIndicadorDosOperaciones();
		}
	}
	
}