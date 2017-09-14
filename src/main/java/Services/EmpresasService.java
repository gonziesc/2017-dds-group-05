package Services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import java.lang.reflect.Type;

import model.Empresa;

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

	public static ArrayList<Empresa> obtenerEmpresasDeServicioExterno() throws FileNotFoundException {
		Gson gson = new GsonBuilder()
			    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
			    .create();

		try {
			Type collectionType = new TypeToken<Collection<Empresa>>(){}.getType();
			ArrayList<Empresa> listaEmpresas = gson.fromJson(new FileReader(rutaArchivoJson), collectionType);
			return listaEmpresas;
			
			
		}catch (UserException  e) {
			noEncuentraElArchivo();
		}
		

		return null;
	}
	
	public static void noEncuentraElArchivo() throws UserException {
		throw new UserException ("No se encuentra el archivo en la ruta: " + rutaArchivoJson);
	}
	
	public static void set_rutaArchivoJson(String ruta){
		rutaArchivoJson = ruta;
	}
	

}

