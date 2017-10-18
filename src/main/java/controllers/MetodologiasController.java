package controllers;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Services.IndicadoresService;
import Services.MetodologiasService;
import builder.BuilderIndicador;
import builder.BuilderMetodologia;
import model.Comparador;
import model.ComparadorFiltro;
import model.ComparadorOrden;
import model.Cuenta;
import model.Indicador;
import model.repositories.CuentasRepository;
import model.repositories.Repositorios;
import server.Router;
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
		if(Router.validar(req)){
			return new ModelAndView(null, "login/login.hbs");
		}
		
		String nombre = req.params("nombre");
		Map<String, List<Empresa>> model = new HashMap<>();
		
		List<Empresa> empresas = EmpresasService.obtenerEmpresasDeServicioExterno();
		Metodologia metodologia = MetodologiasService.obtenerMetodologiaDeServicioExterno(nombre);
		metodologia.calcularMetodologia(empresas);
	
		model.put("empresas", empresas);
		
		return new ModelAndView(model, "metodologias/evaluar.hbs");
	}
	
	public ModelAndView create(Request req, Response res){
		if(Router.validar(req)){
			return new ModelAndView(null, "login/login.hbs");
		}
		
		BuilderMetodologia builder = new BuilderMetodologia();
		builder.setNombre(req.queryParams("nombre"));
		builder.setPeriodoInicio(Integer.parseInt(req.queryParams("periodoInicio")));
		builder.setPeriodoFin(Integer.parseInt(req.queryParams("periodoFin")));
		builder.setUnIndicador(IndicadoresService.obtenerIndicadorPorId(Long.getLong(req.queryParams("indicador"))));
		
		if(req.queryParams("hayOrdenable")== "on"){
			String nombre= req.queryParams("orden");
			builder.setComparadorOrden(Repositorios.metodologias.allComparadoresOrden().stream().filter(comp -> comp.getNombreComparador() == nombre).findFirst().get());
		}
		
		if(req.queryParams("hayFiltro") == "on"){
			String nombre = req.queryParams("filtro");
			ComparadorFiltro comparador = Repositorios.metodologias.allComparadoresFiltro().stream().filter(comp -> comp.getNombreComparador() == nombre).findFirst().get();
			builder.addComparadorParaFiltrado(comparador);
		}
		
		
		MetodologiasService.guardarMetodologiaEnServicioExterno(builder.build());
		
		return new ModelAndView(null, "home/home.hbs");
	}
	public ModelAndView showCreateView(Request req, Response res) throws FileNotFoundException{
		if(Router.validar(req)){
			return new ModelAndView(null, "login/login.hbs");
		}
		String accion = Router.sesion(req);
		
		Map<String, List<ComparadorOrden>> modelComporden= new HashMap<>();
		Map<String, List<ComparadorFiltro>> modelCompFiltro= new HashMap<>();
		Map<String, String> modelTipo= new HashMap<>();
		Map<String, List<Indicador>> modelIndicadores= new HashMap<>();
		
		List<Indicador> indicadores= IndicadoresService.obtenerInicadoresDeServicioExterno();
		List<ComparadorFiltro>comparadoresFiltro = Repositorios.metodologias.allComparadoresFiltro();
		List<ComparadorOrden>comparadoresOrden = Repositorios.metodologias.allComparadoresOrden();
		
		MetodologiasHandle handle = new MetodologiasHandle();
		
		modelTipo.put("accion", accion);
		modelCompFiltro.put("filtros", comparadoresFiltro);
		modelComporden.put("orden", comparadoresOrden);
		modelIndicadores.put("indicadores", indicadores);
		
		handle.setComparadorFiltro(modelCompFiltro);
		handle.setComparadorOrden(modelComporden);
		handle.setIndicadores(modelIndicadores);
		handle.setAccion(modelTipo);
						
		return new ModelAndView(handle, "metodologias/create.hbs");
	}
	
	public ModelAndView show (Request req, Response res){
		return new ModelAndView(null, "metodologias/metodologias.hbs");
	}
}
