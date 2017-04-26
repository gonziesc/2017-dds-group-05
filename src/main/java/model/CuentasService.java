package model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.lang.reflect.Type;

import org.uqbar.commons.utils.Observable;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Observable
public class CuentasService {
	public static List<Cuenta> deJSONaCuenta() {
		Gson gson = new Gson();
		try {
			Type type = new TypeToken<List<Cuenta>>() {
			}.getType();
			List<Cuenta> listaCuentas = gson.fromJson(new FileReader(
					"./resources/cuentas.json"), type);
			return listaCuentas;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void deCuentaAJSON(Cuenta unaCuenta) {
		List<Cuenta> listaCuentas = deJSONaCuenta();
		listaCuentas.add(unaCuenta);
		ObjectMapper objectMapper = new ObjectMapper();
		try{
			String arrayToJson = objectMapper.writeValueAsString(listaCuentas);
			FileWriter file = new FileWriter("./resources/cuentas.json");
			file.write(arrayToJson);
            file.close();
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
