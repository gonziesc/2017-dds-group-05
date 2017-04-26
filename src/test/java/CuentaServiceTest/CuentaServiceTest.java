package CuentaServiceTest;

import model.Cuenta;
import model.CuentasService;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.*;

import com.google.gson.Gson;

import junit.framework.Assert;


public class CuentaServiceTest {
	private Cuenta cuenta = new Cuenta();
	
	@Before
	public void initCuenta(){
		cuenta.setNombre_cuenta("test");
		cuenta.setAmortizacion(3.0);
		cuenta.setAnio_cuenta(2010);
		cuenta.setDepreciacion(3.0);
		cuenta.setNumero_cuenta(111111);
	}
	
	@Test
	 public void testCargaBienLaCuentaEnJson(){
		/*CuentasService jsonServiceMock = Mockito.mock(CuentasService.class);
		initCuenta();
		
		Mockito.verify(jsonServiceMock, Mockito.only()).deCuentaAJSON(cuenta);*/
	}
	
	@Test
	public void testLeeBienDelArchivoJSON(){
		CuentasService jsonServiceMock = Mockito.mock(CuentasService.class);
		Mockito.verify(jsonServiceMock, Mockito.atLeastOnce()).deJSONaCuenta();
	}
}
