package server;

import org.junit.Before;

import controllers.EmpresasController;
import controllers.HomeController;
import controllers.IndicadoresController;
import controllers.MetodologiasController;
import spark.ModelAndView;
import spark.Request;
import spark.Session;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.utils.HandlebarsTemplateEngineBuilder;

public class Router {

	public static void configure() {
		HandlebarsTemplateEngine engine = HandlebarsTemplateEngineBuilder
				.create()
				.withDefaultHelpers()
				.build();

		Spark.staticFiles.location("/public");	
				
		EmpresasController empresasController = new EmpresasController();
		IndicadoresController indicadoresController = new IndicadoresController();
		HomeController homeController = new HomeController();
		MetodologiasController metodologiasController = new MetodologiasController();
				
		//Spark.before(homeController::validar);
				
		Spark.get("/", homeController::home, engine);
		Spark.get("/register", homeController::showRegister, engine);
		Spark.post("/register", homeController::register, engine);
		Spark.get("/login", homeController::showLogin, engine);
		Spark.post("/login", homeController::login, engine);
		Spark.get("/logout", homeController::showLogOut, engine);
		Spark.post("/logout", homeController::logOut, engine);
		Spark.get("/empresas/:empresa/cuentas", empresasController::getById, engine);
		Spark.get("/indicadores/crear", indicadoresController::showCreateView, engine);
		Spark.post("/indicadores/crear", indicadoresController::create, engine);
		Spark.get("/metodologias/crear", metodologiasController::showCreateView, engine);
		Spark.post("/metodologias/crear", metodologiasController::create, engine);
		Spark.get("/indicadores/:nombre/evaluar", indicadoresController::evaluar, engine);
		Spark.get("/metodologias/:nombre/evaluar", metodologiasController::evaluarMetodologia, engine);
		Spark.post("/indicadores", indicadoresController::create, engine);
		Spark.get("/empresas", empresasController::show, engine);
		Spark.get("/indicadores", indicadoresController::show, engine);
		Spark.get("/metodologias", metodologiasController::show, engine);
		
	}
	
	public static boolean validar(Request req){
		return req.session().attribute("user") == null;
	}
	
	public static boolean esRutaPublica(String url) {
		return url == "/login" || url == "/register";
	}

}