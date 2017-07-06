package viewmodel;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

import Services.EmpresasService;
import Services.IndicadoresService;
import model.Empresa;
import model.Indicador;
import model.Cuenta;

@Observable
public class ConsultarValorCuentaViewModel {
	private List<Empresa> empresas;
	private Empresa empresaSeleccionada = null;
	private List<Cuenta> cuentasEmpresa;
	private List<Indicador> indicadores;
	
	
	public void obtenerIndicadores(){
		try {
			indicadores = IndicadoresService.obtenerInicadoresDeServicioExterno();
			indicadores.stream().forEach(i -> this.procesarIndicador(i));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	private Object procesarIndicador(Indicador indicador) {
		cuentasEmpresa.stream().forEach(c -> cargarIndicador(c, indicador));
		indicadores.stream().forEach(i -> cargarIndicador(i, indicador));
		indicador.obtenerValor();
		return indicador;
	}
	private Object cargarIndicador(Indicador i, Indicador indicador) {
		//if(indicador.necesitaSetearIndicador(i)){
			indicador.setValorIndicador(i);
		//}
		return indicador;
	}
	private Object cargarIndicador(Cuenta c, Indicador indicador) {
		//if(indicador.necesitaSetearCuenta(c)){
			indicador.setValorCuenta(c);
		//}
		return indicador;
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
