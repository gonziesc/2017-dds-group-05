package viewmodel;

import builder.BuilderIndicador;

public abstract class OperadorViewModel {
	
	private BuilderIndicador builderIndicador;
	private String operacionSeleccionada;
	
	public OperadorViewModel (BuilderIndicador builder){
		builderIndicador = builder;
	}
	
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

	public void ingresarOperacion(){
		this.ingresarOperador();
	}
	
	abstract void ingresarOperador();
}
