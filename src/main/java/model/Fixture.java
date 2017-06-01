package model;

import model.repositories.Repositorios;

public class Fixture {
	
	public static void initialize(){
		Cuenta freeCashFlow = new Cuenta();
		Cuenta fds = new Cuenta();
		Cuenta editba = new Cuenta();
		
		Repositorios.parametros.agregar("Indicador");
		Repositorios.parametros.agregar("Cuenta");
		Repositorios.parametros.agregar("Constante");
		
	}
}
