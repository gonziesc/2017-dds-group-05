package builder;

import org.uqbar.commons.model.UserException;

import model.Indicador;
import model.Parametro;
import model.parametroGeneral;

public class BuilderIndicador {
	private Indicador indicador;
	private parametroGeneral parametro;
	private parametroGeneral parametroFinal;
	private BuilderParametro builderProximoParametro = new BuilderParametro();
	private String operacion;
	private String nombre = null;
	

	public Indicador build(){
		parametroFinal = builderProximoParametro.build();
		Indicador unIndicador = new Indicador(parametro,parametroFinal,operacion);
		unIndicador.setNombre(nombre);
		return unIndicador;
	}

	public parametroGeneral getParametroFinal() {
		return parametroFinal;
	}

	public void setParametroFinal(parametroGeneral parametroFinal) {
		this.parametroFinal = parametroFinal;
	}

	public void agregarUltimoBuilderParametro(BuilderParametro builderParam){
		
	}

	public void setParametro(parametroGeneral parametro12) {
		if(parametro != null){
			builderProximoParametro.setParametro(parametro12);
		}
		else{
			this.parametro = parametro12;
		}
	}

	public void setOperacion(String operacion1) {
		this.operacion = operacion1;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
	
	

