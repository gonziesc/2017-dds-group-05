package Services;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import model.Indicador;
import model.Usuario;



public class UsuariosService {
	public static Usuario obtenerUsuarioDeServicioExterno(String name, String pass) {
		 SessionFactory sessionFactory = new Configuration().configure()
				 .buildSessionFactory();
		 Session session = sessionFactory.openSession();
		 
		 try {
				
				session.beginTransaction();
				Usuario results = (Usuario) session.createQuery("from model.usuario where usuario = :name and contrasena = :pass")
						.setParameter("name", name)
						.setParameter("pass", pass)
						.getSingleResult();
				session.getTransaction().commit();
				return results;
				
			}
			
			catch (HibernateException e) {
				if (session.getTransaction() != null) {
		            session.getTransaction().rollback();
		        }
				
			}
			finally{
				session.close();
			}
			return null;

		}
	public static List<Usuario> obtenerUsuariosDeServicioExterno() {
	 SessionFactory sessionFactory = new Configuration().configure()
			 .buildSessionFactory();
	 Session session = sessionFactory.openSession();
	 
	 try {
			
			session.beginTransaction();
			List<Usuario> results = (List<Usuario>) session.createQuery("FROM model.Usuario").getResultList();
			session.getTransaction().commit();
			return results;
			
		}
		
		catch (HibernateException e) {
			if (session.getTransaction() != null) {
	            session.getTransaction().rollback();
	        }
			
		}
		finally{
			session.close();
		}
		return null;

	}
	/*
	public static int obtenerUsuarioDeServicioExterno(String usu, String contra) {
		 SessionFactory sessionFactory = new Configuration().configure()
				 .buildSessionFactory();
		 Session session = sessionFactory.openSession();
		 
		 try {
				
				session.beginTransaction();
				Usuario results = (Usuario) session.createQuery("FROM model.Usuario where usuario= :usu AND contrasena= :contra ");
				((Query) session).setParameter("usu", usu);
				((Query) session).setParameter("contra",contra );

				session.getTransaction().commit();
				return 1;
				
			}
			
			catch (HibernateException e) {
				if (session.getTransaction() != null) {
		            session.getTransaction().rollback();
		        }
				return 0;
				
			}
			finally{
				session.close();
			}
		//	return 0;

		}
		*/

	public static void guardarUsuario(Usuario user) {
		SessionFactory sessionFactory = new Configuration().configure()
				 .buildSessionFactory();
		 Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			session.persist(user);	
			session.getTransaction().commit();
			
		}
		
		
		catch (HibernateException e) {
			if (session.getTransaction() != null) {
	            session.getTransaction().rollback();
	        }
			
		}
		
	}

}
