package model;

import java.util.List;

public class Empresa {

	private List<Cuenta> cuentas;
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void agregarCuenta(Cuenta unaCuenta){
		cuentas.add(unaCuenta);
	}
	
	public List<Cuenta> cuentasSegunPeriodo(int periodo){
		List<Cuenta> cuentasEnPeriodo = (List<Cuenta>) cuentas.stream().filter(cuenta -> cuenta.perteneceA(periodo));
		return cuentasEnPeriodo;
	}
	
	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
	@Override
	public String toString() {
		return nombre;
	}
}
