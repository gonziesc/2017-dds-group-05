package controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Empresa;
import model.Metodologia;
import Services.EmpresasService;
import Services.MetodologiasService;

public class MetodologiasController {
	public ModelAndView evaluarMetodologia(Request req, Response res) throws FileNotFoundException{
		String nombre = req.params("nombre");
		Map<String, List<Empresa>> model = new HashMap<>();
		
		List<Empresa> empresas = EmpresasService.obtenerEmpresasDeServicioExterno();
		Metodologia metodologia = MetodologiasService.obtenerMetodologiaDeServicioExterno(nombre);
		metodologia.calcularMetodologia(empresas);
	
		model.put("empresas", empresas);
		
		return new ModelAndView(model, "metodologias/evaluar.hbs");
	}
}
