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
public class Parametro3ViewModel {

	private List<Indicador> indicadores;
	private Indicador tercerIndicador;
	private BuilderIndicador builderIndicador;
	private String nombreIndicador;
	private List<Cuenta> cuentas;
	
	public Parametro3ViewModel(BuilderIndicador builder){
		this.setIndicadores(Repositorios.indicadores.all());
		this.cuentas = Repositorios.cuentas.all();
		this.builderIndicador = builder;
	}
	
	public void ingresarParametro3(){
		builderIndicador.setParametro3(tercerIndicador.getParametro3());
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void obtenerCuentas() {
		
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
}
