package model;

public class parametroCompuesto extends parametroGeneral{
	private parametroGeneral parametro1;
	private parametroGeneral parametro2;
	private String nombre = "";
	private String operacion;

	public int getValor() {
		return Operadores.resolverOperacion(parametro1.getValor(), parametro2.getValor(), operacion);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	public parametroGeneral getParametro1() {
		return parametro1;
	}
	public void setParametro1(Parametro parametro1) {
		this.parametro1 = parametro1;
	}
	public parametroGeneral getParametro2() {
		return parametro2;
	}
	public void setParametro2(Parametro parametro2) {
		this.parametro2 = parametro2;
	}
}
