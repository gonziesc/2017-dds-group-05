package CalcularIndicadorTest;

import static org.junit.Assert.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import model.Indicador;
import Mocks.IndicadorMock;

import org.junit.Before;
import org.junit.Test;

import Services.IndicadoresService;


public class IndicadorTest {
	IndicadorMock indicadorMock = new IndicadorMock();
	@Before
	public void init() throws IOException{
		FileWriter file = new FileWriter("./resources/indicadores2.json");
		file.write("[]");
        file.close();
	}
	@Test
	public void testCalculaBienUnIndicadorConstante() {
		Indicador unIndicador = indicadorMock.getUnIdicadorConstante();
		assertTrue(unIndicador.obtenerValor() == 10);
	}
	@Test
	public void testCalculaBienUnIndicadorConOtroIndicador() {
		Indicador unIndicador = indicadorMock.getUnIdicadorConOtroIndicador();
		assertTrue(unIndicador.obtenerValor() == 10);
	}
	@Test
	public void testCalculaBienUnIndicadorConDosIndicadoresYUnaConstante() {
		Indicador unIndicador = indicadorMock.getUnIdicadorConDosIndicadoresYUnaConstante();
		assertTrue(unIndicador.obtenerValor() == 4020);
	}
	
	@Test
	public void testCalculaBienUnIndicadorConUnaCuentaYUnaConstante() {
		Indicador unIndicador = indicadorMock.getUnIdicadorConUnaConstanteYUnaCuenta();
		assertTrue(unIndicador.obtenerValor() == 1010);
	}
	@Test
	public void testCalculaBienUnIndicadorConDosCuentas() {
		Indicador unIndicador = indicadorMock.getUnIdicadorConDosCuentas();
		assertTrue(unIndicador.obtenerValor() == 3000);
	}
	@Test
	public void testCalculaBienUnIndicadorConDosCuentasYUnaConstante() {
		Indicador unIndicador = indicadorMock.getUnIdicadorConDosCuentasYUnaConstante();
		assertTrue(unIndicador.obtenerValor() == 3010);
	}
	@Test
	public void testCalculaBienUnIndicadorConTresCuentas() {
		Indicador unIndicador = indicadorMock.getUnIdicadorConTresCuentas();
		assertTrue(unIndicador.obtenerValor() == 4000);
	}
	@Test
	public void testLeeBienDelServicioExterno() throws IOException {
		IndicadoresService.set_rutaArchivoJson("./resources/indicadores.JSON");
		List<Indicador> listIndicadoresTest = IndicadoresService.obtenerInicadoresDeServicioExterno();
		assertTrue(listIndicadoresTest.size() == 3);
	}
	@Test
	public void elValorDelPrimerElementoGuardadoEn() throws IOException {
		IndicadoresService.set_rutaArchivoJson("./resources/indicadores.JSON");
		List<Indicador> listIndicadoresTest = IndicadoresService.obtenerInicadoresDeServicioExterno();
		Indicador unIndicador = listIndicadoresTest.get(0);
		assertTrue(unIndicador.obtenerValor() == 4020);
	}
	@Test
	public void testEscribeBienEnServicioExterno() throws IOException {
        IndicadoresService.set_rutaArchivoJson("./resources/indicadores2.JSON");
		Indicador unIndicador = indicadorMock.getUnIdicadorConTresCuentas();
		IndicadoresService.guardarIndicadoresEnServicioExterno(unIndicador);
		List<Indicador> listIndicadoresTest = IndicadoresService.obtenerInicadoresDeServicioExterno();
		Indicador otroIndicador = listIndicadoresTest.get(0);
		assertTrue(otroIndicador.obtenerValor() == 4000);
	}
	@Test
	public void testEscribeBienEnServicioExternoConIndicadorDeIndicadores() throws IOException {
        IndicadoresService.set_rutaArchivoJson("./resources/indicadores2.JSON");
		Indicador unIndicador = indicadorMock.getUnIdicadorConDosIndicadoresYUnaConstante();
		IndicadoresService.guardarIndicadoresEnServicioExterno(unIndicador);
		List<Indicador> listIndicadoresTest = IndicadoresService.obtenerInicadoresDeServicioExterno();
		Indicador otroIndicador = listIndicadoresTest.get(0);
		assertTrue(otroIndicador.obtenerValor() == 4020);
	}
	
}
