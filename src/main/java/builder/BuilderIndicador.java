package builder;

import org.uqbar.commons.model.UserException;

import model.Indicador;
import model.Parametro;
import model.parametroGeneral;

public class BuilderIndicador {
	private Indicador indicador;
	private parametroGeneral parametro = null;
	private parametroGeneral parametroFinal;
	private BuilderParametro builderProximoParametro= new BuilderParametro();
	private String operacion;
	private String nombre = null;

	public Indicador build(){
		if(parametro == null) throw new UserException("Ingrese al menos un parametro");
		indicador = new Indicador(parametro,parametroFinal,operacion);
		indicador.setNombre(nombre);
		return indicador;
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
		if(parametro != null){
			builderProximoParametro.setOperacion(operacion1);
		}
		else{
			this.operacion = operacion1;
		}
	}
	public parametroGeneral getParametro() {
		return parametro;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

}
	
	

