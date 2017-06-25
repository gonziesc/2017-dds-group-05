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
		unaMetodologia.setUnaEmpresa(unaEmpresa);
		assertTrue(unaMetodologia.calcularMetodologia().getNombre() == "facebook");
	}
	@Test
	public void testCalculaBienUnaMetodologiaValorMenor() {
		Metodologia unaMetodologia = mock.unaMetodologiaMenorValor();
		unaMetodologia.setUnaEmpresa(unaEmpresa);
		assertTrue(unaMetodologia.calcularMetodologia() == null);
	}
	@Test
	public void testCalculaBienunaMetodologiaMayorValorTiempo() {
		Metodologia unaMetodologia = mock.unaMetodologiaMayorValorTiempo();
		unaMetodologia.setUnaEmpresa(unaEmpresa);
		assertTrue(unaMetodologia.calcularMetodologia().getNombre() == "facebook");
	}
	@Test
	public void testCalculaBienunaMetodologiaAnios() {
		Metodologia unaMetodologia = mock.unaMetodologiaAnios();
		unaMetodologia.setUnaEmpresa(unaEmpresa);
		assertTrue(unaMetodologia.calcularMetodologia().getNombre() == "facebook");
	}
	@Test
	public void testCalculaBienunaMetodologiaPromedio() {
		Metodologia unaMetodologia = mock.unaMetodologiaPromedio();
		unaMetodologia.setUnaEmpresa(unaEmpresa);
		assertTrue(unaMetodologia.calcularMetodologia().getNombre() == "facebook");
	}
	@Test
	public void testCalculaBienunaMetodologiaUnoMayorQueOtro() {
		Metodologia unaMetodologia = mock.unaMetodologiaUnoMayorQueOtro();
		unaMetodologia.setUnaEmpresa(unaEmpresa);
		unaMetodologia.setOtraEmpresa(otraEmpresa);
		assertTrue(unaMetodologia.calcularMetodologia().getNombre() == "facebook");
	}
	@Test
	public void testCalculaBienunaMetodologiaUnoMayorQueOtroEnElTiempo() {
		Metodologia unaMetodologia = mock.unaMetodologiaUnoMayorQueOtroEnElTiempo();
		unaMetodologia.setUnaEmpresa(unaEmpresa);
		unaMetodologia.setOtraEmpresa(otraEmpresa);
		assertTrue(unaMetodologia.calcularMetodologia().getNombre() == "facebook");
	}
}
