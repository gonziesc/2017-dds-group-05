package model;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

@Observable
public class Empresa {

	private List<Cuenta> Cuentas;
	private String nombreEmpresa;


	public List<Cuenta> cuentasSegunPeriodo(int periodo){
		List<Cuenta> cuentasEnPeriodo = (List<Cuenta>) Cuentas.stream().filter(cuenta -> cuenta.perteneceA(periodo));
		return cuentasEnPeriodo;
	}
	
	public List<Cuenta> cuentasSegunTiempo(int periodoInicio, int periodoFin){
		List<Cuenta> cuentasEnPeriodo = Cuentas.stream()
				.filter(cuenta -> cuenta.getAnioCuenta() > periodoInicio && cuenta.getAnioCuenta() < periodoFin).collect(Collectors.toList());
		return cuentasEnPeriodo;
	}
	
	@Override
	public String toString() {
		return nombreEmpresa;
	}

	public List<Cuenta> getCuentas() {
		return Cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		Cuentas = cuentas;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombre) {
		nombreEmpresa = nombre;
	}
	
	public int aniosEmpresa(){
		final Comparator<Cuenta> comp = (p1, p2) -> Integer.compare( p1.getAnioCuenta(), p2.getAnioCuenta());
		return 2017 - Cuentas.stream().max(comp).get().getAnioCuenta();
	}
}
