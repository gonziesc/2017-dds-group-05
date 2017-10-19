
package model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.mockito.cglib.core.ProcessArrayCallback;
import org.uqbar.commons.utils.Observable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
 

@Entity @Table(name="indicadores")
@Observable
public class Indicador{
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(cascade = CascadeType.ALL)
	private parametroGeneral parametro1;
	@OneToOne(cascade = CascadeType.ALL)
	private parametroGeneral parametro2;
	private String operacion;
	private String nombre;
	private int valor =0;
	@ManyToOne(targetEntity=Usuario.class,cascade=CascadeType.ALL)
	private Usuario user;

	public Indicador(){}
	public Indicador(parametroGeneral unParametro1, parametroGeneral unParametro2, String unaOperacion1){
		parametro1 = unParametro1;
		parametro2 = unParametro2;
		operacion = unaOperacion1;
		this.setValor();
	}
	
	public int obtenerValor(){
		if(parametro2 == null)
			return parametro1.getValor();
		return Operadores.resolverOperacion(parametro1.getValor(), parametro2.getValor(), operacion);
	}

	public List<Integer> calcularValorEn(List<Empresa> empresas){
		return empresas.stream().map(e -> this.calcularIndicadorEn(e)).collect(Collectors.toList());		
	}
	public int calcularIndicadorEn(Empresa empresa){
		empresa.procesarIndicador(this);
		//this.setValorIndicador(this);
		return this.obtenerValor();
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
	
	public String getOperacion() {
		return operacion;
	}
	
	public void setOperacion(String operacion1) {
		this.operacion = operacion1;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setValorCuenta(Cuenta cuenta) {
		if(parametro1 != null && parametro1.getNombre() == cuenta.getNombreCuenta()){
			parametro1.setValor(cuenta.getValor());
		} else if(parametro2 != null && parametro2.getNombre() == cuenta.getNombreCuenta()){
			parametro2.setValor(cuenta.getValor());
		}
	}
	
	public void setValorIndicador(Indicador indicador) {
		if (parametro1 != null && parametro1.getNombre().toString().equals(indicador.getNombre().toString())) {
			parametro1.setValor(indicador.obtenerValor());
		} else if (parametro2 != null && parametro2.getNombre().toString().equals(indicador.getNombre().toString())) {
			parametro2.setValor(indicador.obtenerValor());
		}
	}
	
	public int getValor() {
		this.obtenerValor();
		return valor;
	}
	
	public void setValor() {
		this.valor = this.obtenerValor();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}

}
