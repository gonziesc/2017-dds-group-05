package builder;

import org.uqbar.commons.model.UserException;

import model.Indicador;
import model.Parametro;
import model.parametroGeneral;

public class BuilderIndicador {
	private Indicador indicador;
	private parametroGeneral parametro1;
	private parametroGeneral parametro2;
	private String operacion;
	private String nombre = null;
	

	public Indicador build(){
		Indicador unIndicador = new Indicador(parametro1,parametro2,operacion);
		unIndicador.setNombre(nombre);
		return unIndicador;
	}


	public void setParametro1(parametroGeneral parametro12) {
		this.parametro1 = parametro12;
	}

	public void setParametro2(parametroGeneral parametro22) {
		this.parametro2 = parametro22;
	}

	public void setOperacion(String operacion1) {
		this.operacion = operacion1;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
	
	

