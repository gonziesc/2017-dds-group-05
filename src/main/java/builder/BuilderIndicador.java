package builder;

import java.util.List;

import org.uqbar.commons.model.UserException;

import Services.IndicadoresService;
import model.Cuenta;
import model.Indicador;
import model.Parametro;
import model.Usuario;
import model.parametroGeneral;
import model.repositories.CuentasRepository;

public class BuilderIndicador {
	private Indicador indicador;
	private parametroGeneral parametro = null;
	private parametroGeneral parametroFinal;
	private BuilderParametro builderProximoParametro= new BuilderParametro();
	private String operacion;
	private String nombre = null;
	private Usuario user;

	public Indicador build(){
		if(parametro == null) throw new UserException("Ingrese al menos un parametro");
		indicador = new Indicador(parametro,parametroFinal,operacion);
		indicador.setNombre(nombre);
		indicador.setUser(user);
		return indicador;
	}

	public parametroGeneral getParametroFinal() {
		return parametroFinal;
	}

	public void setParametroFinal(parametroGeneral parametroFinal) {
		this.parametroFinal = parametroFinal;
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
	
	public void setParametroAPartirVista(String tipo,String[] valores,boolean esFinal){
		if(esFinal){
			setParametroSegun(tipo, valores, parametroFinal);
		}
		else{
			parametro = new parametroGeneral();
			setParametroSegun(tipo, valores, parametro);
			this.setParametro(parametro);
		}
	}

	public void setParametroSegun(String tipo, String[] valores,parametroGeneral param) {
		switch(tipo){
		case "Indicador":
			Long id = Long.getLong(valores[0]);
			param.setValor((IndicadoresService.obtenerIndicadorPorId(id).obtenerValor()));
			break;
			
		case "Cuenta":
			param.setValor((CuentasRepository.obtenerCuentas().stream().filter(cuenta -> cuenta.getNombreCuenta() == valores[2])).findFirst().get().getValor());
			param.setNombre(valores[1]);
			break;

		case "Constante":
			param.setValor(Integer.parseInt(valores[2]));
			break;
		}
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		System.out.println(user.getUsuario());
		this.user = user;
	}

}
	
	

