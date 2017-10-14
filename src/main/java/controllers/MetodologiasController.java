package controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class MetodologiasController {
	public ModelAndView getEmpresaByName(Request req, Response res){
		return new ModelAndView(null, "home/home.hbs");
	}
}
