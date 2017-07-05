package MetodologiasTest;

import static org.junit.Assert.assertTrue;
import model.Empresa;
import model.Indicador;
import model.Metodologia;
import Mocks.IndicadorMock;
import Mocks.MetodologiaMock;
import Mocks.EmpresasMock;

import org.junit.Test;

public class MetodologiaTest {
	MetodologiaMock mock = new MetodologiaMock();
	Empresa unaEmpresa = new EmpresasMock().Facebook();
	Empresa otraEmpresa = new EmpresasMock().Arcor();
	
	@Test
	public void testCalculaBienUnaMetodologiaValor() {
		Metodologia unaMetodologia = mock.unaMetodologiaMayorValor();
		assertTrue(unaMetodologia.calcularMetodologia(unaEmpresa,null).getNombreEmpresa() == "facebook");
	}
	@Test
	public void testCalculaBienUnaMetodologiaValorMenor() {
		Metodologia unaMetodologia = mock.unaMetodologiaMenorValor();
		assertTrue(unaMetodologia.calcularMetodologia(unaEmpresa,null) == null);
	}
	
	@Test
	public void testCalculaBienunaMetodologiaMayorValorTiempo() {
		Metodologia unaMetodologia = mock.unaMetodologiaMayorValorTiempo();
		assertTrue(unaMetodologia.calcularMetodologia(unaEmpresa,null).getNombreEmpresa() == "facebook");
	}
	
	@Test
	public void testCalculaBienunaMetodologiaAnios() {
		Metodologia unaMetodologia = mock.unaMetodologiaAnios();
		assertTrue(unaMetodologia.calcularMetodologia(unaEmpresa,null).getNombreEmpresa() == "facebook");
	}
	
	@Test
	public void testCalculaBienunaMetodologiaPromedio() {
		Metodologia unaMetodologia = mock.unaMetodologiaPromedio();
		assertTrue(unaMetodologia.calcularMetodologia(unaEmpresa,null).getNombreEmpresa() == "facebook");
	}
	
	@Test
	public void testCalculaBienunaMetodologiaUnoMayorQueOtro() {
		Metodologia unaMetodologia = mock.unaMetodologiaUnoMayorQueOtro();
		assertTrue(unaMetodologia.calcularMetodologia(unaEmpresa,otraEmpresa).getNombreEmpresa() == "facebook");
	}
	
	@Test
	public void testCalculaBienunaMetodologiaUnoMayorQueOtroEnElTiempo() {
		Metodologia unaMetodologia = mock.unaMetodologiaUnoMayorQueOtroEnElTiempo();
		assertTrue(unaMetodologia.calcularMetodologia(unaEmpresa,otraEmpresa).getNombreEmpresa() == "facebook");
	}
}
