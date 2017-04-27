package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

	public static List<Cuenta> deJSONaCuenta() throws FileNotFoundException {
		Gson gson = new GsonBuilder()
			    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
			    .create();
		try {
			Type type = new TypeToken<List<Cuenta>>() {
			}.getType();
			List<Cuenta> listaCuentas = gson.fromJson(new FileReader(rutaArchivoJson), type);
			return listaCuentas;
		}catch (FileNotFoundException e) {
			noEncuentraElArchivo();
		}
		return null;
	}
	
	public static void deCuentaAJSON(Cuenta unaCuenta) throws IOException {
		List<Cuenta> listaCuentas = deJSONaCuenta();
		listaCuentas.add(unaCuenta);
		ObjectMapper objectMapper = new ObjectMapper();
		try{
			String arrayToJson = objectMapper.writeValueAsString(listaCuentas);
			FileWriter file = new FileWriter(rutaArchivoJson);
			file.write(arrayToJson);
            file.close();
			
		}catch (FileNotFoundException e) {
			noEncuentraElArchivo();
		}
		
	}
	
	public static void noEncuentraElArchivo() throws FileNotFoundException{
		throw new FileNotFoundException("No se encuentra el archivo en la ruta: " + rutaArchivoJson);
	}
	
	public static void set_rutaArchivoJson(String ruta){
		rutaArchivoJson = ruta;
	}
	

}
