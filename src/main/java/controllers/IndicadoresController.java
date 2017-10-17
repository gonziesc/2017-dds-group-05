package controllers;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Services.EmpresasService;
import Services.IndicadoresService;
import model.Empresa;
import model.Indicador;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class IndicadoresController {
	public ModelAndView create(Request req, Response res){
		return new ModelAndView(null, "home/home.hbs");
	}
	public ModelAndView showCreateView(Request req, Response res){
		return new ModelAndView(null, "home/home.hbs");
	}
	public ModelAndView getEmpresaByName(Request req, Response res) throws FileNotFoundException{
		String nombreIndicador = req.params("nombre");
		Indicador indicador = IndicadoresService.obtenerIndicadorPorNombre(nombreIndicador);
		List<Empresa> empresas = EmpresasService.obtenerEmpresasDeServicioExterno();
		
		indicador.calcularValorEn(empresas);
		
		Map<String, List<Empresa>> model = new HashMap<>();
		model.put("empresas", empresas);
		
		return new ModelAndView(empresas, "indicadores/evaluarIndicadores.hbs");
	}
}
