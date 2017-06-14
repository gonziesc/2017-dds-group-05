package builder;

import model.parametroGeneral;

public class BuilderParametro {
	private parametroGeneral parametroABuildear = new parametroGeneral();
	private parametroGeneral parametro = null;
	private BuilderParametro builderOtroParametro;
	private parametroGeneral otroParametro;
	private String operacion;
	private int valor;

	public parametroGeneral build() {
		parametroABuildear.setParametro1(parametro);
		parametroABuildear.setParametro2(otroParametro);
		return parametroABuildear;
	}

	public parametroGeneral getParametro() {
		return parametro;
	}

	public void setParametro(parametroGeneral parametro) {
		if (this.parametro != null) {
			builderOtroParametro.setParametro(parametro);
		} else {
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
		if (this.parametro != null) {
			builderOtroParametro.setOperacion(operacion);
		} else {
			this.operacion = operacion;
		}
	}

	public parametroGeneral getParametroABuildear() {
		return parametroABuildear;
	}

	public void setParametroABuildear(parametroGeneral parametroABuildear) {
		this.parametroABuildear = parametroABuildear;
	}

	public parametroGeneral getOtroParametro() {
		return otroParametro;
	}

	public void setOtroParametro(parametroGeneral otroParametro) {
		this.otroParametro = otroParametro;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

}
