package Services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import model.Empresa;
import model.Indicador;
import model.IndicadorEmpresa;
import model.Metodologia;
import model.Usuario;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.uqbar.commons.model.UserException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class IndicadoresService {
	static String rutaArchivoJson = "./resources/indicadores3.json";

	public static List<Indicador> obtenerIndicadoresDeServicioExterno() {
		/*
		 * Gson gson = new GsonBuilder()
		 * .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
		 * .create(); try { Type collectionType = new
		 * TypeToken<Collection<Indicador>>(){}.getType(); List<Indicador>
		 * listaIndicadores = gson.fromJson(new FileReader(rutaArchivoJson),
		 * collectionType); return listaIndicadores; }catch (UserException e) {
		 * noEncuentraElArchivo(); } return null;
		 */
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		try {

			session.beginTransaction();
			List<Indicador> results = (List<Indicador>) session.createQuery("FROM model.Indicador").getResultList();
			session.getTransaction().commit();
			return results;

		}

		catch (HibernateException e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}

		} finally {
			session.close();
		}
		return null;

	}

	public static List<Indicador> obtenerIndicadoresDeServicioExterno(Usuario user) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		try {

			session.beginTransaction();
			List<Indicador> results = (List<Indicador>) session.createQuery("from model.Indicador where user_id = :id")
					.setParameter("id", user.getId()).getResultList();
			session.getTransaction().commit();
			return results;

		}

		catch (HibernateException e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}

		} finally {
			session.close();
		}
		return null;

	}

	public static Indicador obtenerIndicadorPorNombre(String nombre) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		try {

			session.beginTransaction();
			Indicador result = session
					.createQuery("select indicador from model.Indicador indicador where indicador.nombre = :name",
							Indicador.class)
					.setParameter("name", nombre).setMaxResults(1).getSingleResult();
			session.getTransaction().commit();
			return result;

		}

		catch (HibernateException e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();

			}

		}

		finally {
			session.close();
		}

		return null;
	}

	public static void guardarIndicadoresEnServicioExterno(Indicador unIndicador) {
		/*
		 * List<Indicador> listaIndicadores = obtenerInicadoresDeServicioExterno();
		 * listaIndicadores.add(unIndicador); ObjectMapper objectMapper = new
		 * ObjectMapper() .configure(SerializationFeature.INDENT_OUTPUT, true); try{
		 * String arrayToJson = objectMapper.writeValueAsString(listaIndicadores);
		 * FileWriter file = new FileWriter(rutaArchivoJson); file.write(arrayToJson);
		 * file.close();
		 * 
		 * }catch (UserException e) { noEncuentraElArchivo(); }
		 */
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			session.persist(unIndicador);
			session.getTransaction().commit();

		}

		catch (HibernateException e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}

		}
	}

	public static void noEncuentraElArchivo() throws UserException {
		throw new UserException("No se encuentra el archivo en la ruta: " + rutaArchivoJson);
	}

	public static void set_rutaArchivoJson(String ruta) {
		rutaArchivoJson = ruta;
	}

	public static Indicador obtenerIndicadorPorId(Long id) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		Indicador indicador = session.find(Indicador.class, id);

		session.close();
		return indicador;

	}

	public static void guardarValorPrecalculado(Indicador indicador, Empresa empresa, int valor) {
		IndicadorEmpresa indicadorEmpresa = new IndicadorEmpresa();
		indicadorEmpresa.setEmpresa(empresa);
		indicadorEmpresa.setIndicador(indicador);
		indicadorEmpresa.setValor(valor);
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		IndicadorEmpresa ieEnDb = obtenerValorPrecalculado(indicador, empresa);
		if (ieEnDb == null) {
			try {
				session.beginTransaction();
				session.persist(indicadorEmpresa);
				session.getTransaction().commit();

			}

			catch (HibernateException e) {
				if (session.getTransaction() != null) {
					session.getTransaction().rollback();
				}

			}
		} else {

			try {
				session.beginTransaction();
				ieEnDb.setValor(valor);
				session.saveOrUpdate(ieEnDb);
				session.getTransaction().commit();

			}

			catch (HibernateException e) {
				if (session.getTransaction() != null) {
					session.getTransaction().rollback();
				}

			}
		}

	}

	public static IndicadorEmpresa obtenerValorPrecalculado(Indicador indicador, Empresa empresa) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		try {

			session.beginTransaction();
			List<IndicadorEmpresa> result = session
					.createQuery("from "
							+ "model.IndicadorEmpresa where empresa_id = :idEmpresa and indicador_id = :idIndicador",
							IndicadorEmpresa.class)
					.setParameter("idEmpresa", empresa.getId()).setParameter("idIndicador", indicador.getId())
					.setMaxResults(1).getResultList();
			if (result.isEmpty()) return null;
			return result.get(0);

		}

		catch (HibernateException e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();

			}

		}

		finally {
			session.close();
		}
		return null;

	}
}
