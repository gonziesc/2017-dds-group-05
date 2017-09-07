package ORMtest;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import Mocks.IndicadorMock;
import model.Indicador;
import model.Usuario;
 

public class ormTest {
	@Test
	public void testApp() {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
 
		Usuario unUsuario = new Usuario();
		session.save(unUsuario);
		
		/*
		IndicadorMock indicadorMock = new IndicadorMock();
		Indicador unIndicador = indicadorMock.getUnIdicadorConstante();
		session.save(unIndicador);
		*/
 
		session.getTransaction().commit();
		session.close();
	}
}