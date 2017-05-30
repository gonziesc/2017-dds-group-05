package model;

public class cuentaTipoParametro extends Parametro{
	private String nombreCuenta;
	private int anioCuenta;
	private int valor;

	public Boolean perteneceA(int periodo){
		return this.anioCuenta == periodo;
	}


	public String getNombreCuenta() {
		return nombreCuenta;
	}


	public void setNombreCuenta(String nombreCuenta) {
		nombreCuenta = nombreCuenta;
	}


	public int getAnioCuenta() {
		return anioCuenta;
	}


	public void setAnioCuenta(int unAnioCuenta) {
		anioCuenta = unAnioCuenta;
	}


	public int getValor() {
		return valor;
	}
	public int obtenerValor() {
		return valor;
	}

	public void setValor(int unValor) {
		valor = unValor;
	}
}
