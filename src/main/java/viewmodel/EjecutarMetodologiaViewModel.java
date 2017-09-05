package viewmodel;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

import Services.EmpresasService;
import Services.MetodologiasService;
import model.Empresa;
import model.Metodologia;
import model.Metodologia;
import model.repositories.Repositorios;

@Observable
public class EjecutarMetodologiaViewModel {
	private List<Metodologia> metodologias;
	private Metodologia metodologiaSeleccionada;
	private ArrayList<Empresa> empresas;

	
	public void ejecutarMetodologia() {
		this.validarIngreso();
		/* VALIDAR QUE ESTO ESTE BIEN*/
		metodologiaSeleccionada.calcularMetodologia(empresas);		
	}

	private void validarIngreso() {
		if (metodologiaSeleccionada == null){
			throw new UserException("Ingrese una metodologia");
		}
	}

	public void obtenerMetodologias() {
		try {
			metodologias = MetodologiasService.obtenerMetodologiasDeServicioExterno();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void obtenerEmpresas(){
			this.setEmpresas((ArrayList<Empresa>) Repositorios.empresas.all());
	}

	public void actualizarTabla() {
		ArrayList<Empresa> empresasNuevo = empresas;
		this.setEmpresas(null);
		this.setEmpresas(empresasNuevo);
	}
	public List<Metodologia> getMetodologias() {
		return metodologias;
	}
	
	public void setMetodologias(List<Metodologia> metodologias) {
		this.metodologias = metodologias;
	}
	
	public Metodologia getMetodologiaSeleccionada() {
		return metodologiaSeleccionada;
	}
	
	public void setMetodologiaSeleccionada(Metodologia metodologiaSeleccionada) {
		this.metodologiaSeleccionada = metodologiaSeleccionada;
	}

	public ArrayList<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(ArrayList<Empresa> empresas) {
		this.empresas = empresas;
		
	}

}
