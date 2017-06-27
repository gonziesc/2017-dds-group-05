package viewmodel;

import java.io.FileNotFoundException;
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
	private List<Empresa> empresas;
	
	public void ejecutarMetodologia() {
		empresas.stream().filter(e ->metodologiaSeleccionada.calcularMetodologia() == e);
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
			empresas = EmpresasService.obtenerEmpresasDeServicioExterno();
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

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

}
