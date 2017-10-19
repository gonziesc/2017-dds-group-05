package server;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
		//Cuenta unaCuenta = getOtraCuenta();
		
		session.beginTransaction();
		//session.persist(unaCuenta);
		Usuario user = new Usuario();
		user.setContrasena("1234");
		user.setUsuario("unuser");
		session.persist(user);
		/*parametroGeneral parametroCuenta = new Parametro();
		parametroCuenta.setNombre(unaCuenta.getNombreCuenta());
		parametroCuenta.setValor(unaCuenta.getValor());
		Indicador unIndicador = new Indicador(parametroCuenta, null, null);
		unIndicador.setNombre("prueba2");
		unIndicador.setUser(user);*/
		//session.persist(unIndicador);
		session.getTransaction().commit();
		
	}
	public Cuenta getOtraCuenta() {
		Cuenta otraCuenta = new Cuenta();
		otraCuenta.setValor(3000);
		otraCuenta.setNombreCuenta("EBITDA");
		return otraCuenta;

	}
}
