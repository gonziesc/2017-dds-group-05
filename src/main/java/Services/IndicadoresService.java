package Services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import model.Empresa;
import model.Indicador;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.experimental.theories.Theories;
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
	

	public static List<Indicador> obtenerInicadoresDeServicioExterno() throws FileNotFoundException {
		/*Gson gson = new GsonBuilder()
			    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
			    .create();
		try {
			Type collectionType = new TypeToken<Collection<Indicador>>(){}.getType();
			List<Indicador> listaIndicadores = gson.fromJson(new FileReader(rutaArchivoJson), collectionType);
			return listaIndicadores;
		}catch (UserException  e) {
			noEncuentraElArchivo();
		}
		return null;*/
	
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			String hql = "FROM model.Indicador";
			Query query = session.createQuery(hql);
			List<Indicador> results = query.list();
			return results;
			
			
			
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
	public static void guardarIndicadoresEnServicioExterno(Indicador unIndicador) throws IOException {
		/*List<Indicador> listaIndicadores = obtenerInicadoresDeServicioExterno();
		listaIndicadores.add(unIndicador);
		ObjectMapper objectMapper = new ObjectMapper()
		.configure(SerializationFeature.INDENT_OUTPUT, true);
		try{
			String arrayToJson = objectMapper.writeValueAsString(listaIndicadores);
			FileWriter file = new FileWriter(rutaArchivoJson);
			file.write(arrayToJson);
            file.close();
			
		}catch (UserException  e) {
			noEncuentraElArchivo();
		}*/
		
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			session.saveOrUpdate(unIndicador);	
			session.getTransaction().commit();
			
		}
		
		
		catch (HibernateException e) {
			if (session.getTransaction() != null) {
	            session.getTransaction().rollback();
	          
	        }
			
		}
		finally {
	        session.close();
	    }
		
		
	}
	
	public static void noEncuentraElArchivo() throws UserException {
		throw new UserException ("No se encuentra el archivo en la ruta: " + rutaArchivoJson);
	}
	
	public static void set_rutaArchivoJson(String ruta){
		rutaArchivoJson = ruta;
	}
}
