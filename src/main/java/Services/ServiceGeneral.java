package Services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import org.uqbar.commons.model.UserException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import model.Metodologia;

public class ServiceGeneral {
	
	public ServiceGeneral(String ruta){
		rutaArchivoJson = ruta;
	}
	
	static String rutaArchivoJson;
	
	public static <T> List<T> obtenerDeServicioExterno() throws FileNotFoundException {
		Gson gson = new GsonBuilder()
			    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
			    .create();
		try {
			Type collectionType = new TypeToken<Collection<Metodologia>>(){}.getType();
			List<T> lista = gson.fromJson(new FileReader(rutaArchivoJson), collectionType);
			return lista;
		}catch (UserException  e) {
			noEncuentraElArchivo();
		}
		return null;
	}
	
	
	@SuppressWarnings("unchecked")
	public static <T> void guardarEnServicioExterno(Class<T> nuevoElemento) throws IOException {
		List<T> lista = obtenerDeServicioExterno();
		lista.add((T) nuevoElemento);
		
		ObjectMapper objectMapper = new ObjectMapper().configure(SerializationFeature.INDENT_OUTPUT, true);
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		try{
			String arrayToJson = objectMapper.writeValueAsString(lista);
			FileWriter file = new FileWriter(rutaArchivoJson);
			file.write(arrayToJson);
            file.close();
			
		}catch (UserException  e) {
			noEncuentraElArchivo();
		}
	}

	public static void noEncuentraElArchivo() throws UserException {
		throw new UserException ("No se encuentra el archivo en la ruta: " + rutaArchivoJson);
	}
	
	public static void set_rutaArchivoJson(String ruta){
		rutaArchivoJson = ruta;
	}
	
}
