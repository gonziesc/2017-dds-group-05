package MetodologiasTest;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import model.Empresa;
import model.Indicador;
import model.Metodologia;
import Mocks.IndicadorMock;
import Mocks.MetodologiaMock;
import Mocks.EmpresasMock;

import org.junit.Test;

public class MetodologiaTest {
	MetodologiaMock mock = new MetodologiaMock();
	
	
	
	@Test
	public void testCalculaBienUnaMetodologiaValor() {
		Metodologia unaMetodologia = mock.unaMetodologiaMayorValor();
		assertTrue((unaMetodologia.calcularMetodologia(mock.listaEmpresas())).size() == 2);
	}
	/*
	@Test
	public void testCalculaBienUnaMetodologiaValorMenor() {
		Metodologia unaMetodologia = mock.unaMetodologiaMenorValor();
		System.out.print(unaMetodologia.calcularMetodologia(mock.listaEmpresas()));
	}
	
	@Test
	public void testCalculaBienunaMetodologiaMayorValorTiempo() {
		Metodologia unaMetodologia = mock.unaMetodologiaMayorValorTiempo();
		System.out.print(unaMetodologia.calcularMetodologia(mock.listaEmpresas()));
	}
	
	@Test
	public void testCalculaBienunaMetodologiaAnios() {
		Metodologia unaMetodologia = mock.unaMetodologiaAnios();
		System.out.print(unaMetodologia.calcularMetodologia(mock.listaEmpresas()));
	}
	
	@Test
	public void testCalculaBienunaMetodologiaPromedio() {
		Metodologia unaMetodologia = mock.unaMetodologiaPromedio();
		System.out.print(unaMetodologia.calcularMetodologia(mock.listaEmpresas()));
	}
	
	@Test
	public void testCalculaBienunaMetodologiaUnoMayorQueOtro() {
		Metodologia unaMetodologia = mock.unaMetodologiaUnoMayorQueOtro();
		System.out.print(unaMetodologia.calcularMetodologia(mock.listaEmpresas()));
	}
	
	@Test
	public void testCalculaBienunaMetodologiaUnoMayorQueOtroEnElTiempo() {
		Metodologia unaMetodologia = mock.unaMetodologiaUnoMayorQueOtroEnElTiempo();
		System.out.print(unaMetodologia.calcularMetodologia(mock.listaEmpresas()));
	} */
}
