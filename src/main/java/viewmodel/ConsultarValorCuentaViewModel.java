package viewmodel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.uqbar.commons.utils.Observable;

import com.google.gson.JsonIOException;

import model.CuentasService;
import model.Empresa;
import model.repositories.Repositorios;
import model.Cuenta;

@Observable
public class ConsultarValorCuentaViewModel {
	private List<Empresa> empresas;
	private Empresa empresaSeleccionada;
	private List<Cuenta> cuentasEmpresa;
	
	public ConsultarValorCuentaViewModel(){
		this.empresas = Repositorios.empresas.all();
	}

	public void obtenerEmpresas() {
		try {
			empresas = CuentasService.deJSONaCuenta();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void obtenerCuentasEmpresa(){
		setCuentasEmpresa(empresaSeleccionada.getCuentas());
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public Empresa getEmpresaSeleccionada() {
		return empresaSeleccionada;
	}

	public void setEmpresaSeleccionada(Empresa empresaSeleccionada) {
		this.empresaSeleccionada = empresaSeleccionada;
	}

	public List<Cuenta> getCuentasEmpresa() {
		return cuentasEmpresa;
	}

	public void setCuentasEmpresa(List<Cuenta> cuentasEmpresa) {
		this.cuentasEmpresa = cuentasEmpresa;
	}

	
	
}
