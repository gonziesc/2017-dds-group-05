package ComparadorTest;

import static org.junit.Assert.*;
import model.Empresa;
import model.Indicador;
import model.ComparadorAnios;
import model.ComparadorUnoMayorQueOtro;
import org.junit.Test;
import Mocks.EmpresasMock;
import Mocks.IndicadorMock;

public class ComparadorTest {
	
	EmpresasMock mockEmpresas = new EmpresasMock();
	IndicadorMock mockIndicadores = new IndicadorMock();
	Empresa facebook = mockEmpresas.Facebook();
	Empresa arcor = mockEmpresas.Arcor();
	Indicador indicador = mockIndicadores.getUnIdicadorConUnaConstanteYUnaCuenta();
	
	@Test
	public void testComparadorDeOrden(){
		ComparadorUnoMayorQueOtro comparador = new ComparadorUnoMayorQueOtro();
		comparador.setOperando(">");
		assertEquals(comparador.comparar(facebook, arcor, indicador, 0, 10000), facebook);
	}
	
	@Test
	public void testComparadorFiltrado(){
		ComparadorAnios comparador = new ComparadorAnios();
		comparador.setOperando(">");
		comparador.setValor(1);
		assertTrue(comparador.comparar(facebook, indicador, 0, 10000));
	}

	@Test(expected = Exception.class) 
	public void testComparadorDeOrdenNoFiltra() throws Exception{
		ComparadorUnoMayorQueOtro comparador = new ComparadorUnoMayorQueOtro();
		comparador.comparar(facebook, indicador, 0, 10000);
		//Debe fallar, arreglar implemetacion para que tire excepcion
	}

	@Test(expected = Exception.class) 
	public void testComparadorFiltradoNoOrdena()throws Exception{
		ComparadorAnios comparador = new ComparadorAnios();
			comparador.comparar(facebook, arcor, indicador, 0, 10000);
		//Debe fallar, arreglar implemetacion para que tire excepcion
	}
}
	
