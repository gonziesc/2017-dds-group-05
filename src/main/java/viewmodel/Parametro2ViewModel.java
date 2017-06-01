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
public class Parametro2ViewModel {
	private List<Indicador> indicadores;
	private Indicador segundoIndicador;
	private BuilderIndicador builderIndicador;
	private List<Cuenta> cuentas;
	private Cuenta cuentaSeleccionada;
	private List<String> tipoParametros;
	private String tipoSeleccionado = "Indicador";
	private Integer valorParametroConstante;
	private Parametro parametro = new Parametro();
	
	public Parametro2ViewModel(BuilderIndicador builder){
		indicadores = Repositorios.indicadores.all();
		cuentas = Repositorios.cuentas.all();
		tipoParametros = Repositorios.parametros.all();
		this.builderIndicador = builder;
	}
	
	public void ingresarParametro2(){
		if(this.getTipoSeleccionado() == "Indicador"){
			parametro.setValor(segundoIndicador.obtenerValor());
		}
		else if(this.getTipoSeleccionado() == "Cuenta"){
			parametro.setValor(cuentaSeleccionada.getValor());	
		}
		else if (this.getTipoSeleccionado() == "Constante"){
			parametro.setValor(valorParametroConstante);
		}
		builderIndicador.setParametro2(parametro);
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

	public Integer getValorParametroConstante() {
		return valorParametroConstante;
	}

	public void setValorParametroConstante(Integer valorParametroConstante) {
		this.valorParametroConstante = valorParametroConstante;
	}

}
