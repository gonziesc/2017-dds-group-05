package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.lang.reflect.Type;

import org.uqbar.commons.utils.Observable;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


@Observable
public class CuentasService {
	static String rutaArchivoJson = "./resources/cuentas.json";

	public static List<Empresa> deJSONaCuenta() throws FileNotFoundException {
		Gson gson = new GsonBuilder()
			    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
			    .create();
		try {
			Type collectionType = new TypeToken<Collection<Empresa>>(){}.getType();
			List<Empresa> listaEmpresas = gson.fromJson(new FileReader(rutaArchivoJson), collectionType);
			return listaEmpresas;
		}catch (FileNotFoundException e) {
			noEncuentraElArchivo();
		}
		return null;
	}

	
	public static void noEncuentraElArchivo() throws FileNotFoundException{
		throw new FileNotFoundException("No se encuentra el archivo en la ruta: " + rutaArchivoJson);
	}
	
	public static void set_rutaArchivoJson(String ruta){
		rutaArchivoJson = ruta;
	}
	

}
