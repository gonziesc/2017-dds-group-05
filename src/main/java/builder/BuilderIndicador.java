package builder;

import model.Indicador;
import model.Parametro;

public class BuilderIndicador {
	private Parametro parametro1;
	private Parametro parametro2;
	private String operacion;
	private String nombre = null;
	
	public Indicador build(){
		return new Indicador(parametro1,parametro2,operacion);
	}

	public void setParametro1(Parametro parametro1) {
		this.parametro1 = parametro1;
	}

	public void setParametro2(Parametro parametro2) {
		this.parametro2 = parametro2;
	}

	public void setOperacion(String operacion1) {
		this.operacion = operacion1;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
	
	

