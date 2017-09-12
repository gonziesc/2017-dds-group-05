package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="parametros")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class parametroGeneral {
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	protected int valor;
	@OneToOne(cascade = CascadeType.ALL)
	protected parametroGeneral parametro1;
	@OneToOne(cascade = CascadeType.ALL)
	protected parametroGeneral parametro2;
	private String nombre = "";
	private String operacion;
	
	public parametroGeneral (){}
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
