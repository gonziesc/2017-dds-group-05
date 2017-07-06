package model.repositories;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

import Services.EmpresasService;
import model.Empresa;

public class EmpresasRepository {
	private List<Empresa> empresas = new LinkedList<>();

	public List<Empresa> all() {
		try {
			return EmpresasService.obtenerEmpresasDeServicioExterno();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return empresas;
	}
}
