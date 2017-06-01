package viewmodel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.uqbar.commons.utils.Observable;

import Services.EmpresasService;
import Services.IndicadoresService;
import Services.EmpresasService;

import com.google.gson.JsonIOException;

import model.Empresa;
import model.Indicador;
import model.repositories.Repositorios;
import model.Cuenta;

@Observable
public class ConsultarValorCuentaViewModel {
	private List<Empresa> empresas;
	private Empresa empresaSeleccionada = null;
	private List<Cuenta> cuentasEmpresa;
	private List<Indicador> indicadores;
	
	/*public ConsultarValorCuentaViewModel(){
		this.empresas = Repositorios.empresas.all();
	}*/
	
	public void obtenerIndicadores(){
		try {
			indicadores = IndicadoresService.obtenerInicadoresDeServicioExterno();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void obtenerEmpresas() {
		try {
			empresas = EmpresasService.obtenerEmpresasDeServicioExterno();
		} catch (FileNotFoundException e) {
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

	public List<Indicador> getIndicadores() {
		return indicadores;
	}

	public void setIndicadores(List<Indicador> indicadores) {
		this.indicadores = indicadores;
	}

	
	
}
