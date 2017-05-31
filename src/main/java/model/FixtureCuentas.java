package model;

import model.repositories.Repositorios;

public class FixtureCuentas {
	
	public static void initialize(){
		Cuenta freeCashFlow = new Cuenta();
		Cuenta fds = new Cuenta();
		Cuenta editba = new Cuenta();
		
		freeCashFlow.setNombreCuenta("Free Cash Flow");
		Repositorios.cuentas.agregar(freeCashFlow);
		fds.setNombreCuenta("FDS");
		Repositorios.cuentas.agregar(fds);
		editba.setNombreCuenta("EDITBA");
		Repositorios.cuentas.agregar(editba);
	}
}
