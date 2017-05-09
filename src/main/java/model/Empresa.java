package model;

import java.util.List;

public class Empresa {

	private List<Cuenta> Cuentas;
	private String Nombre;


	public List<Cuenta> cuentasSegunPeriodo(int periodo){
		List<Cuenta> cuentasEnPeriodo = (List<Cuenta>) Cuentas.stream().filter(cuenta -> cuenta.perteneceA(periodo));
		return cuentasEnPeriodo;
	}
	
	@Override
	public String toString() {
		return Nombre;
	}

	public List<Cuenta> getCuentas() {
		return Cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		Cuentas = cuentas;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}
}
