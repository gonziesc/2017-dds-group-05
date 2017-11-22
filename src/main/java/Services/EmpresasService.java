package Services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import java.lang.reflect.Type;

import model.Cuenta;
import model.Empresa;
import model.Indicador;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@Observable
public class EmpresasService {
	static String rutaArchivoJson = "./resources/cuentas.json";

	public static ArrayList<Empresa> obtenerEmpresasDeServicioJSON() throws FileNotFoundException {
		Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

		try {
			Type collectionType = new TypeToken<Collection<Empresa>>() {
			}.getType();
			ArrayList<Empresa> listaEmpresas = gson.fromJson(new FileReader(rutaArchivoJson), collectionType);
			return listaEmpresas;

		} catch (UserException e) {
			noEncuentraElArchivo();
		}

		return null;
	}

	public static ArrayList<Empresa> obtenerEmpresasDeServicioExterno() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		try {

			session.beginTransaction();
			ArrayList<Empresa> results = (ArrayList<Empresa>) session.createQuery("FROM model.Empresa").getResultList();
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

	public static Empresa obtenerEmpresaPorNombre(String nombre) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		try {

			session.beginTransaction();
			List<Empresa> empresas = session
					.createQuery("FROM model.Empresa where nombreempresa = :nombre", Empresa.class)
					.setParameter("nombre", nombre).setMaxResults(1).getResultList();
			session.getTransaction().commit();
			if (empresas.isEmpty()) return null;
			return empresas.get(0);

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

	public static void noEncuentraElArchivo() throws UserException {
		throw new UserException("No se encuentra el archivo en la ruta: " + rutaArchivoJson);
	}

	public static void set_rutaArchivoJson(String ruta) {
		rutaArchivoJson = ruta;
	}

	public static List<Cuenta> obtenerCuentasDeEmpresa(String nombre) throws FileNotFoundException {
		ArrayList<Empresa> listaEmpresas = obtenerEmpresasDeServicioJSON();
		List<Empresa> listaEMpresasFiltrada = listaEmpresas.stream()
				.filter(unaEmpresa -> unaEmpresa.nombreEmpresa.equals(nombre)).collect(Collectors.toList());
		System.out.println(listaEMpresasFiltrada);
		List<Cuenta> listaCuentas = listaEMpresasFiltrada.get(0).Cuentas;
		return listaCuentas;
	}

	public static void guardarEmpresaEnServicioExterno(Empresa unaEmpresa) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		Empresa empresaEnDb = obtenerEmpresaPorNombre(unaEmpresa.getNombreEmpresa());
		if (empresaEnDb == null) {
			try {
				session.beginTransaction();
				session.persist(unaEmpresa);
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
				empresaEnDb.getCuentas().forEach(cuenta -> session.delete(cuenta));
				empresaEnDb.setCuentas(unaEmpresa.getCuentas());
				session.saveOrUpdate(empresaEnDb);
				session.getTransaction().commit();

			}

			catch (HibernateException e) {
				if (session.getTransaction() != null) {
					session.getTransaction().rollback();
				}

			}
		}

	}

}
