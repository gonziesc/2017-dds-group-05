package CuentaServiceTest;

import static org.junit.Assert.*;
import model.Cuenta;
import model.Empresa;
import net.sf.oval.constraint.AssertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.omg.CORBA.UserException;
import org.mockito.Mock;

import Services.EmpresasService;

import com.google.gson.Gson;

import junit.framework.*;

public class EmpresaServiceTest {
		
	@Test
	public void testLeeBienDelArchivoJSON() throws IOException {
		EmpresasService.set_rutaArchivoJson("./resources/EJEMPLOS.JSON");
		List<Empresa> listaEmpresasTest = EmpresasService.obtenerEmpresasDeServicioExterno();
		assertFalse(listaEmpresasTest.isEmpty());
	}
	
	@Test(expected = FileNotFoundException.class)
	public void testTiraExcepcionSiNoPuedeLeerElArchivo() throws IOException {
		EmpresasService.set_rutaArchivoJson("./ruta_invalida.json");
		List<Empresa> listaEmpresasTest = EmpresasService.obtenerEmpresasDeServicioExterno();
	}
	
}
	
