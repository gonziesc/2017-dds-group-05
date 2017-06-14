package builder;

import model.parametroGeneral;

public class BuilderParametro {
	private parametroGeneral parametro = null;
	private BuilderParametro builderOtroParametro;
	private String operacion;
	
	public parametroGeneral build(){
		parametroGeneral nuevoParametro = new parametroGeneral();
		nuevoParametro.setParametro1(parametro);
		parametroGeneral parametro2 = builderOtroParametro.build();
		nuevoParametro.setParametro2(parametro2);
		return nuevoParametro;
	}
	
	public parametroGeneral getParametro() {
		return parametro;
	}
	
	public void setParametro(parametroGeneral parametro) {
		if(this.parametro !=null){
			builderOtroParametro.setParametro(parametro);
		}
		else{
			this.parametro = parametro;
		}
	}
	
	public BuilderParametro getBuilderOtroParametro() {
		return builderOtroParametro;
	}
	
	public void setBuilderOtroParametro(BuilderParametro builderOtroParametro) {
		this.builderOtroParametro = builderOtroParametro;
	}
	
	public String getOperacion() {
		return operacion;
	}
	
	public void setOperacion(String operacion) {
		if(this.parametro !=null){
			builderOtroParametro.setOperacion(operacion);
		}
		else{
			this.operacion = operacion;
		}
	}

}
