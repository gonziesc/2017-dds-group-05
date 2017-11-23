package controllers;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Services.IndicadoresService;
import Services.MetodologiasService;
import Services.UsuariosService;
import builder.BuilderMetodologia;
import model.ComparadorFiltro;
import model.ComparadorOrden;
import model.Indicador;
import model.repositories.Repositorios;
import server.Router;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import model.Empresa;
import model.Metodologia;
import model.Usuario;
import Services.EmpresasService;

public class MetodologiasController {
	private Usuario encontrarSesionDe(Request req) {
		String user = req.session().attribute("user");
		return UsuariosService.obtenerUsuarioDeServicioExterno(user);
	}
	
	public ModelAndView create(Request req, Response res){
		if(Router.validar(req)&&!Router.esRutaPublica(req.url())){
			res.redirect("login/login.hbs",301);
		}
		BuilderMetodologia builder = new BuilderMetodologia();
		builder.setPeriodoFin(Integer.parseInt(req.queryParams("periodoFin")));
		builder.setUnIndicador(IndicadoresService.obtenerIndicadorPorId(Long.getLong(req.queryParams("indicador"))));
		builder.setNombre(req.queryParams("nombre"));
		builder.setPeriodoInicio(Integer.parseInt(req.queryParams("periodoInicio")));
		
		
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
		if(Router.validar(req)&&!Router.esRutaPublica(req.url())){
			res.redirect("login/login.hbs",301);
		}
		
		Usuario user = encontrarSesionDe(req);
		List<Indicador> indicadores= IndicadoresService.obtenerIndicadoresDeServicioExterno(user);
		List<ComparadorFiltro>comparadoresFiltro = Repositorios.metodologias.allComparadoresFiltro();
		List<ComparadorOrden>comparadoresOrden = Repositorios.metodologias.allComparadoresOrden();
		
		Map<String, List<Indicador>> modelIndicadores= new HashMap<>();
		Map<String, List<ComparadorOrden>> modelComporden= new HashMap<>();
		Map<String, List<ComparadorFiltro>> modelCompFiltro= new HashMap<>();
				
		MetodologiasHandle handle = new MetodologiasHandle();

		modelCompFiltro.put("filtros", comparadoresFiltro);
		modelComporden.put("orden", comparadoresOrden);
		modelIndicadores.put("indicadores", indicadores);

		handle.setComparadorFiltro(modelCompFiltro);
		handle.setComparadorOrden(modelComporden);
		handle.setIndicadores(modelIndicadores);

		return new ModelAndView(handle, "metodologias/create.hbs");
	}

	public ModelAndView show (Request req, Response res) throws FileNotFoundException{
		if(Router.validar(req)&&!Router.esRutaPublica(req.url())){
			res.redirect("login/login.hbs",301);
		}
		Map<String, List<Metodologia>> model= new HashMap<>();
		List<Metodologia> lista = MetodologiasService.obtenerMetodologiasDeServicioExterno();
		model.put("metodologias", lista);
		return new ModelAndView(model, "metodologias/metodologias.hbs");
	}
	public ModelAndView evaluarMetodologia(Request req, Response res) throws FileNotFoundException{
		if(Router.validar(req)&&!Router.esRutaPublica(req.url())){
			res.redirect("login/login.hbs",301);
		}
		String nombre = req.params("nombre");
		Map<String, List<Empresa>> model = new HashMap<>();

		List<Empresa> empresas = EmpresasService.obtenerEmpresasDeServicioExterno();
		Metodologia metodologia = MetodologiasService.obtenerMetodologiaDeServicioExterno(nombre);
		metodologia.calcularMetodologia(empresas);

		model.put("empresas", empresas);

		return new ModelAndView(model, "metodologias/evaluar.hbs");
	}
}
