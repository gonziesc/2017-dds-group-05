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
import model.repositories.Repositorios;
import model.repositories.*;

@Observable
public class EjecutarMetodologiaViewModel {
	private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	private List<Metodologia> metodologias;
	private Metodologia metodologiaSeleccionada;
	private ArrayList<Empresa> empresas;
	private ServiceRepository service;
	
	public void ejecutarMetodologia() {
		this.validarIngreso();
		Collections.sort(empresas, new Comparator<Empresa>() {
	        @Override
	        public int compare(Empresa empresa1, Empresa empresa2)
	        {
	            Empresa empresaMejor = metodologiaSeleccionada.calcularMetodologia(empresa1, empresa2);
	            System.out.println(empresaMejor.getNombreEmpresa());
	            if(empresaMejor.equals(empresa1)){
	            	return 1;
	            }
	            else if(empresaMejor.equals(empresa2)){
	            	return -1;
	            }
	            return 0;
	        }
	    });
						
	}

	private void validarIngreso() {
		if (metodologiaSeleccionada == null){
			throw new UserException("Ingrese una metodologia");
		}
	}

	public void obtenerMetodologias() {
		try {
			metodologias = service.serviceMetodologias.obtenerDeServicioExterno();
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
		ArrayList<Empresa> oldEmpresas = this.getEmpresas();
		this.empresas = empresas;
		
	}

}
