package ORMtest;
 
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Mocks.CuentaMock;
import Mocks.IndicadorMock;
import Mocks.MetodologiaMock;
import org.junit.Assert;
import model.Comparador;
import model.ComparadorAnios;
import model.ComparadorOrden;
import model.ComparadorPromedio;
import model.ComparadorValor;
import model.Cuenta;
import model.Empresa;
import model.Indicador;
import model.Metodologia;
import model.Parametro;
import model.Usuario;
import model.parametroGeneral;
 

public class ormTest {
	SessionFactory sessionFactory = new Configuration().configure()
			.buildSessionFactory();
	Session session = sessionFactory.openSession();
	IndicadorMock indicadorMock = new IndicadorMock();
	CuentaMock cuentaMock = new CuentaMock();
	MetodologiaMock metodologiaMock = new MetodologiaMock();
	
	@Before
	public void initOrm(){
		if(!session.getTransaction().isActive()){
			session.beginTransaction();
		}
	}
	@After
	public void clean(){
		session.getTransaction().rollback();
		
		session.close();
	}
	
	@Test
	public void testApp() {
		Usuario unUsuario = new Usuario();
		session.persist(unUsuario);
	}
	@Test
	public void persistCuenta(){
		Cuenta unaCuenta = new Cuenta();
		unaCuenta.setAnioCuenta(2017);
		unaCuenta.setNombreCuenta("EDITBA");
		unaCuenta.setValor(500000);
		session.persist(unaCuenta);
		
	}
	@Test
	public void persistEmpresa(){
		List<Cuenta> cuentas = new ArrayList<Cuenta>();
		Cuenta unaCuenta = cuentaMock.getUnaCuenta();
		cuentas.add(unaCuenta);
		session.persist(unaCuenta);
		
		Empresa unaEmpresa = new Empresa();
		unaEmpresa.setNombreEmpresa("Facebook");
		unaEmpresa.setCuentas(cuentas);
		
		session.persist(unaEmpresa);
	}
	@Test
	public void persistIndicador(){
		Indicador unIndicador = indicadorMock.getUnIdicadorConUnaConstanteYUnaCuenta();
		session.persist(unIndicador);
		
		Long idIndicador = unIndicador.getId();
		
		Indicador indicador = session.find(Indicador.class, idIndicador);
		
		Assert.assertEquals(1000, indicador.getParametro2().getValor());
	}
	
	@Test
	public void persistMetodologia(){
		Metodologia unaMetodologia = metodologiaMock.unaMetodologiaMayorValor();
		session.persist(unaMetodologia);
		Long idMetodologia = unaMetodologia.getId();

		Metodologia metodologia = session.find(Metodologia.class, idMetodologia);

		Assert.assertEquals(10, metodologia.getUnIndicador().getValor());
	}
	@Test
	public void testHerencia() throws Exception{
		ComparadorOrden comp = new ComparadorPromedio();
		ComparadorOrden comp2 = new ComparadorValor();
		
		comp.setNombreComparador("Comparador promedio");
		comp.setOperando("<");
		comp.setValor(2000);
		session.persist(comp);
		
		comp2.setNombreComparador("Comparador Valor");
		comp2.setOperando("<");
		comp2.setValor(3000);
		session.persist(comp2);
		
		Long compId = comp.getId();
		
		Comparador comparador = session.find(Comparador.class, compId);
		Assert.assertEquals("Comparador promedio", comparador.getNombreComparador());
	}
	@Test
	public void obtenerCuentas(){
		Cuenta unaCuenta = cuentaMock.getOtraCuenta();
		session.persist(unaCuenta);
		
		Cuenta cuentap = session.find(Cuenta.class, unaCuenta.getId());
		Assert.assertEquals("FCF",cuentap.getNombreCuenta());
	}

}