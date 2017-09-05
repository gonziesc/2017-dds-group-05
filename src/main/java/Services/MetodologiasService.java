package Services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.uqbar.commons.model.UserException;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import model.Metodologia;

public class MetodologiasService {
	static String rutaArchivoJson = "./resources/metodologias2.JSON";
	
	public static ArrayList<Metodologia> obtenerMetodologiasDeServicioExterno() throws FileNotFoundException {
		Gson gson = new GsonBuilder()
			    .create();
		try {
			Type collectionType = new TypeToken<Collection<Metodologia>>(){}.getType();
			ArrayList<Metodologia> listaMetodologias = gson.fromJson(new FileReader(rutaArchivoJson), collectionType);
			return listaMetodologias;
		}catch (UserException  e) {
			noEncuentraElArchivo();
		}
		return null;
	}
	public static void guardarMetodologiaEnServicioExterno(Metodologia unaMetodologia) throws IOException {
		ArrayList<Metodologia> listaMetodologias = obtenerMetodologiasDeServicioExterno();
		listaMetodologias.add(unaMetodologia);
		
		ObjectMapper objectMapper = new ObjectMapper()
		.configure(SerializationFeature.INDENT_OUTPUT, true)
		.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
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
	
	public static void set_rutaArchivoJson(String ruta){
		rutaArchivoJson = ruta;
	}
}
