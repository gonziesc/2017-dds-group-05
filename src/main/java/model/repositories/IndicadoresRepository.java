package model.repositories;

import java.util.LinkedList;
import java.util.List;

import model.Cuenta;
import model.Indicador;
import model.Parametro;
import model.parametroCompuesto;
import model.parametroGeneral;

public class IndicadoresRepository {
	private List<Indicador> indicadores = new LinkedList<>();
	public Indicador getUnIdicadorConstante(){
		Parametro unaConstante = new Parametro();
		unaConstante.setValor(10);
		Indicador unIndicador = new Indicador(unaConstante, null, null);
		return unIndicador;
	}
	public Indicador getUnIdicadorConUnaConstanteYUnaCuenta(){
		Parametro unaConstante = new Parametro();
		unaConstante.setValor(10);
		Cuenta unaCuenta = Repositorios.cuentas.getUnaCuenta();
		Parametro parametroCuenta = new Parametro();
		parametroCuenta.setValor(unaCuenta.getValor());
		String operacion = "+";
		Indicador unIndicador = new Indicador(unaConstante, parametroCuenta, operacion);
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
		Indicador unIndicador = new Indicador(parametroCuenta, parametroOtraCuenta, operacion);
		return unIndicador;
	}
	public Indicador getUnIdicadorConDosCuentasYUnaConstante(){
		Parametro unaConstante = new Parametro();
		unaConstante.setValor(10);
		Cuenta otraCuenta = Repositorios.cuentas.getOtraCuenta();
		Cuenta unaCuenta = Repositorios.cuentas.getUnaCuenta();
		Parametro unParametroCuenta = new Parametro();
		unParametroCuenta.setValor(unaCuenta.getValor());
		Parametro otroParametroCuenta = new Parametro();
		otroParametroCuenta.setValor(otraCuenta.getValor());
		parametroCompuesto parametroCuenta = new parametroCompuesto();
		parametroCuenta.setParametro1(unParametroCuenta);
		parametroCuenta.setParametro2(otroParametroCuenta);
		parametroCuenta.setOperacion("+");
		Indicador unIndicador = new Indicador(parametroCuenta, unaConstante, "+");
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
		parametroCompuesto parametroTotal = new parametroCompuesto();
		parametroTotal.setParametro1(parametroOtraCuenta);
		parametroTotal.setParametro2(parametroTercerCuenta);
		String operacion = "+";
		parametroTotal.setOperacion(operacion);
		Indicador unIndicador = new Indicador(parametroTotal, parametroCuenta, operacion);
		return unIndicador;
	}
	public Indicador getUnIdicadorConOtroIndicador(){
		Parametro unaConstante = new Parametro();
		unaConstante.setValor(10);
		Indicador unIndicadorAux = new Indicador(unaConstante, null, null);
		Parametro parametroInicador = new Parametro();
		parametroInicador.setValor(unIndicadorAux.obtenerValor());
		Indicador unIndicador = new Indicador(parametroInicador, null, null);
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
		parametroCompuesto parametroTotal = new parametroCompuesto();
		parametroTotal.setParametro1(parametroInicador);
		parametroTotal.setParametro2(parametroInicadorOtro);
		String operacion = "+";
		parametroTotal.setOperacion(operacion);
		Indicador unIndicador = new Indicador(parametroTotal, unaConstante, operacion);
		return unIndicador;
	}
	public List<Indicador> all() {
		return indicadores;
	}

}
