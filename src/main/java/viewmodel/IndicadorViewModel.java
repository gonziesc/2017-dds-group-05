package viewmodel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.uqbar.commons.utils.Observable;

import Services.IndicadoresService;
import builder.BuilderIndicador;
import model.Cuenta;
import model.Indicador;
import model.Parametro;
import model.repositories.Repositorios;

@Observable
public class IndicadorViewModel {
	private BuilderIndicador builderIndicador = new BuilderIndicador();
	private List<Indicador> indicadores;
	private Indicador indicadorSeleccionado;
	private Parametro parametroSeleccionado;
	private String operacionSeleccionada;
	private List<Cuenta> cuentas;
	private Cuenta cuentaSeleccionada;
	
	public IndicadorViewModel(){
		this.indicadores = Repositorios.indicadores.all();
		this.cuentas = Repositorios.cuentas.all();
	}

	public void obtenerIndicadores() {
		try {
			indicadores = IndicadoresService.obtenerInicadoresDeServicioExterno();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void obtenerCuentas() {
		
	}
	public void ingresarParametro1() {
		builderIndicador.setParametro1(indicadorSeleccionado.getParametro1());
	}
	
	public void ingresarOperador(){
		builderIndicador.setOperacion1(operacionSeleccionada);
	}
	
	public void crearIndicador() {
		builderIndicador.setParametro2(indicadorSeleccionado.getParametro2());
		builderIndicador.build();
	}
	
	//
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

	public BuilderIndicador getBuilderIndicador() {
		return builderIndicador;
	}

	public void setBuilderIndicador(BuilderIndicador builderIndicador) {
		this.builderIndicador = builderIndicador;
	}

	public Parametro getParametroSeleccionado() {
		return parametroSeleccionado;
	}

	public void setParametroSeleccionado(Parametro parametroSeleccionado) {
		this.parametroSeleccionado = parametroSeleccionado;
	}

	public String getOperacionSeleccionada() {
		return operacionSeleccionada;
	}

	public void setOperacionSeleccionada(String operacionSeleccionada) {
		this.operacionSeleccionada = operacionSeleccionada;
	}

	public Indicador getIndicadorSeleccionado() {
		return indicadorSeleccionado;
	}

	public void setIndicadorSeleccionado(Indicador indicadorSelecionado) {
		this.indicadorSeleccionado = indicadorSelecionado;
	}



}
