package model.repositories;

import model.Cuenta;
import model.cuentaTipoParametro;

public class CuentasRepository {
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
}
