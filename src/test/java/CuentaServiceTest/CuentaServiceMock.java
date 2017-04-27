package CuentaServiceTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.Cuenta;

public class CuentaServiceMock implements JsonService{
	public static String rutaArchivoJson ;
	
	public CuentaServiceMock(String rutaArchivo){
		rutaArchivoJson = rutaArchivo;
	}
	
	public static List<Cuenta> deJSONaCuenta() throws IOException {
		Gson gson = new Gson();
		try {
			Type type = new TypeToken<List<Cuenta>>() {
			}.getType();
			List<Cuenta> listaCuentas = gson.fromJson(new FileReader(rutaArchivoJson), type);
			return listaCuentas;
		}catch (IOException e) {
			noEncuentraElArchivo();
			return null;
		}
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
	public static void setRutaArchivoJson(String rutaArchivoJson) {
		CuentaServiceMock.rutaArchivoJson = rutaArchivoJson;
	}

	public static void noEncuentraElArchivo() throws FileNotFoundException{
		throw new FileNotFoundException("No se encuentra el archivo en la ruta: " + rutaArchivoJson);
	}
}
