package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.uqbar.commons.utils.Observable;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Observable

public class CuentasService {
	
	public static Cuenta deJSONaCuenta() {
		JSONParser parser = new JSONParser();
		Cuenta unaCuenta = new Cuenta();
		
		try{
			JSONObject cuentaJson = (JSONObject) parser.parse(new FileReader("RUTA_DEL_ARCHIVO"));
			
			unaCuenta.setNombre_cuenta((String) cuentaJson.get("nombre_cuenta"));
			unaCuenta.setNumero_cuenta((int) cuentaJson.get("numero_cuenta"));
			unaCuenta.setGanancia((double) cuentaJson.get("ganancia"));
			//faltan agregar
			
			return unaCuenta;
		}
		
		catch (ParseException | IOException e){
			e.printStackTrace();
			return null;
		}
		
	
	}
}
