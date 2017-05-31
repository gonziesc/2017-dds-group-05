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
	
	public Parametro1ViewModel(){
		this.setIndicadores(Repositorios.indicadores.all());
		this.cuentas = Repositorios.cuentas.all();
	}

	public void obtenerIndicadores() {
		try {
			setIndicadores(IndicadoresService.obtenerInicadoresDeServicioExterno());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void obtenerCuentas() {
		
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

	public void ingresarParametro1() {
		builderIndicador.setParametro1(indicadorSeleccionado.getParametro1());
	}

	public List<Indicador> getIndicadores() {
		return indicadores;
	}

	public void setIndicadores(List<Indicador> indicadores) {
		this.indicadores = indicadores;
	}
}
