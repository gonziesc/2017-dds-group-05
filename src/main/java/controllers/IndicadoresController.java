package controllers;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder.In;

import Services.EmpresasService;
import Services.IndicadoresService;
import builder.BuilderIndicador;
import model.Cuenta;
import model.Empresa;
import model.Indicador;
import model.Usuario;
import model.repositories.CuentasRepository;
import server.Router;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class IndicadoresController {
	public ModelAndView create(Request req, Response res){
		if(Router.validar(req)){
			res.redirect("/");
			return new ModelAndView(null, "login/login.hbs");
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
		builder.setParametroAPartirVista(tipo, valor,false);
		builder.setParametroAPartirVista(tipo2, valor2,true);
		//Usuario user = req.session().attribute("user");
		//builder.setUser(user);
		
		IndicadoresService.guardarIndicadoresEnServicioExterno(builder.build());
		
		return new ModelAndView(null, "home/home.hbs");
	}
	
	public ModelAndView showCreateView(Request req, Response res) throws FileNotFoundException{
		if(Router.validar(req)){
			res.redirect("/");
			return new ModelAndView(null, "login/login.hbs");
		}
		String accion = Router.sesion(req);
		
	
		Map<String, List<Cuenta>> modelCuentas = new HashMap<>();
		Map<String, String> modelTipo= new HashMap<>();
		Map<String, List<Indicador>> modelIndicadores= new HashMap<>();
		List<Indicador> indicadores= IndicadoresService.obtenerIndicadoresDeServicioExterno();
		List<Cuenta>cuentas = CuentasRepository.obtenerCuentas();
		IndicadoresHandle handle = new IndicadoresHandle();
		
		modelTipo.put("accion", accion);
		modelCuentas.put("cuentas", cuentas);
		modelIndicadores.put("indicadores", indicadores);
		handle.setCuentas(modelCuentas);
		handle.setIndicadores(modelIndicadores);
		handle.setAccion(modelTipo);
						
		return new ModelAndView(handle, "indicadores/create.hbs");
	}

	public ModelAndView evaluar(Request req, Response res) throws FileNotFoundException{
		String nombreIndicador = req.params("nombre");
		Indicador indicador = IndicadoresService.obtenerIndicadorPorNombre(nombreIndicador);
		List<Empresa> listaEmpresas = EmpresasService.obtenerEmpresasDeServicioExterno();
		Map<String, List<Empresa>> empresas = new HashMap<>();
		List<Integer> valores = new ArrayList<Integer>();
		EmpresaHandle handler = new EmpresaHandle();
		
		
		empresas.put("empresas", listaEmpresas);
		//indicadores.put("indicadores", indicador.calcularValorEn(listaEmpresas));
		
		handler.setValor(indicador.calcularValorEn(listaEmpresas));
		handler.setEmpresas(empresas);
		
		return new ModelAndView(handler, "indicadores/evaluar.hbs");
	}
	
	public ModelAndView show (Request req, Response res){
		Map<String, List<Indicador>> modelIndicadores= new HashMap<>();
		List<Indicador> indicadores= IndicadoresService.obtenerIndicadoresDeServicioExterno();
		modelIndicadores.put("indicadores", indicadores);
		return new ModelAndView(modelIndicadores, "indicadores/indicadores.hbs");
	}
		
}

