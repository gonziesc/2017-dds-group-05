package viewmodel;

import builder.BuilderIndicador;

public class Operador1ViewModel {
	
	public Operador1ViewModel (BuilderIndicador builder){
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
		builderIndicador.setOperacion1(this.getOperador());
	}
}
