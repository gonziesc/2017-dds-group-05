package model;

public class Parametro {
	protected int valor;
	private String nombreCuenta;
	private int anioCuenta;
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
	public void setValor(int valor) {
		this.valor = valor;
	}
	public int obtenerValor() {
		return 0;
	}
	
}
