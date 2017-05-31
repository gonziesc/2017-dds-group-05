package viewmodel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.uqbar.commons.utils.Observable;

import Services.IndicadoresService;
import builder.BuilderIndicador;
import model.Cuenta;
import model.Indicador;
import model.repositories.Repositorios;

@Observable
public class Parametro2ViewModel {
	private List<Indicador> indicadores;
	private Indicador segundoIndicador;
	private BuilderIndicador builderIndicador;
	private List<Cuenta> cuentas;
	
	public Parametro2ViewModel(BuilderIndicador builder){
		this.indicadores = Repositorios.indicadores.all();
		this.cuentas = Repositorios.cuentas.all();
		this.builderIndicador = builder;
	}
	
	public void ingresarParametro2(){
		builderIndicador.setParametro2(segundoIndicador.getParametro2());
	}	
	
	public void ingresarIndicador() {
		this.ingresarParametro2();
		try {
			IndicadoresService.guardarIndicadoresEnServicioExterno(builderIndicador.build());
		} catch (IOException e) {
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
	
	public void obtenerCuentas() {
		
	}
	
	public Indicador getSegundoIndicador() {
		return segundoIndicador;
	}
	
	public void setSegundoIndicador(Indicador segundoIndicador) {
		this.segundoIndicador = segundoIndicador;
	}
	
	public BuilderIndicador getBuilderIndicador() {
		return builderIndicador;
	}

	public List<Indicador> getIndicadores() {
		return indicadores;
	}

	public void setIndicadores(List<Indicador> indicadores) {
		this.indicadores = indicadores;
	}

}
