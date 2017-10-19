package server;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Services.UsuariosService;
import model.Cuenta;
import model.Indicador;
import model.Parametro;
import model.Usuario;
import model.parametroGeneral;

public class Bootstrap {
	public static void main(String[] args) {
		new Bootstrap().init();
	}
	
	public void init(){	
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Cuenta unaCuenta = getOtraCuenta();
		Usuario user = new Usuario();
		
		session.beginTransaction();
		user.setContrasena("123");
		user.setUsuario("user3");
		session.persist(user);
		session.persist(unaCuenta);
		parametroGeneral parametroCuenta = new Parametro();
		parametroCuenta.setNombre(unaCuenta.getNombreCuenta());
		parametroCuenta.setValor(unaCuenta.getValor());
		Indicador unIndicador = new Indicador(parametroCuenta, null, null);
		unIndicador.setNombre("prueba1");
		unIndicador.setUser(user);
		session.persist(unIndicador);
		session.getTransaction().commit();
		
	}
	public Cuenta getOtraCuenta() {
		Cuenta otraCuenta = new Cuenta();
		otraCuenta.setValor(2000);
		otraCuenta.setNombreCuenta("Free Cash Flow");
		return otraCuenta;

	}
}
