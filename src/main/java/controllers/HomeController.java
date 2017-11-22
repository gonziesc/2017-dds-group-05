package controllers;

import java.io.FileNotFoundException;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
		req.session().attribute("loggedIn", false);
		res.redirect("/",301);
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
				req.session().attribute("loggedIn", true);
				res.redirect("/",301);
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
	
	public ModelAndView showRegister(Request req, Response res)throws FileNotFoundException{
		return new ModelAndView(null, "home/register.hbs");
	}
	
	public ModelAndView register(Request req, Response res)throws FileNotFoundException{
		String usuario = req.queryParams("usuario");
		String contrasena = req.queryParams("contrasena");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		org.hibernate.Session session = sessionFactory.openSession();
				
		session.beginTransaction();
		Usuario user = new Usuario();
		user.setContrasena(contrasena);
		user.setUsuario(usuario);
		session.persist(user);
		session.getTransaction().commit();
		
		req.session().attribute("user",usuario); 
		req.session().attribute("loggedIn", true);
		
		return new ModelAndView(null, "home/index.hbs");
	}
	
	public void validar(Request req, Response res){
		if(Router.validar(req)&&!Router.esRutaPublica(req.url())){
			res.redirect("login/login.hbs",301);
		}
	}
	
}