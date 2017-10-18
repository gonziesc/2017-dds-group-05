package model.repositories;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import Services.EmpresasService;
import model.Cuenta;
import model.Empresa;

public class CuentasRepository {
	public static List<Empresa> obtenerEmpresas() {
		List<Empresa> empresas = new LinkedList<>();
		try {
			empresas = EmpresasService.obtenerEmpresasDeServicioExterno();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return empresas;
	}

	public static List<Cuenta> obtenerCuentas() {
		List<Empresa> empresas = obtenerEmpresas();
		return empresas.stream()
				.flatMap(unaEmpresa -> unaEmpresa.getCuentas().stream())
				.collect(Collectors.toList());
	
	}
}
