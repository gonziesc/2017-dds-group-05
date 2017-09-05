package ORMtest;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import Mocks.IndicadorMock;
import model.Indicador;
 

public class ormTest {
	@Test
	public void testApp() {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
 
		IndicadorMock indicadorMock = new IndicadorMock();
		Indicador unIndicador = indicadorMock.getUnIdicadorConstante();
		session.save(unIndicador);
 
		session.getTransaction().commit();
		session.close();
	}
}