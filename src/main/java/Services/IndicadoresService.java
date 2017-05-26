package Services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import model.Indicador;

import org.uqbar.commons.model.UserException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class IndicadoresService {
	static String rutaArchivoJson;

	public static List<Indicador> obtenerInicadoresDeServicioExterno() throws FileNotFoundException {
		Gson gson = new GsonBuilder()
			    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
			    .create();
		try {
			Type collectionType = new TypeToken<Collection<Indicador>>(){}.getType();
			List<Indicador> listaIndicadores = gson.fromJson(new FileReader(rutaArchivoJson), collectionType);
			return listaIndicadores;
		}catch (UserException  e) {
			noEncuentraElArchivo();
		}
		return null;
	}
	public static void guardarIndicadoresEnServicioExterno(Indicador unIndicador) throws IOException {
		List<Indicador> listaIndicadores = obtenerInicadoresDeServicioExterno();
		listaIndicadores.add(unIndicador);
		ObjectMapper objectMapper = new ObjectMapper();
		try{
			String arrayToJson = objectMapper.writeValueAsString(listaIndicadores);
			FileWriter file = new FileWriter("./resources/indicadores2.json");
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
