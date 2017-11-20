package model.repositories;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Services.EmpresasService;
import model.Empresa;

public class EmpresasRepository {
	private List<Empresa> empresas = new LinkedList<>();

	@SuppressWarnings("unchecked")
	public List<Empresa> all() {
		return EmpresasService.obtenerEmpresasDeServicioExterno();
	}
}
