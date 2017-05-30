package model;

public abstract class CalcularIndicador {
	int getValor(Parametro parametro1, Parametro parametro2, Parametro parametro3, String operacion1, String operacion2) {
		return parametro1.getValor();
	}
}
