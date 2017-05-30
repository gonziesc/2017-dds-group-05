package model.repositories;

import java.util.LinkedList;
import java.util.List;

import model.Cuenta;
import model.cuentaTipoParametro;

public class CuentasRepository {
	private List<Cuenta> cuentas = new LinkedList<>();
	
	Cuenta getUnaCuenta(){
		Cuenta unaCuenta = new Cuenta();
		unaCuenta.setValor(1000);
		return unaCuenta;
	}
	Cuenta getOtraCuenta(){
		Cuenta otraCuenta = new Cuenta();
		otraCuenta.setValor(2000);
		return otraCuenta;
	}
	cuentaTipoParametro getUnaCuentaParametro(){
		cuentaTipoParametro unaCuenta = new cuentaTipoParametro();
		unaCuenta.setValor(1000);
		return unaCuenta;
	}
	cuentaTipoParametro getOtraCuentaParametro(){
		cuentaTipoParametro otraCuenta = new cuentaTipoParametro();
		otraCuenta.setValor(2000);
		return otraCuenta;
	}
	public List<Cuenta> all() {
		return cuentas;
	}
}
