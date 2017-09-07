package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class parametroGeneral {
	protected int valor;
	protected parametroGeneral parametro1;
	protected parametroGeneral parametro2;
	private String nombre = "";
	private String operacion;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public int getValor() {
		if(parametro1 != null)
		this.valor = parametro1.getValor();
		if(parametro2 != null)
		this.valor += parametro2.getValor();
		return valor;
	}
	
	public void setValor(int valor) {
		this.valor = parametro1.getValor() + parametro2.getValor();
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
	public void setParametro1(parametroGeneral parametro) {
		this.parametro1 = parametro;
	}
	public parametroGeneral getParametro2() {
		return parametro2;
	}
	public void setParametro2(parametroGeneral parametro22) {
		this.parametro2 = parametro22;
	}
}
