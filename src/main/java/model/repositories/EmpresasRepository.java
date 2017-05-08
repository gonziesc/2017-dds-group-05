package model.repositories;

import java.util.LinkedList;
import java.util.List;

import model.Empresa;

public class EmpresasRepository {
	private List<Empresa> empresas = new LinkedList<>();

	public void agregar(Empresa prenda) {
		this.empresas.add(prenda);
	}

	public List<Empresa> all() {
		return empresas;
	}
}
