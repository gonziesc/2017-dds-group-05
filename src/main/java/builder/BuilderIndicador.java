package builder;

import org.uqbar.commons.model.UserException;

import model.Indicador;
import model.Parametro;

public class BuilderIndicador {
	private Parametro parametro1;
	private Parametro parametro2;
	private Parametro parametro3 ;
	private String operacion1;
	private String operacion2;
	private String nombre = null;
	

	public Indicador build(){
		if(parametro1 == null){
			throw new UserException("Debe ingresar al menos 1 parametro");
		}
		return new Indicador(parametro1,parametro2,parametro3,operacion1,operacion2);
	}


	public void setParametro1(Parametro parametro1) {
		this.parametro1 = parametro1;
	}

	public void setParametro2(Parametro parametro2) {
		this.parametro2 = parametro2;
	}

	public void setParametro3(Parametro parametro3) {
		this.parametro3 = parametro3;
	}

	public void setOperacion1(String operacion1) {
		this.operacion1 = operacion1;
	}

	public void setOperacion2(String operacion2) {
		this.operacion2 = operacion2;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
	
	

