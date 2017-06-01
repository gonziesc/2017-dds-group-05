package viewmodel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import Services.EmpresasService;
import Services.IndicadoresService;
import builder.BuilderIndicador;
import model.Cuenta;
import model.Empresa;
import model.Indicador;
import model.Parametro;
import model.repositories.Repositorios;

abstract class ParametroViewModel {
	private List<Indicador> indicadores;
	private Indicador indicadorSeleccionado;
	private BuilderIndicador builderIndicador;
	private List<Cuenta> cuentas;
	private Cuenta cuentaSeleccionada;
	private List<String> tipoParametros;
	private String tipoSeleccionado = "Indicador";
	private Integer valorParametroConstante;
	private List<Empresa> empresas;
	private Parametro parametro = new Parametro();
	private String nombreIndicador;
	
	
	public ParametroViewModel(BuilderIndicador builder){
		indicadores = Repositorios.indicadores.all();
		cuentas = Repositorios.cuentas.all();
		tipoParametros = Repositorios.parametros.all();
		builderIndicador = builder;
	}

	public void obtenerIndicadores() {
		try {
			indicadores = IndicadoresService.obtenerInicadoresDeServicioExterno();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void ingresarIndicador() {
		try {
			this.ingresarParametro();
			IndicadoresService.guardarIndicadoresEnServicioExterno(builderIndicador.build());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void obtenerEmpresas(){
		try {
			empresas = EmpresasService.obtenerEmpresasDeServicioExterno();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void obtenerCuentas(){
		this.obtenerEmpresas();
		cuentas = empresas.stream().flatMap(unaEmpresa -> unaEmpresa.getCuentas().stream()).collect(Collectors.toList());
	}
	
	public void ingresarParametro() {
		//this.setearValorParametro();	
		switch(this.getTipoSeleccionado()){
		
		case "Indicador":
			parametro.setValor(indicadorSeleccionado.obtenerValor());
			parametro.setNombre(indicadorSeleccionado.getNombre());
			break;
		
		case "Cuenta":
			parametro.setValor(cuentaSeleccionada.getValor());
			parametro.setNombre(cuentaSeleccionada.getNombreCuenta());
			break;
		
		case "Constante":
			parametro.setValor(valorParametroConstante);
			break;
		}
		if(nombreIndicador != null){
			builderIndicador.setNombre(nombreIndicador);
		}
		this.ingresarParametroSeleccionado(parametro);
		
	}
	
	public void setearValorParametro(){
		switch(this.getTipoSeleccionado()){
		
			case "Indicador":
				parametro.setValor(indicadorSeleccionado.obtenerValor());
				break;
		
			case "Cuenta":
				parametro.setValor(cuentaSeleccionada.getValor());	
				break;
		}
		
		parametro.setValor(valorParametroConstante);
	}
	
	public BuilderIndicador getBuilderIndicador() {
		return builderIndicador;
	}
	
	public void setBuilderIndicador(BuilderIndicador builderIndicador) {
		this.builderIndicador = builderIndicador;
	}
	
	public Indicador getIndicadorSeleccionado() {
		return indicadorSeleccionado;
	}

	public void setIndicadorSeleccionado(Indicador indicadorSeleccionado) {
		this.indicadorSeleccionado = indicadorSeleccionado;
	}
	
	public void setParametro(Parametro parametro) {
		this.parametro = parametro;
	}

	public List<Indicador> getIndicadores() {
		return indicadores;
	}

	public void setIndicadores(List<Indicador> indicadores) {
		this.indicadores = indicadores;
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

	public String getTipoSeleccionado() {
		return tipoSeleccionado;
	}
	
	public String getNombreIndicador() {
		return nombreIndicador;
	}
	public void setNombreIndicador(String indicador) {
		this.nombreIndicador = indicador;
	}

	public void setTipoSeleccionado(String tipoSeleccionado) {
		this.tipoSeleccionado = tipoSeleccionado;
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
		
	abstract void ingresarParametroSeleccionado(Parametro parametro);
}
