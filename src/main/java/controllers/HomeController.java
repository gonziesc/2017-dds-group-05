package controllers;

import java.io.FileNotFoundException;
import java.util.List;

import Services.EmpresasService;
import Services.UsuariosService;
import model.Usuario;
import server.Router;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Session;

public class HomeController {
	public ModelAndView home(Request req, Response res)throws FileNotFoundException{
		if(Router.validar(req)){
		 	return new ModelAndView(null, "home/menu.hbs");
		}
		return new ModelAndView(null, "home/index.hbs");
	}
	
	public ModelAndView showLogOut(Request req, Response res)throws FileNotFoundException{
		return new ModelAndView(null, "home/logout.hbs");
	}
	
	public ModelAndView logOut(Request req, Response res)throws FileNotFoundException{
		req.session().attribute("user",null); 
		res.redirect("/");
		return new ModelAndView(null, "home/menu.hbs");
	}
	
	
	public ModelAndView showLogin(Request req, Response res){
		String usuario = req.queryParams("usuario");
		String contrasena = req.queryParams("contrasena");
		List<Usuario> usuarios = UsuariosService.obtenerUsuariosDeServicioExterno();
		if(usuario == null || contrasena == null){
			return new ModelAndView(null, "login/login.hbs");	
		}
		else{
			if(this.loginOk(usuario,contrasena,usuarios)){
				req.session().attribute("user",usuario); 
				res.redirect("/");
				return new ModelAndView(null, "home/home.hbs");
			}
			else
			{
				return new ModelAndView(null, "login/login.hbs");
			}
		}	
			
	}
	public Boolean loginOk(String usuario, String contrasena, List<Usuario> usuarios){
		return (usuarios.stream().anyMatch(unUsuario -> (usuario.equals(unUsuario.getUsuario()) &&  contrasena.equals(unUsuario.getContrasena()))));
	}
	
	public ModelAndView login(Request req, Response res){
		String usuario = req.queryParams("usuario");
		String contrasena = req.queryParams("contrasena");
		Usuario user = manejarUser(usuario, contrasena);

		//req.session().attribute("usr", user);
		
		return new ModelAndView(null, "home/home.hbs");
	}
	public Usuario manejarUser(String name, String contrasena){
		Usuario user = new Usuario();
		user.setContrasena(contrasena);
		user.setUsuario(name);
		//UsuariosService.guardarUsuario(user);
		return user;
		//return UsuariosService.obtenerUsuarioDeServicioExterno(name, contrasena);
	}
	
	
	
}