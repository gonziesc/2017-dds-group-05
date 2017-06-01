package viewmodel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

import Services.EmpresasService;
import Services.IndicadoresService;
import builder.BuilderIndicador;
import model.Cuenta;
import model.Empresa;
import model.Indicador;
import model.Parametro;
import model.repositories.Repositorios;

@Observable
public class Parametro3ViewModel {

	private List<Indicador> indicadores;
	private Indicador tercerIndicador;
	private BuilderIndicador builderIndicador;
	private String nombreIndicador;
	private List<Cuenta> cuentas;
	private Cuenta cuentaSeleccionada;
	private Integer valorParametroConstante;
	private List<String> tipoParametros;
	private String tipoSeleccionado = "Indicador";
	private List<Empresa> empresas;
	private Parametro parametro = new Parametro();
	
	public Parametro3ViewModel(BuilderIndicador builder){
		indicadores = Repositorios.indicadores.all();
		cuentas = Repositorios.cuentas.all();
		tipoParametros = Repositorios.parametros.all();
		this.builderIndicador = builder;
	}
	public void obtenerCuentas(){
		this.obtenerEmpresas();
		cuentas = empresas.stream().flatMap(unaEmpresa -> unaEmpresa.getCuentas().stream()).collect(Collectors.toList());
	}
	public void obtenerEmpresas(){
		try {
			empresas = EmpresasService.obtenerEmpresasDeServicioExterno();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void ingresarParametro3(){
		try{
		if(this.getTipoSeleccionado() == "Indicador"){
			parametro.setValor(tercerIndicador.obtenerValor());
			parametro.setNombre(tercerIndicador.getNombre());
		}
		else if(this.getTipoSeleccionado() == "Cuenta"){
			parametro.setValor(cuentaSeleccionada.getValor());	
			parametro.setNombre(cuentaSeleccionada.getNombreCuenta());
		}
		else if (this.getTipoSeleccionado() == "Constante"){
			parametro.setValor(valorParametroConstante);
		}
		builderIndicador.setParametro3(parametro);
		} catch (NullPointerException e) {
			throw new NullPointerException ("mal ingresado!");
		}
		builderIndicador.setNombre(nombreIndicador);
	}	
	
	public void crearIndicador() {
		try {
			IndicadoresService.guardarIndicadoresEnServicioExterno(builderIndicador.build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void obtenerIndicadores() {
		try {
			setIndicadores(IndicadoresService.obtenerInicadoresDeServicioExterno());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Indicador getTercerIndicador() {
		return tercerIndicador;
	}
	
	public void setTercerIndicador(Indicador tercerIndicador) {
		this.tercerIndicador = tercerIndicador;
	}
	public BuilderIndicador getBuilderIndicador() {
		return builderIndicador;
	}

	public void setBuilderIndicador(BuilderIndicador builderIndicador) {
		this.builderIndicador = builderIndicador;
	}

	public List<Indicador> getIndicadores() {
		return indicadores;
	}

	public void setIndicadores(List<Indicador> indicadores) {
		this.indicadores = indicadores;
	}

	public String getNombreIndicador() {
		return nombreIndicador;
	}

	public void setNombreIndicador(String nombreIndicador) {
		this.nombreIndicador = nombreIndicador;
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public Cuenta getCuentaSeleccionada() {
		return cuentaSeleccionada;
	}

	public void setCuentaSeleccionada(Cuenta cuentaSeleccionada) {
		this.cuentaSeleccionada = cuentaSeleccionada;
	}

	public Parametro getParametro() {
		return parametro;
	}

	public void setParametro(Parametro parametro) {
		this.parametro = parametro;
	}

	public Integer getValorParametroConstante() {
		return valorParametroConstante;
	}

	public void setValorParametroConstante(Integer valorParametroConstante) {
		this.valorParametroConstante = valorParametroConstante;
	}

	public List<String> getTipoParametros() {
		return tipoParametros;
	}

	public void setTipoParametros(List<String> tipoParametros) {
		this.tipoParametros = tipoParametros;
	}

	public String getTipoSeleccionado() {
		return tipoSeleccionado;
	}

	public void setTipoSeleccionado(String tipoSeleccionado) {
		this.tipoSeleccionado = tipoSeleccionado;
	}
}
