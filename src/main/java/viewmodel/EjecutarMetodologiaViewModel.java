package viewmodel;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.uqbar.commons.utils.Observable;

import Services.EmpresasService;
import Services.MetodologiasService;
import model.Empresa;
import model.Metodologia;

@Observable
public class EjecutarMetodologiaViewModel {
	private List<Metodologia> metodologias;
	private Metodologia metodologiaSeleccionada;
	private ArrayList<Empresa> empresas;
	
	public void ejecutarMetodologia() {
		Collections.sort(empresas, new Comparator<Empresa>() {
	        @Override
	        public int compare(Empresa empresa1, Empresa empresa2)
	        {
	            Empresa empresaMejor = metodologiaSeleccionada.calcularMetodologia(empresa1, empresa2);
	            if(empresaMejor.equals(empresa1)){
	            	return 1;
	            }
	            else if(empresaMejor.equals(empresa1)){
	            	return -1;
	            }
	            return 0;
	        }
	    });
						
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
	
	public Metodologia getMetodologiaSeleccionada() {
		return metodologiaSeleccionada;
	}
	
	public void setMetodologiaSeleccionada(Metodologia metodologiaSeleccionada) {
		this.metodologiaSeleccionada = metodologiaSeleccionada;
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(ArrayList<Empresa> empresas) {
		this.empresas = empresas;
	}

}
