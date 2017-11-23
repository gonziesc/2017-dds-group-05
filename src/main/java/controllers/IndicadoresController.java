package controllers;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Convert;
import javax.persistence.criteria.CriteriaBuilder.In;

import Services.EmpresasService;
import Services.IndicadoresService;
import Services.UsuariosService;
import builder.BuilderIndicador;
import model.Cuenta;
import model.Empresa;
import model.Indicador;
import model.Parametro;
import model.Usuario;
import model.parametroGeneral;
import model.repositories.CuentasRepository;
import server.Router;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class IndicadoresController {
	public ModelAndView create(Request req, Response res){
		if(Router.validar(req)&&!Router.esRutaPublica(req.url())){
			res.redirect("login/login.hbs",301);
		}
		String nombre = req.queryParams("nombre");
		String operador= req.queryParams("operador");
		
		String tipo= req.queryParams("tipo");
		String[] valor= req.queryParamsValues("valor");
		
		String tipo2= req.queryParams("tipo2");
		String[] valor2= req.queryParamsValues("valor2");	
		
		BuilderIndicador builder = new BuilderIndicador();
		builder.setNombre(nombre);
		builder.setOperacion(operador);
		Parametro parametro1 = new Parametro();
		parametro1.setValor(3);
		Parametro parametro2 = new Parametro();
		parametro2.setValor(4);
		builder.setParametro(parametro1);
		builder.setParametroFinal(parametro2);
		Usuario user = encontrarSesionDe(req);
		builder.setUser(user);
		builder.setNombre(nombre);
		builder.setOperacion(operador);
		
		IndicadoresService.guardarIndicadoresEnServicioExterno(builder.build());

		return new ModelAndView(null, "home/index.hbs");
	}

	public ModelAndView showCreateView(Request req, Response res) throws FileNotFoundException {
		if (Router.validar(req) && !Router.esRutaPublica(req.url())) {
			res.redirect("login/login.hbs", 301);
		}
		Map<String, List<Indicador>> modelIndicadores= new HashMap<>();
		Map<String, List<Cuenta>> modelCuentas = new HashMap<>();
		
		Usuario user = encontrarSesionDe(req);
		List<Indicador> indicadores = IndicadoresService.obtenerIndicadoresDeServicioExterno(user);
		List<Cuenta> cuentas = CuentasRepository.obtenerCuentas();
		IndicadoresHandle handle = new IndicadoresHandle();

		modelCuentas.put("cuentas", cuentas);
		modelIndicadores.put("indicadores", indicadores);
		handle.setCuentas(modelCuentas);
		handle.setIndicadores(modelIndicadores);
		return new ModelAndView(handle, "indicadores/create.hbs");
	}


	public ModelAndView show (Request req, Response res){
		if(Router.validar(req)&&!Router.esRutaPublica(req.url())){
			res.redirect("login/login.hbs",301);
		}
		Map<String, List<Indicador>> modelIndicadores= new HashMap<>();
		Usuario user = encontrarSesionDe(req);
		
		List<Indicador> indicadores= IndicadoresService.obtenerIndicadoresDeServicioExterno(user);
		modelIndicadores.put("indicadores", indicadores);
		return new ModelAndView(modelIndicadores, "indicadores/indicadores.hbs");
	}
	
	public ModelAndView evaluar(Request req, Response res) throws FileNotFoundException{
		if(Router.validar(req)&&!Router.esRutaPublica(req.url())){
			res.redirect("login/login.hbs",301);
		}
		
		String nombreIndicador = req.params("nombre");
		Indicador indicador = IndicadoresService.obtenerIndicadorPorNombre(nombreIndicador);
		List<Empresa> listaEmpresas = EmpresasService.obtenerEmpresasDeServicioExterno();
		Map<String, List<Empresa>> empresas = new HashMap<>();
		EmpresaHandle handler = new EmpresaHandle();

		empresas.put("empresas", listaEmpresas);
		
		Integer valor = IndicadoresService.obtenerValorPrecalculado(indicador, listaEmpresas.get(0)).valor;
		handler.setValor(valor.toString());
		handler.setEmpresas(empresas);

		return new ModelAndView(handler, "indicadores/evaluar.hbs");
	}

	private Usuario encontrarSesionDe(Request req) {
		String user = req.session().attribute("user");
		return UsuariosService.obtenerUsuarioDeServicioExterno(user);
	}

}
