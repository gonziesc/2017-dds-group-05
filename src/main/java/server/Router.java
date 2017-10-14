package server;

import controllers.EmpresasController;
import controllers.HomeController;
import controllers.IndicadoresController;
import controllers.MetodologiasController;
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

		MetodologiasController metodologiasController = new MetodologiasController();
		
		Spark.get("/", HomeController::home, engine);
		Spark.get("/login", HomeController::showLogin, engine);
		Spark.post("/login", HomeController::login, engine);
		Spark.get("/empresas/:empresa/cuentas", empresasController::getById, engine);
		Spark.get("/indicadores/crear", indicadoresController::showCreateView, engine);
		Spark.get("/indicadores/:nombre/evaluar", indicadoresController::getEmpresaByName, engine);
		Spark.get("/metodologias/:nombre/evaluar", metodologiasController::getEmpresaByName, engine);
		Spark.post("/indicadores", indicadoresController::create, engine);
		
		
	}

}