package model;

public class CalcularIndicadorDosOperaciones extends CalcularIndicador {
	int getValor(Parametro parametro1, Parametro parametro2, Parametro parametro3, String operacion1, String operacion2) {
		int valor = Operadores.resolverOperacion(parametro1.obtenerValor(),
				parametro2.obtenerValor(), operacion1);
		return Operadores.resolverOperacion(valor,
				parametro3.obtenerValor(), operacion2);
	}
}
