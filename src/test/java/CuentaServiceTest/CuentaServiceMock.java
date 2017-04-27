package CuentaServiceTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.Cuenta;

public class CuentaServiceMock implements JsonService {
	public static String rutaArchivoJson;

	public static List<Cuenta> deJSONaCuenta() throws IOException {
		return null;
	}

	public static void deCuentaAJSON(Cuenta unaCuenta) throws IOException {

	}

	public static void set_rutaArchivoJson(String rutaArchivoJson) {
		CuentaServiceMock.rutaArchivoJson = rutaArchivoJson;
	}

	public static void noEncuentraElArchivo() throws FileNotFoundException {
		throw new FileNotFoundException(
				"No se encuentra el archivo en la ruta: " + rutaArchivoJson);
	}
}
