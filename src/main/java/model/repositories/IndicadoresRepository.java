package model.repositories;

import model.Constante;
import model.Cuenta;
import model.Indicador;

public class IndicadoresRepository {
	public Indicador getUnIdicadorConstante(){
		Constante unaConstante = new Constante();
		unaConstante.setValor(10);
		Indicador unIndicador = new Indicador(unaConstante, null, null, null, null);
		return unIndicador;
	}
	public Indicador getUnIdicadorConUnaConstanteYUnaCuenta(){
		Constante unaConstante = new Constante();
		unaConstante.setValor(10);
		Cuenta unaCuenta = Repositorios.cuentas.getUnaCuenta();
		String operacion = "+";
		Indicador unIndicador = new Indicador(unaConstante, unaCuenta, null, operacion, null);
		return unIndicador;
	}
	public Indicador getUnIdicadorConDosCuentas(){
		Cuenta otraCuenta = Repositorios.cuentas.getOtraCuenta();
		Cuenta unaCuenta = Repositorios.cuentas.getUnaCuenta();
		String operacion = "+";
		Indicador unIndicador = new Indicador(otraCuenta, unaCuenta, null, operacion, null);
		return unIndicador;
	}
	public Indicador getUnIdicadorConDosCuentasYUnaConstante(){
		Constante unaConstante = new Constante();
		unaConstante.setValor(10);
		Cuenta otraCuenta = Repositorios.cuentas.getOtraCuenta();
		Cuenta unaCuenta = Repositorios.cuentas.getUnaCuenta();
		String operacion = "+";
		Indicador unIndicador = new Indicador(otraCuenta, unaCuenta, unaConstante, operacion, operacion);
		return unIndicador;
	}
	public Indicador getUnIdicadorConTresCuentas(){
		Cuenta tecerCuenta = Repositorios.cuentas.getUnaCuenta();
		Cuenta otraCuenta = Repositorios.cuentas.getOtraCuenta();
		Cuenta unaCuenta = Repositorios.cuentas.getUnaCuenta();
		String operacion = "+";
		Indicador unIndicador = new Indicador(otraCuenta, unaCuenta, tecerCuenta, operacion, operacion);
		return unIndicador;
	}
}
