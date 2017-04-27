package model;

import java.io.IOException;
import java.util.Date;

import org.uqbar.commons.utils.Observable;

@Observable
public class Cuenta {
	private String nombre_cuenta;
	private int numero_cuenta;
	private int anio_cuenta;
	private double ganancia;
	private double gananciaNeta;
	private double intereses;
	private double impuestos;
	private double depreciacion;
	private double amortizacion;
	private double perdida;

	public void crearCuenta() throws IOException {
		Cuenta unaCuenta = new Cuenta();
		llenarCuenta(unaCuenta);
		CuentasService.deCuentaAJSON(unaCuenta);
	}

	public void llenarCuenta(Cuenta unaCuenta) {
		unaCuenta.setAmortizacion(amortizacion);
		unaCuenta.setAnio_cuenta(anio_cuenta);
		unaCuenta.setDepreciacion(depreciacion);
		unaCuenta.setGanancia(ganancia);
		unaCuenta.setGananciaNeta(gananciaNeta);
		unaCuenta.setImpuestos(impuestos);
		unaCuenta.setIntereses(intereses);
		unaCuenta.setNombre_cuenta(nombre_cuenta);
		unaCuenta.setNumero_cuenta(numero_cuenta);
		unaCuenta.setPerdida(perdida);
	}

	// getters and setters
	public String getNombre_cuenta() {
		return nombre_cuenta;
	}

	public void setNombre_cuenta(String nombre_cuenta) {
		this.nombre_cuenta = nombre_cuenta;
	}

	public int getNumero_cuenta() {
		return numero_cuenta;
	}

	public void setNumero_cuenta(int numero_cuenta) {
		this.numero_cuenta = numero_cuenta;
	}

	public int getAnio_cuenta() {
		return anio_cuenta;
	}

	public void setAnio_cuenta(int anio_cuenta) {
		this.anio_cuenta = anio_cuenta;
	}

	public double getGanancia() {
		return ganancia;
	}

	public void setGanancia(double ganancia) {
		this.ganancia = ganancia;
	}

	public double getGananciaNeta() {
		return gananciaNeta;
	}

	public void setGananciaNeta(double gananciaNeta) {
		this.gananciaNeta = gananciaNeta;
	}

	public double getIntereses() {
		return intereses;
	}

	public void setIntereses(double intereses) {
		this.intereses = intereses;
	}

	public double getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(double impuestos) {
		this.impuestos = impuestos;
	}

	public double getDepreciacion() {
		return depreciacion;
	}

	public void setDepreciacion(double depreciacion) {
		this.depreciacion = depreciacion;
	}

	public double getAmortizacion() {
		return amortizacion;
	}

	public void setAmortizacion(double amortizacion) {
		this.amortizacion = amortizacion;
	}

	public double getPerdida() {
		return perdida;
	}

	public void setPerdida(double perdida) {
		this.perdida = perdida;
	}

}
