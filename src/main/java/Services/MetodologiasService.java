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
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import model.Metodologia;

public class MetodologiasService {
	static String rutaArchivoJson = "./resources/metodologias.JSON";
	
	public static List<Metodologia> obtenerMetodologiasDeServicioExterno() throws FileNotFoundException {
		Gson gson = new GsonBuilder()
			    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
			    .create();
		try {
			Type collectionType = new TypeToken<Collection<Metodologia>>(){}.getType();
			List<Metodologia> listaMetodologias = gson.fromJson(new FileReader(rutaArchivoJson), collectionType);
			return listaMetodologias;
		}catch (UserException  e) {
			noEncuentraElArchivo();
		}
		return null;
	}
	
	public static void guardarMetodologiasEnServicioExterno(Metodologia unaMetodologia) throws IOException {
		List<Metodologia> listaMetodologias = obtenerMetodologiasDeServicioExterno();
		listaMetodologias.add(unaMetodologia);
		ObjectMapper objectMapper = new ObjectMapper();
		try{
			String arrayToJson = objectMapper.writeValueAsString(listaMetodologias);
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
}
