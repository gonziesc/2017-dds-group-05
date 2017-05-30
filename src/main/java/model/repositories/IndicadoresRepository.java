package model.repositories;

import java.util.LinkedList;
import java.util.List;

import model.Cuenta;
import model.Indicador;
import model.Parametro;

public class IndicadoresRepository {
	private List<Indicador> indicadores = new LinkedList<>();
	public Indicador getUnIdicadorConstante(){
		Parametro unaConstante = new Parametro();
		unaConstante.setValor(10);
		Indicador unIndicador = new Indicador(unaConstante, null, null, null, null);
		return unIndicador;
	}
	public Indicador getUnIdicadorConUnaConstanteYUnaCuenta(){
		Parametro unaConstante = new Parametro();
		unaConstante.setValor(10);
		Cuenta unaCuenta = Repositorios.cuentas.getUnaCuenta();
		Parametro parametroCuenta = new Parametro();
		parametroCuenta.setValor(unaCuenta.getValor());
		String operacion = "+";
		Indicador unIndicador = new Indicador(unaConstante, parametroCuenta, null, operacion, null);
		return unIndicador;
	}
	public Indicador getUnIdicadorConDosCuentas(){
		Cuenta otraCuenta = Repositorios.cuentas.getOtraCuenta();
		Cuenta unaCuenta = Repositorios.cuentas.getUnaCuenta();
		String operacion = "+";
		Parametro parametroCuenta = new Parametro();
		parametroCuenta.setValor(unaCuenta.getValor());
		Parametro parametroOtraCuenta = new Parametro();
		parametroOtraCuenta.setValor(otraCuenta.getValor());
		Indicador unIndicador = new Indicador(parametroCuenta, parametroOtraCuenta, null, operacion, null);
		return unIndicador;
	}
	public Indicador getUnIdicadorConDosCuentasYUnaConstante(){
		Parametro unaConstante = new Parametro();
		unaConstante.setValor(10);
		Cuenta otraCuenta = Repositorios.cuentas.getOtraCuenta();
		Cuenta unaCuenta = Repositorios.cuentas.getUnaCuenta();
		Parametro parametroCuenta = new Parametro();
		parametroCuenta.setValor(unaCuenta.getValor());
		Parametro parametroOtraCuenta = new Parametro();
		parametroOtraCuenta.setValor(otraCuenta.getValor());
		String operacion = "+";
		Indicador unIndicador = new Indicador(parametroOtraCuenta, parametroCuenta, unaConstante, operacion, operacion);
		return unIndicador;
	}
	public Indicador getUnIdicadorConTresCuentas(){
		Cuenta tecerCuenta = Repositorios.cuentas.getOtraCuenta();
		Cuenta otraCuenta = Repositorios.cuentas.getUnaCuenta();
		Cuenta unaCuenta = Repositorios.cuentas.getUnaCuenta();
		Parametro parametroCuenta = new Parametro();
		parametroCuenta.setValor(unaCuenta.getValor());
		Parametro parametroOtraCuenta = new Parametro();
		parametroOtraCuenta.setValor(otraCuenta.getValor());
		Parametro parametroTercerCuenta = new Parametro();
		parametroTercerCuenta.setValor(tecerCuenta.getValor());
		String operacion = "+";
		Indicador unIndicador = new Indicador(parametroOtraCuenta, parametroCuenta, parametroTercerCuenta, operacion, operacion);
		return unIndicador;
	}
	public Indicador getUnIdicadorConOtroIndicador(){
		Parametro unaConstante = new Parametro();
		unaConstante.setValor(10);
		Indicador unIndicadorAux = new Indicador(unaConstante, null, null, null, null);
		Parametro parametroInicador = new Parametro();
		parametroInicador.setValor(unIndicadorAux.obtenerValor());
		Indicador unIndicador = new Indicador(parametroInicador, null, null, null, null);
		return unIndicador;
	}
	public Indicador getUnIdicadorConDosIndicadoresYUnaConstante(){
		Parametro unaConstante = new Parametro();
		unaConstante.setValor(10);
		Indicador unIndicadorAux = this.getUnIdicadorConstante();
		Parametro parametroInicador = new Parametro();
		parametroInicador.setValor(unIndicadorAux.obtenerValor());
		Indicador otroIndicadorAux = this.getUnIdicadorConTresCuentas();
		Parametro parametroInicadorOtro = new Parametro();
		parametroInicadorOtro.setValor(otroIndicadorAux.obtenerValor());
		String operacion = "+";
		Indicador unIndicador = new Indicador(parametroInicador, parametroInicadorOtro, unaConstante, operacion, operacion);
		return unIndicador;
	}
	public List<Indicador> all() {
		return indicadores;
	}

}
