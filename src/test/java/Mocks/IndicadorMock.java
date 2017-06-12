package Mocks;


import model.Cuenta;
import model.Indicador;
import model.Parametro;
import model.parametroCompuesto;
import Mocks.CuentaMock;;

public class IndicadorMock {
	CuentaMock cuentaMock = new CuentaMock();
	Cuenta unaCuenta = cuentaMock.getUnaCuenta();
	Cuenta otraCuenta = cuentaMock.getOtraCuenta();
	
	public Indicador getUnIdicadorConstante(){
		Parametro unaConstante = new Parametro();
		unaConstante.setValor(10);
		Indicador unIndicador = new Indicador(unaConstante, null, null);
		return unIndicador;
	}
	public Indicador getUnIdicadorConUnaConstanteYUnaCuenta(){
		Parametro unaConstante = new Parametro();
		unaConstante.setValor(10);
		Parametro parametroCuenta = new Parametro();
		parametroCuenta.setValor(unaCuenta.getValor());
		String operacion = "+";
		Indicador unIndicador = new Indicador(unaConstante, parametroCuenta, operacion);
		return unIndicador;
	}
	public Indicador getUnIdicadorConDosCuentas(){
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
		Cuenta tecerCuenta = cuentaMock.getUnaCuenta();
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

}
