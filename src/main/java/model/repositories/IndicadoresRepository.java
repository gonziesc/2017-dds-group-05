package model.repositories;

import java.util.LinkedList;
import java.util.List;

import model.Constante;
import model.Cuenta;
import model.Indicador;
import model.IndicadorTipoParametro;
import model.cuentaTipoParametro;

public class IndicadoresRepository {
	private List<Indicador> indicadores = new LinkedList<>();
	public Indicador getUnIdicadorConstante(){
		Constante unaConstante = new Constante();
		unaConstante.setValor(10);
		Indicador unIndicador = new Indicador(unaConstante, null, null, null, null);
		return unIndicador;
	}
	public IndicadorTipoParametro getUnIdicadorTipoParametroConstante(){
		Constante unaConstante = new Constante();
		unaConstante.setValor(10);
		IndicadorTipoParametro unIndicador = new IndicadorTipoParametro(unaConstante, null, null, null, null);
		return unIndicador;
	}
	public Indicador getUnIdicadorConUnaConstanteYUnaCuenta(){
		Constante unaConstante = new Constante();
		unaConstante.setValor(10);
		cuentaTipoParametro unaCuenta = Repositorios.cuentas.getUnaCuentaParametro();
		String operacion = "+";
		Indicador unIndicador = new Indicador(unaConstante, unaCuenta, null, operacion, null);
		return unIndicador;
	}
	public Indicador getUnIdicadorConDosCuentas(){
		cuentaTipoParametro otraCuenta = Repositorios.cuentas.getOtraCuentaParametro();
		cuentaTipoParametro unaCuenta = Repositorios.cuentas.getUnaCuentaParametro();
		String operacion = "+";
		Indicador unIndicador = new Indicador(otraCuenta, unaCuenta, null, operacion, null);
		return unIndicador;
	}
	public Indicador getUnIdicadorConDosCuentasYUnaConstante(){
		Constante unaConstante = new Constante();
		unaConstante.setValor(10);
		cuentaTipoParametro otraCuenta = Repositorios.cuentas.getOtraCuentaParametro();
		cuentaTipoParametro unaCuenta = Repositorios.cuentas.getUnaCuentaParametro();
		String operacion = "+";
		Indicador unIndicador = new Indicador(otraCuenta, unaCuenta, unaConstante, operacion, operacion);
		return unIndicador;
	}
	public Indicador getUnIdicadorConTresCuentas(){
		cuentaTipoParametro tecerCuenta = Repositorios.cuentas.getOtraCuentaParametro();
		cuentaTipoParametro unaCuenta = Repositorios.cuentas.getUnaCuentaParametro();
		cuentaTipoParametro otraCuenta =  Repositorios.cuentas.getOtraCuentaParametro();
		String operacion = "+";
		Indicador unIndicador = new Indicador(otraCuenta, unaCuenta, tecerCuenta, operacion, operacion);
		return unIndicador;
	}
	public IndicadorTipoParametro getUnIdicadorTipoParametroConTresCuentas(){
		cuentaTipoParametro tecerCuenta = Repositorios.cuentas.getOtraCuentaParametro();
		cuentaTipoParametro unaCuenta = Repositorios.cuentas.getUnaCuentaParametro();
		cuentaTipoParametro otraCuenta =  Repositorios.cuentas.getOtraCuentaParametro();
		String operacion = "+";
		IndicadorTipoParametro unIndicador = new IndicadorTipoParametro(otraCuenta, unaCuenta, tecerCuenta, operacion, operacion);
		return unIndicador;
	}
	public Indicador getUnIdicadorConOtroIndicador(){
		Constante unaConstante = new Constante();
		unaConstante.setValor(10);
		IndicadorTipoParametro unIndicadorAux = new IndicadorTipoParametro(unaConstante, null, null, null, null);
		Indicador unIndicador = new Indicador(unIndicadorAux, null, null, null, null);
		return unIndicador;
	}
	public Indicador getUnIdicadorConDosIndicadoresYUnaConstante(){
		Constante unaConstante = new Constante();
		unaConstante.setValor(10);
		IndicadorTipoParametro unIndicadorAux = this.getUnIdicadorTipoParametroConstante();
		IndicadorTipoParametro otroIndicadorAux = this.getUnIdicadorTipoParametroConTresCuentas();
		String operacion = "+";
		Indicador unIndicador = new Indicador(unIndicadorAux, otroIndicadorAux, unaConstante, operacion, operacion);
		return unIndicador;
	}
	public List<Indicador> all() {
		return indicadores;
	}

}
