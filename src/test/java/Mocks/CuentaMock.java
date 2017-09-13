package Mocks;

import model.Cuenta;

public class CuentaMock {

	public Cuenta getUnaCuenta() {
		Cuenta unaCuenta = new Cuenta();
		unaCuenta.setValor(1000);
		return unaCuenta;
	}

	public Cuenta getOtraCuenta() {
		Cuenta otraCuenta = new Cuenta();
		otraCuenta.setValor(2000);
		otraCuenta.setNombreCuenta("FCF");
		return otraCuenta;

	}

}
