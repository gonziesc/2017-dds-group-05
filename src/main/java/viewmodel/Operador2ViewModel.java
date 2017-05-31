package viewmodel;

import org.uqbar.commons.utils.Observable;

import builder.BuilderIndicador;

@Observable
public class Operador2ViewModel {
	
	public Operador2ViewModel (BuilderIndicador builder){
		builderIndicador = builder;
	}
	
	private BuilderIndicador builderIndicador;
	private String operacionSeleccionada;
	
	public String getOperador() {
		return operacionSeleccionada;
	}

	public void setOperacionSeleccionada(String operador) {
		this.operacionSeleccionada = operador;
	}

	public BuilderIndicador getBuilderIndicador() {
		return builderIndicador;
	}

	public void setBuilderIndicador(BuilderIndicador builderIndicador) {
		this.builderIndicador = builderIndicador;
	}

	public void ingresarOperador(){
		builderIndicador.setOperacion2(this.getOperador());
	}
}