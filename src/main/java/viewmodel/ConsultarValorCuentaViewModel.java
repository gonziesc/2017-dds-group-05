package viewmodel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.uqbar.commons.utils.Observable;

import com.google.gson.JsonIOException;

import model.CuentasService;
import model.Cuenta;

@Observable

public class ConsultarValorCuentaViewModel {
	private List<Cuenta> cuentas;
	private Cuenta unaCuenta = new Cuenta();
	private String nombre_cuenta;
	private int numero_cuenta;
	private String tipo_cuenta;
	
	public void obtenerCuenta(){
		cuentas = CuentasService.deJSONaCuenta();
	}
	//Getters & setters
	public String getNombre_cuenta() {
		return nombre_cuenta;
	}
	public List<Cuenta> getCuentas() {
		return cuentas;
	}
	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
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
	public String getTipo_cuenta() {
		return tipo_cuenta;
	}
	public void setTipo_cuenta(String tipo_cuenta) {
		this.tipo_cuenta = tipo_cuenta;
	}
	public Cuenta getUnaCuenta() {
		return unaCuenta;
	}
	public void setUnaCuenta(Cuenta unaCuenta) {
		this.unaCuenta = unaCuenta;
	}
	
	
}
