package viewmodel;

import java.io.FileNotFoundException;
import java.util.List;

import Services.IndicadoresService;
import builder.BuilderIndicador;
import model.Cuenta;
import model.Indicador;
import model.repositories.Repositorios;

public class Parametro3ViewModel {
	private List<Indicador> indicadores;
	private Indicador tercerIndicador;
	private BuilderIndicador builderIndicador;
	private List<Cuenta> cuentas;
	
	public Parametro3ViewModel(BuilderIndicador builder){
		this.indicadores = Repositorios.indicadores.all();
		this.cuentas = Repositorios.cuentas.all();
		this.builderIndicador = builder;
	}
	
	public void ingresarParametro3(){
		builderIndicador.setParametro3(tercerIndicador.getParametro3());
	}	
	
	public void crearIndicador() {
		builderIndicador.build();
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
	
	public BuilderIndicador getBuilderIndicador() {
		return builderIndicador;
	}

	public void setBuilderIndicador(BuilderIndicador builderIndicador) {
		this.builderIndicador = builderIndicador;
	}
}
