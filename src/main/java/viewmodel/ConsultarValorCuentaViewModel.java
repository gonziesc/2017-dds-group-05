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

	public void obtenerCuenta() {
		try {
			cuentas = CuentasService.deJSONaCuenta();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Getters & setters
	public List<Cuenta> getCuentas() {
		return cuentas;
	}
}
