package model.repositories;

import java.util.LinkedList;
import java.util.List;

public class TipoParametros {
	private List<String> parametros = new LinkedList<>();
	
	public List<String>all(){
		return parametros;
	}
	
	public void agregar(String parametro){
		parametros.add(parametro);
	}
}
