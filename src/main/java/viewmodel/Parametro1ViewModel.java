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
public class Parametro1ViewModel {
	private BuilderIndicador builderIndicador = new BuilderIndicador();
	private List<Indicador> indicadores;
	private Indicador indicadorSeleccionado;
	private List<Cuenta> cuentas;
	private Cuenta cuentaSeleccionada;
	
	public Parametro1ViewModel(){
		this.setIndicadores(Repositorios.indicadores.all());
		this.setCuentas(Repositorios.cuentas.all());
	}

	public void obtenerIndicadores() {
		try {
			setIndicadores(IndicadoresService.obtenerInicadoresDeServicioExterno());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ingresarIndicador() {
		this.ingresarParametro1();
		try {
			IndicadoresService.guardarIndicadoresEnServicioExterno(builderIndicador.build());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void ingresarParametro1() {
		builderIndicador.setParametro1(indicadorSeleccionado.getParametro1());
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
}