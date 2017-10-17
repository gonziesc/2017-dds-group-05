package controllers;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Services.IndicadoresService;
import builder.BuilderIndicador;
import model.Comparador;
import model.ComparadorFiltro;
import model.ComparadorOrden;
import model.Cuenta;
import model.Indicador;
import model.repositories.CuentasRepository;
import model.repositories.Repositorios;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class MetodologiasController {
	public ModelAndView getEmpresaByName(Request req, Response res){
		return new ModelAndView(null, "home/home.hbs");
	}
	
	public ModelAndView create(Request req, Response res){
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
		
		IndicadoresService.guardarIndicadoresEnServicioExterno(builder.build());
		
		return new ModelAndView(null, "home/home.hbs");
	}
	public ModelAndView showCreateView(Request req, Response res) throws FileNotFoundException{
		Map<String, List<ComparadorOrden>> modelComporden= new HashMap<>();
		Map<String, List<ComparadorFiltro>> modelCompFiltro= new HashMap<>();
		Map<String, List<Indicador>> modelIndicadores= new HashMap<>();
		
		List<Indicador> indicadores= IndicadoresService.obtenerInicadoresDeServicioExterno();
		List<ComparadorFiltro>comparadoresFiltro = Repositorios.metodologias.allComparadoresFiltro();
		List<ComparadorOrden>comparadoresOrden = Repositorios.metodologias.allComparadoresOrden();
		
		MetodologiasHandle handle = new MetodologiasHandle();
		
		modelCompFiltro.put("filtros", comparadoresFiltro);
		modelComporden.put("orden", comparadoresOrden);
		modelIndicadores.put("indicadores", indicadores);
		
		handle.setComparadorFiltro(modelCompFiltro);
		handle.setComparadorOrden(modelComporden);
		handle.setIndicadores(modelIndicadores);
						
		return new ModelAndView(handle, "metodologias/create.hbs");
	}
}
