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
import model.parametroGeneral;
import model.repositories.Repositorios;

@Observable
public class ParametroViewModel {
	private List<Indicador> indicadores;
	private Indicador indicadorSeleccionado1;
	private Indicador indicadorSeleccionado2;
	private BuilderIndicador builderIndicador;
	private List<Cuenta> cuentas;
	private Cuenta cuentaSeleccionada1;
	private Cuenta cuentaSeleccionada2;
	private List<String> tipoParametros;
	private String tipoSeleccionado1 = "Indicador";
	private String tipoSeleccionado2 = null;
	private Integer valorParametroConstante1;
	private Integer valorParametroConstante2;
	private List<Empresa> empresas;
	private parametroGeneral parametro1 = new parametroGeneral();
	private parametroGeneral parametro2 = new parametroGeneral();
	private String nombreIndicador;
	private String operacionSeleccionada;

	public ParametroViewModel(BuilderIndicador builder) {
		indicadores = Repositorios.indicadores.all();
		cuentas = Repositorios.cuentas.all();
		tipoParametros = Repositorios.parametros.all();
		builderIndicador = builder;
	}

	public void obtenerIndicadores() {
		try {
			indicadores = IndicadoresService
					.obtenerInicadoresDeServicioExterno();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void ingresarIndicador() {
		try {
			this.setearIndicador();
			IndicadoresService
					.guardarIndicadoresEnServicioExterno(builderIndicador
							.build());
		} catch (IOException e) {
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

	public void obtenerCuentas() {
		this.obtenerEmpresas();
		cuentas = empresas.stream()
				.flatMap(unaEmpresa -> unaEmpresa.getCuentas().stream())
				.collect(Collectors.toList());
	}

	public void setearIndicador() {
		switch (this.getTipoSeleccionado1()) {

		case "Indicador":
			parametro1.setValor(indicadorSeleccionado1.obtenerValor());
			parametro1.setNombre(indicadorSeleccionado1.getNombre());
			break;

		case "Cuenta":
			parametro1.setValor(cuentaSeleccionada1.getValor());
			parametro1.setNombre(cuentaSeleccionada1.getNombreCuenta());
			break;

		case "Constante":
			parametro1.setValor(valorParametroConstante1);
			break;
		}
		if(this.getTipoSeleccionado2() != null){
			switch (this.getTipoSeleccionado2()) {

			case "Indicador":
				parametro2.setValor(indicadorSeleccionado2.obtenerValor());
				parametro2.setNombre(indicadorSeleccionado2.getNombre());
				break;

			case "Cuenta":
				parametro2.setValor(cuentaSeleccionada2.getValor());
				parametro2.setNombre(cuentaSeleccionada2.getNombreCuenta());
				break;

			case "Constante":
				parametro2.setValor(valorParametroConstante2);
				break;
			}
		}
		
		if (nombreIndicador != null) {
			builderIndicador.setNombre(nombreIndicador);
		}
		if (operacionSeleccionada != null) {
			builderIndicador.setOperacion(operacionSeleccionada);
		}
		builderIndicador.setParametro1(parametro1);
		builderIndicador.setParametro2(parametro2);
	}

	/*
	 * public void ingresarParametro() { //this.setearValorParametro();
	 * switch(this.getTipoSeleccionado()){
	 * 
	 * case "Indicador":
	 * parametro.setValor(indicadorSeleccionado.obtenerValor());
	 * parametro.setNombre(indicadorSeleccionado.getNombre()); break;
	 * 
	 * case "Cuenta": parametro.setValor(cuentaSeleccionada.getValor());
	 * parametro.setNombre(cuentaSeleccionada.getNombreCuenta()); break;
	 * 
	 * case "Constante": parametro.setValor(valorParametroConstante); break; }
	 * if(nombreIndicador != null){ builderIndicador.setNombre(nombreIndicador);
	 * }
	 * 
	 * }
	 */
	/*
	 * public void setearValorParametro(){ switch(this.getTipoSeleccionado()){
	 * 
	 * case "Indicador":
	 * parametro.setValor(indicadorSeleccionado.obtenerValor()); break;
	 * 
	 * case "Cuenta": parametro.setValor(cuentaSeleccionada.getValor()); break;
	 * }
	 * 
	 * parametro.setValor(valorParametroConstante); }
	 */

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

	public Indicador getIndicadorSeleccionado1() {
		return indicadorSeleccionado1;
	}

	public void setIndicadorSeleccionado1(Indicador indicadorSeleccionado1) {
		this.indicadorSeleccionado1 = indicadorSeleccionado1;
	}

	public Indicador getIndicadorSeleccionado2() {
		return indicadorSeleccionado2;
	}

	public void setIndicadorSeleccionado2(Indicador indicadorSeleccionado2) {
		this.indicadorSeleccionado2 = indicadorSeleccionado2;
	}

	public Cuenta getCuentaSeleccionada1() {
		return cuentaSeleccionada1;
	}

	public void setCuentaSeleccionada1(Cuenta cuentaSeleccionada1) {
		this.cuentaSeleccionada1 = cuentaSeleccionada1;
	}

	public Cuenta getCuentaSeleccionada2() {
		return cuentaSeleccionada2;
	}

	public void setCuentaSeleccionada2(Cuenta cuentaSeleccionada2) {
		this.cuentaSeleccionada2 = cuentaSeleccionada2;
	}

	public String getTipoSeleccionado1() {
		return tipoSeleccionado1;
	}

	public void setTipoSeleccionado1(String tipoSeleccionado1) {
		this.tipoSeleccionado1 = tipoSeleccionado1;
	}

	public Integer getValorParametroConstante1() {
		return valorParametroConstante1;
	}

	public void setValorParametroConstante1(Integer valorParametroConstante1) {
		this.valorParametroConstante1 = valorParametroConstante1;
	}

	public Integer getValorParametroConstante2() {
		return valorParametroConstante2;
	}

	public void setValorParametroConstante2(Integer valorParametroConstante2) {
		this.valorParametroConstante2 = valorParametroConstante2;
	}

	public String getTipoSeleccionado2() {
		return tipoSeleccionado2;
	}

	public void setTipoSeleccionado2(String tipoSeleccionado2) {
		this.tipoSeleccionado2 = tipoSeleccionado2;
	}

	public parametroGeneral getParametro1() {
		return parametro1;
	}

	public void setParametro1(Parametro parametro1) {
		this.parametro1 = parametro1;
	}

	public parametroGeneral getParametro2() {
		return parametro2;
	}

	public void setParametro2(Parametro parametro2) {
		this.parametro2 = parametro2;
	}

}
