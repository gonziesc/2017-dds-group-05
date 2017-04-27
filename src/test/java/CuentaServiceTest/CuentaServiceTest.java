package CuentaServiceTest;

import model.Cuenta;
import model.CuentasService;
import viewmodel.CargarCuentaViewModel;


import java.io.FileNotFoundException;
import java.io.IOException;
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
	public void initCuenta(){
		cuenta.setNombre_cuenta("test");
		cuenta.setAmortizacion(3.0);
		cuenta.setAnio_cuenta(2010);
		cuenta.setDepreciacion(3.0);
		cuenta.setNumero_cuenta(111111);

	}
	

	
	@Test
	 public void testCargaBienLaCuentaEnJson() throws IOException{
		CuentasService cuentasMockosa = Mockito.mock(CuentasService.class);
		Mockito.verify(cuentasMockosa);
		CuentasService.deCuentaAJSON(cuenta);
		
	}
	
	
	/*
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
	/*
	@Test
	 public void testTiraExcepcionSiNoPuedeLeerElArchivo() {
		CuentasService cuentasMockosa = Mockito.mock(CuentasService.class);
		cuentasMockosa.set_rutaArchivoJson("./ruta_invalida/");
		Mockito.doThrow(new FileNotFoundException()).when(cuentasMockosa);
		CuentasService.deJSONaCuenta();		
	}
	*/
	
	
	
	
}
