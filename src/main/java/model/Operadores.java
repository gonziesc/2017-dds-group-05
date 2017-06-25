package model;

public class Operadores {
	static int resolverOperacion(int parametro1, int parametro2, String operacion){
		switch (operacion){
		case "+": return parametro1 + parametro2;
		case "-": return parametro1 - parametro2;
		case "*": return parametro1 * parametro2;
		case "/": return parametro1 / parametro2;
		default: return 0;
		}
	}
	static Boolean compararOperacion(int parametro1, int parametro2, String operacion){
		switch (operacion){
		case ">": return parametro1 > parametro2;
		case "<": return parametro1 < parametro2;
		default: return false;
		}
	}
}
