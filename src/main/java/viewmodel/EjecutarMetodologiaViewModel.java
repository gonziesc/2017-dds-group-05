package viewmodel;

import java.beans.PropertyChangeSupport;
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
import model.Metodologia2;

@Observable
public class EjecutarMetodologiaViewModel {
	private List<Metodologia> metodologias;
	private Metodologia2 metodologiaSeleccionada;
	private ArrayList<Empresa> empresas;

	
	public void ejecutarMetodologia() {
		this.validarIngreso();
		metodologiaSeleccionada.calcularMetodologia2(empresas);		
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
		try {
			empresas = (ArrayList<Empresa>) EmpresasService.obtenerEmpresasDeServicioExterno();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<Metodologia> getMetodologias() {
		return metodologias;
	}
	
	public void setMetodologias(List<Metodologia> metodologias) {
		this.metodologias = metodologias;
	}
	
	public Metodologia2 getMetodologiaSeleccionada() {
		return metodologiaSeleccionada;
	}
	
	public void setMetodologiaSeleccionada(Metodologia2 metodologiaSeleccionada) {
		this.metodologiaSeleccionada = metodologiaSeleccionada;
	}

	public ArrayList<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(ArrayList<Empresa> empresas) {
		this.empresas = empresas;
		
	}

}
