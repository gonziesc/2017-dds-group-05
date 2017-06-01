package viewmodel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.uqbar.commons.model.ObservableUtils;
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
	private Parametro parametro = new Parametro();
	private List<Indicador> indicadores;
	private Indicador indicadorSeleccionado;
	private List<Cuenta> cuentas;
	private Cuenta cuentaSeleccionada;
	private String tipoSeleccionado;
	private List<String> tipoParametros;
	private Integer valorParametroConstante;
	
	public Parametro1ViewModel(){
		indicadores = Repositorios.indicadores.all();
		cuentas = Repositorios.cuentas.all();
		tipoParametros = Repositorios.parametros.all();
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
			this.ingresarParametro1();
			IndicadoresService.guardarIndicadoresEnServicioExterno(builderIndicador.build());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void ingresarParametro1() {
		//this.setearValorParametro();	
		if(this.getTipoSeleccionado() == "Indicador"){
			parametro.setValor(indicadorSeleccionado.obtenerValor());
		}
		else if(this.getTipoSeleccionado() == "Cuenta"){
			parametro.setValor(cuentaSeleccionada.getValor());	
		}
		else if (this.getTipoSeleccionado() == "Constante"){
			parametro.setValor(valorParametroConstante);
		}
		builderIndicador.setParametro1(parametro);
	}
	
	public void setearValorParametro(){
		if(this.getTipoSeleccionado() == "Indicador"){
			parametro.setValor(indicadorSeleccionado.obtenerValor());
		}
		else if(this.getTipoSeleccionado() == "Cuenta"){
			parametro.setValor(cuentaSeleccionada.getValor());
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


}
