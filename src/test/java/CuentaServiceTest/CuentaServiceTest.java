package CuentaServiceTest;

import static org.junit.Assert.*;
import model.Cuenta;
import model.CuentasService;
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
import org.mockito.Mock;

import com.google.gson.Gson;

import junit.framework.*;

public class CuentaServiceTest {
	private Cuenta cuenta = new Cuenta();
	private Cuenta cuentaSinDatos = new Cuenta();

	@Before
	public void initCuenta() {
		cuenta.setNombre_cuenta("test");
		cuenta.setAnio_cuenta(2010);
		
	}

	@Test
	public void testCargaBienLaCuentaEnJson() throws IOException {
		CuentasService.set_rutaArchivoJson("./resources/EJEMPLOS.JSON");
		CuentasService.deCuentaAJSON(cuenta);
	}

	@Test
	public void testLeeBienDelArchivoJSON() throws IOException {
		CuentasService.set_rutaArchivoJson("./resources/EJEMPLOS.JSON");
		List<Cuenta> listaCuentasTest = CuentasService.deJSONaCuenta();
		assertEquals("test", listaCuentasTest.get(0).getNombre_cuenta());
	}

	@Test(expected = FileNotFoundException.class)
	public void testTiraExcepcionSiNoPuedeEscribirElArchivo()
			throws IOException {
		CuentasService.set_rutaArchivoJson("./ruta_invalida.json");
		CuentasService.deCuentaAJSON(cuenta);
	}

	@Test(expected = FileNotFoundException.class)
	public void testTiraExcepcionSiNoPuedeLeerElArchivo() throws IOException {
		CuentasService.set_rutaArchivoJson("./ruta_invalida.json");
		List<Cuenta> listaCuentasTest = CuentasService.deJSONaCuenta();
	}
	
	@Test
	public void testNoDevuelveNadaPorServiceImpostor() throws IOException{
		CuentaServiceMock.set_rutaArchivoJson("./resources/EJEMPLOS.JSON");
		List<Cuenta> listaCuentasTest = CuentaServiceMock.deJSONaCuenta();
		equals(listaCuentasTest == null);
	}
	
	@Test
	public void testNoEscribeNadaPorServiceImpostor() throws IOException{
		CuentaServiceMock.set_rutaArchivoJson("./resources/nuncaEscriboNada.JSON");
		CuentaServiceMock.deCuentaAJSON(cuenta);
		File contenido = new File("./resources/nuncaEscriboNada.JSON");
		assertTrue(contenido.length() == 0);
	}
	
	/*	
	@Test
	 	 public void testCargaBienLaCuentaEnJson() throws IOException{
	 		CuentasService cuentasMockosa = Mockito.mock(CuentasService.class);
	 		Mockito.verify(cuentasMockosa);
	 		CuentasService.deCuentaAJSON(cuenta);
	 		
	 	}
	 	
	 	
	 	
	 @Test
	 	 public void testTiraExcepcionSiNoPuedeEncontrarElArchivo() throws IOException{
	 		CuentasService cuentasMockosa = Mockito.mock(CuentasService.class);
	 		cuentasMockosa.set_rutaArchivoJson("./ruta_invalida/");
	 		Mockito.doThrow(new FileNotFoundException()).when(cuentasMockosa);
	 		CuentasService.deCuentaAJSON(cuenta);
	 			
	 	}
	 	
	 @Test
	 	public void testLeeBienDelArchivoJSON() {
	 		List<Cuenta> listaCuentasTest = null;
	 		Mockito.when(CuentasService.deJSONaCuenta()).thenReturn(listaCuentasTest);
	 		Assert.assertNull(listaCuentasTest);
	 	}
	 	
	 @Test
	 	 public void testTiraExcepcionSiNoPuedeLeerElArchivo() {
	 		CuentasService cuentasMockosa = Mockito.mock(CuentasService.class);
	 		cuentasMockosa.set_rutaArchivoJson("./ruta_invalida/");
	 		Mockito.doThrow(new FileNotFoundException()).when(cuentasMockosa);
	 		CuentasService.deJSONaCuenta();		
	 	}
	 	*/

}
