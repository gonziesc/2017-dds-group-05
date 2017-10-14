package controllers;

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
	public ModelAndView getEmpresaByName(Request req, Response res){
		return new ModelAndView(null, "home/home.hbs");
	}
}
