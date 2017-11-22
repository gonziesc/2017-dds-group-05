package model;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.uqbar.commons.utils.Observable;

@Entity @Table(name="empresas")
@Observable
public class Empresa {
	@Id @GeneratedValue
	public Long id;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="empresa_id")
	public List<Cuenta> Cuentas;
	public String nombreEmpresa;

	public Empresa(){
		
	}
	
	public List<Cuenta> cuentasSegunPeriodo(int periodo){
		@SuppressWarnings("unchecked")
		List<Cuenta> cuentasEnPeriodo = (List<Cuenta>) Cuentas.stream().filter(cuenta -> cuenta.perteneceA(periodo));
		return cuentasEnPeriodo;
	}
	
	public List<Cuenta> cuentasSegunTiempo(int periodoInicio, int periodoFin){
		List<Cuenta> cuentasEnPeriodo = Cuentas.stream()
				.filter(cuenta -> cuenta.getAnioCuenta() >= periodoInicio && cuenta.getAnioCuenta() <= periodoFin).collect(Collectors.toList());
		return cuentasEnPeriodo;
	}
	
	@Override
	public String toString() {
		return nombreEmpresa;
	}

	public List<Cuenta> getCuentas() {
		return Cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		Cuentas = cuentas;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombre) {
		nombreEmpresa = nombre;
	}
	
	public int aniosEmpresa(){
		final Comparator<Cuenta> comp = (p1, p2) -> Integer.compare( p1.getAnioCuenta(), p2.getAnioCuenta());
		return 2017 - Cuentas.stream().min(comp).get().getAnioCuenta();//Revisar, se busca hacer Anio actual - Anio cuenta mas vieja
	}

	public void procesarIndicador(Indicador indicador) {
		Cuentas.stream().forEach(cuenta->cargarIndicador(cuenta,indicador));
		//return indicador;
	}

	public void cargarIndicador(Cuenta cuenta, Indicador indicador) {
		indicador.setValorCuenta(cuenta);
		//return indicador;
	}

}
