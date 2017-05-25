package CalcularIndicadorTest;

import static org.junit.Assert.*;

import java.io.Console;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import model.Empresa;
import model.Indicador;
import model.repositories.Repositorios;

import org.junit.Test;

import Services.EmpresasService;
import Services.IndicadoresService;


public class IndicadorTest {
	@Test
	public void testCalculaBienUnIndicadorConstante() {
		Indicador unIndicador = Repositorios.indicadores.getUnIdicadorConstante();
		assertTrue(unIndicador.obtenerValor() == 10);
	}
	
	@Test
	public void testCalculaBienUnIndicadorConUnaCuentaYUnaConstante() {
		Indicador unIndicador = Repositorios.indicadores.getUnIdicadorConUnaConstanteYUnaCuenta();
		assertTrue(unIndicador.obtenerValor() == 1010);
	}
	@Test
	public void testCalculaBienUnIndicadorConDosCuentas() {
		Indicador unIndicador = Repositorios.indicadores.getUnIdicadorConDosCuentas();
		assertTrue(unIndicador.obtenerValor() == 3000);
	}
	@Test
	public void testCalculaBienUnIndicadorConDosCuentasYUnaConstante() {
		Indicador unIndicador = Repositorios.indicadores.getUnIdicadorConDosCuentasYUnaConstante();
		assertTrue(unIndicador.obtenerValor() == 3010);
	}
	@Test
	public void testCalculaBienUnIndicadorConTresCuentas() {
		Indicador unIndicador = Repositorios.indicadores.getUnIdicadorConTresCuentas();
		assertTrue(unIndicador.obtenerValor() == 4000);
	}
	@Test
	public void testLeeBienDelServicioExterno() throws IOException {
		EmpresasService.set_rutaArchivoJson("./resources/indicadores.JSON");
		List<Indicador> listIndicadoresTest = IndicadoresService.obtenerInicadoresDeServicioExterno();
		assertTrue(listIndicadoresTest.size() == 4);
	}
	@Test
	public void elValorDelPrimerElementoGuardadoEn() throws IOException {
		EmpresasService.set_rutaArchivoJson("./resources/indicadores.JSON");
		List<Indicador> listIndicadoresTest = IndicadoresService.obtenerInicadoresDeServicioExterno();
		Indicador unIndicador = listIndicadoresTest.get(0);
		unIndicador.definirCalculador();
		assertTrue(unIndicador.obtenerValor() == 4000);
	}
	@Test
	public void testEscribeBienEnServicioExterno() throws IOException {
		EmpresasService.set_rutaArchivoJson("./resources/indicadores2.JSON");
		Indicador unIndicador = Repositorios.indicadores.getUnIdicadorConTresCuentas();
		Indicador otroIndicador = Repositorios.indicadores.getUnIdicadorConstante();
		IndicadoresService.guardarIndicadoresEnServicioExterno(unIndicador);
		IndicadoresService.guardarIndicadoresEnServicioExterno(otroIndicador);
	}
}
