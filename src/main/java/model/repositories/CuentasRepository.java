package model.repositories;

import model.Cuenta;

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
}
