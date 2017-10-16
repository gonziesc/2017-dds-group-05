package controllers;

import java.io.FileNotFoundException;
import java.util.List;

import Services.EmpresasService;
import Services.UsuariosService;
import model.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class HomeController {
	public ModelAndView home(Request req, Response res)throws FileNotFoundException{
		return new ModelAndView(null, "home/home.hbs");
	}
	
	
	public ModelAndView showLogin(Request req, Response res){
		String usuario = req.queryParams("usuario");
		String contrasena = req.queryParams("contrasena");
		List<Usuario> usuarios = UsuariosService.obtenerUsuariosDeServicioExterno();
		if(usuario == null || contrasena ==null){
			return new ModelAndView(null, "login/login.hbs");	
		}
		else{
			if((usuarios.stream().anyMatch(unUsuario -> (usuario.equals(unUsuario.getUsuario()) &&  contrasena.equals(unUsuario.getContrasena()))))){
				return new ModelAndView(null, "login/user.hbs");
			}
			else
			{
				return new ModelAndView(null, "login/login.hbs");
			}
		}	
			
			
		
	}
	
	public ModelAndView login(Request req, Response res){
		// NO ESTA HACIENDO NADA
		String usuario = req.queryParams("usuario");
		String contrasena = req.queryParams("contrasena");
		return new ModelAndView(null, "home/home.hbs");
	}
	
	
	
}