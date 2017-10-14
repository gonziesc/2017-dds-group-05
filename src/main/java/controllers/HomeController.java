package controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class HomeController {
	public static ModelAndView home(Request req, Response res){
		return new ModelAndView(null, "home/home.hbs");
	}
	
	public static ModelAndView showLogin(Request req, Response res){
		return new ModelAndView(null, "home/home.hbs");
	}
	
	public static ModelAndView login(Request req, Response res){
		return new ModelAndView(null, "home/home.hbs");
	}
	
}