package model.repositories;

import java.util.LinkedList;
import java.util.List;

import model.Empresa;
import model.Metodologia;

public class MetodologiasRepository {
	private List<Metodologia> metodologias = new LinkedList<>();

	public List<Metodologia> all() {
		return metodologias;
	}
}
