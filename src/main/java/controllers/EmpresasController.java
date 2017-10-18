package controllers;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Services.EmpresasService;
import model.Cuenta;
import model.Empresa;
import server.Router;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class EmpresasController {
	public ModelAndView getById(Request req, Response res) throws FileNotFoundException{
		
		
		String empresa = req.params("empresa");
		Map<String, List<Cuenta>> model = new HashMap<>();
		List<Cuenta> cuentas = EmpresasService.obtenerCuentasDeEmpresa(empresa);
		
		model.put("cuentas", cuentas);
		return new ModelAndView(model, "empresas/index.hbs");
	}
	
	public ModelAndView show (Request req, Response res) throws FileNotFoundException{
		List<Empresa> lista = EmpresasService.obtenerEmpresasDeServicioExterno();
		Map<String, List<Empresa>> model = new HashMap<>();
		model.put("empresas", lista);
		return new ModelAndView(model, "empresas/empresas.hbs");
	}
}
