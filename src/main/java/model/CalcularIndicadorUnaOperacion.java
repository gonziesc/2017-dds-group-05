package model;

public class CalcularIndicadorUnaOperacion extends CalcularIndicador {
	int getValor(Parametro parametro1, Parametro parametro2, Parametro parametro3, String operacion1, String operacion2) {
		return Operadores.resolverOperacion(parametro1.getValor(),
				parametro2.getValor(), operacion1);
	}
}
