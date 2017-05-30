package model;

import org.uqbar.commons.utils.Observable;

@Observable
public class Indicador{
	private CalcularIndicador calculador = new CalcularIndicadorConstante();
	private Parametro parametro1;
	private Parametro parametro2;
	private Parametro parametro3;
	private String operacion1;
	private String operacion2;
	private String nombre;
	public Indicador(Parametro unParametro1, Parametro unParametro2, Parametro unParametro3, String unaOperacion1, String unaOperacion2){
		parametro1 = unParametro1;
		parametro2 = unParametro2;
		parametro3 = unParametro3;
		operacion1 = unaOperacion1;
		operacion2 = unaOperacion2;
		this.definirCalculador();
	}
	public int obtenerValor(){
		this.definirCalculador();
		return calculador.getValor(parametro1, parametro2, parametro3, operacion1, operacion2);
	}
	public Parametro getParametro1() {
		return parametro1;
	}
	public void setParametro1(Parametro parametro1) {
		this.parametro1 = parametro1;
	}
	public Parametro getParametro2() {
		return parametro2;
	}
	public void setParametro2(Parametro parametro2) {
		this.parametro2 = parametro2;
	}
	public String getOperacion1() {
		return operacion1;
	}
	public void setOperacion1(String operacion1) {
		this.operacion1 = operacion1;
	}
	public String getOperacion2() {
		return operacion2;
	}
	public void setOperacion2(String operacion2) {
		this.operacion2 = operacion2;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Parametro getParametro3() {
		return parametro3;
	}
	public void setParametro3(Parametro parametro3) {
		this.parametro3 = parametro3;
	}
	public void definirCalculador(){
		if(parametro2 != null && operacion2 == null){
			calculador = new CalcularIndicadorUnaOperacion();
		} else if (parametro3 != null && operacion2 != null) {
			calculador = new CalcularIndicadorDosOperaciones();
		}
	}
	public void setValorCuenta(Cuenta cuenta) {
		if(parametro1.getNombre() == cuenta.getNombreCuenta()){
			parametro1.setValor(cuenta.getValor());
		} else if(parametro2.getNombre() == cuenta.getNombreCuenta()){
			parametro2.setValor(cuenta.getValor());
		} else if(parametro3.getNombre() == cuenta.getNombreCuenta()){
			parametro3.setValor(cuenta.getValor());
		}
	}
	
}
