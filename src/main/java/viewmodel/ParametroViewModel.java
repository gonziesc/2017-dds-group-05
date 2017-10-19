package viewmodel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

import Services.EmpresasService;
import Services.IndicadoresService;
import builder.BuilderIndicador;
import builder.BuilderParametro;
import model.Cuenta;
import model.Empresa;
import model.Indicador;
import model.Parametro;
import model.parametroGeneral;
import model.repositories.Repositorios;

@Observable
public class ParametroViewModel {
	private List<Indicador> indicadores;
	private Indicador indicadorSeleccionado;
	private BuilderIndicador builderIndicador;
	private List<Cuenta> cuentas;
	private Cuenta cuentaSeleccionada;
	private List<String> tipoParametros;
	private String tipoSeleccionado = "Indicador";
	private Integer valorParametroConstante;
	private List<Empresa> empresas;
	private parametroGeneral parametro = new parametroGeneral();
	private parametroGeneral parametroFinal = new parametroGeneral();
	private String nombreIndicador;
	private String operacionSeleccionada;
	private BuilderParametro builderProximoParametro = new BuilderParametro();
	
	public ParametroViewModel(BuilderIndicador builder, String unNombreIndicador) {
		tipoParametros = Repositorios.parametros.all();
		builderIndicador = builder;
		nombreIndicador = unNombreIndicador;
	}
	
	public void obtenerIndicadores() {
			indicadores = IndicadoresService.obtenerIndicadoresDeServicioExterno();
	}

	public void ingresarIndicador() {
			this.setearParametros(parametro);
			this.setearIndicador();
			IndicadoresService.guardarIndicadoresEnServicioExterno(builderIndicador
							.build());
	}
	
	public void obtenerEmpresas() {
		try {
			empresas = EmpresasService.obtenerEmpresasDeServicioExterno();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void obtenerCuentas() {
		this.obtenerEmpresas();
		cuentas = empresas.stream()
				.flatMap(unaEmpresa -> unaEmpresa.getCuentas().stream())
				.collect(Collectors.toList());
	}

	public void setearIndicador() {
		if (builderIndicador.getNombre() == null) {
			builderIndicador.setNombre(nombreIndicador);
		}
		
		if (operacionSeleccionada != null) {
			builderIndicador.setOperacion(operacionSeleccionada);
		}
		builderIndicador.setParametro(parametro);
	}

	public void setearParametros(parametroGeneral parametro) {
		Parametro unParametro = new Parametro();
		switch (this.getTipoSeleccionado()) {
			case "Indicador":
				unParametro.setValor(indicadorSeleccionado.obtenerValor());
				break;

			case "Cuenta":
				unParametro.setValor(cuentaSeleccionada.getValor());
				unParametro.setNombre(cuentaSeleccionada.getNombreCuenta());
				break;

			case "Constante":
				unParametro.setValor(valorParametroConstante);
				break;
		}
		parametro.setParametro1(unParametro);
	}

	public void setearParametroFinal() {
		setearParametros(parametroFinal);
		builderProximoParametro.setOtroParametro(parametroFinal);
		this.builderIndicador.setParametroFinal(builderProximoParametro.build());
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

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public String getNombreIndicador() {
		return nombreIndicador;
	}

	public void setNombreIndicador(String indicador) {
		this.nombreIndicador = indicador;
	}

	public List<String> getTipoParametros() {
		return tipoParametros;
	}

	public void setTipoParametros(List<String> tipoParametros) {
		this.tipoParametros = tipoParametros;
	}

	public String getOperador() {
		return operacionSeleccionada;
	}

	public void setOperacionSeleccionada(String operador) {
		this.operacionSeleccionada = operador;
	}

	public void ingresarOperacion() {
		this.getBuilderIndicador().setOperacion(this.getOperador());
	}

	public Indicador getIndicadorSeleccionado() {
		return indicadorSeleccionado;
	}

	public void setIndicadorSeleccionado(Indicador indicadorSeleccionado1) {
		this.indicadorSeleccionado = indicadorSeleccionado1;
	}

	public Cuenta getCuentaSeleccionada() {
		return cuentaSeleccionada;
	}

	public void setCuentaSeleccionada(Cuenta cuentaSeleccionada1) {
		this.cuentaSeleccionada = cuentaSeleccionada1;
	}

	public String getTipoSeleccionado() {
		return tipoSeleccionado;
	}

	public void setTipoSeleccionado(String tipoSeleccionado1) {
		this.tipoSeleccionado = tipoSeleccionado1;
	}

	public Integer getValorParametroConstante(){
		return valorParametroConstante;
	}
	
	public void setValorParametroConstante(Integer valorParametroConstante1) {
		this.valorParametroConstante = valorParametroConstante1;
	}

	public parametroGeneral getParametro() {
		return parametro;
	}

	public void setParametro(parametroGeneral parametroGeneral) {
		this.parametro = parametroGeneral;
	}

	public void limpiarSeleccionados() {
		this.setCuentaSeleccionada(null);
		this.setIndicadorSeleccionado(null);
		this.setValorParametroConstante(null);
		
	}

	public String getOperacionSeleccionada() {
		return operacionSeleccionada;
	}


	public parametroGeneral getParametroFinal() {
		return parametroFinal;
	}

	public void setParametroFinal(parametroGeneral parametroFinal) {
		this.parametroFinal = parametroFinal;
	}

}
