package model;

import org.uqbar.commons.utils.Observable;

@Observable
public class Parametro {
	protected CalcularIndicador calculador = new CalcularIndicadorConstante();
	protected int valor;
	private String nombreCuenta;
	private int anioCuenta;
	protected Parametro parametro1;
	protected Parametro parametro2;
	protected Parametro parametro3;
	protected String operacion1;
	protected String operacion2;
	protected String nombre;
	
	
	public String getNombreCuenta() {
		return nombreCuenta;
	}
	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}
	public int getAnioCuenta() {
		return anioCuenta;
	}
	public void setAnioCuenta(int anioCuenta) {
		this.anioCuenta = anioCuenta;
	}
	public int getValor() {
		return valor;
	}
	public int obtenerValor() {
		if(parametro1 == null){
			return valor;
		} else {
			this.definirCalculador();
			return calculador.getValor(parametro1, parametro2, parametro3, operacion1, operacion2);
		}
		
	}
	public void setValor(int valor) {
		this.valor = valor;
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
	
}
