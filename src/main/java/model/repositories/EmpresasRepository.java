package model.repositories;

import java.util.LinkedList;
import java.util.List;

import model.Empresa;

public class EmpresasRepository {
	private List<Empresa> empresas = new LinkedList<>();

	public List<Empresa> all() {
		return empresas;
	}
}
