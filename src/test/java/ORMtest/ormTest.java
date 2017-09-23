package ORMtest;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.classmate.AnnotationConfiguration;

import Mocks.CuentaMock;
import Mocks.IndicadorMock;
import Mocks.MetodologiaMock;
import org.junit.Assert;
import model.Comparador;
import model.ComparadorAnios;
import model.ComparadorFiltro;
import model.ComparadorOrden;
import model.ComparadorPromedio;
import model.ComparadorUnoMayorQueOtro;
import model.ComparadorUnoMayorQueOtroEnElTiempo;
import model.ComparadorValor;
import model.ComparadorValorTiempo;
import model.Cuenta;
import model.Empresa;
import model.Indicador;
import model.Metodologia;
import model.Parametro;
import model.Usuario;
import model.parametroGeneral;
 

public class ormTest {
	SessionFactory sessionFactory;
	Session session;
	IndicadorMock indicadorMock = new IndicadorMock();
	CuentaMock cuentaMock = new CuentaMock();
	MetodologiaMock metodologiaMock = new MetodologiaMock();
	
    @Before
    public void before() {
    	Properties prop= new Properties();
		prop.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
		prop.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost/ddstest");
		prop.setProperty("hibernate.connection.password", "1234");
		prop.setProperty("hibernate.connection.username", "postgres");
		prop.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		prop.setProperty("show_sql", "true");
		prop.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		
		sessionFactory = new Configuration()
			   .addProperties(prop)
			   .addAnnotatedClass(Cuenta.class)
			   .addAnnotatedClass(Empresa.class)
			   .addAnnotatedClass(Metodologia.class)
			   .addAnnotatedClass(Indicador.class)
			   .addAnnotatedClass(parametroGeneral.class)
			   .addAnnotatedClass(ComparadorOrden.class)
			   .addAnnotatedClass(ComparadorFiltro.class)
			   .addAnnotatedClass(ComparadorPromedio.class)
			   .addAnnotatedClass(ComparadorUnoMayorQueOtro.class)
			   .addAnnotatedClass(ComparadorUnoMayorQueOtroEnElTiempo.class)
			   .addAnnotatedClass(ComparadorValor.class)
			   .addAnnotatedClass(ComparadorValorTiempo.class)
			   .addAnnotatedClass(ComparadorAnios.class)
			   .buildSessionFactory();
		
		session = sessionFactory.openSession();
		
    }
    
    @After
    public void after() {
    	
    	session.close();
    }
    

	
	@Test
	public void persistCuenta(){
		session.beginTransaction();
		Cuenta unaCuenta = new Cuenta();
		unaCuenta.setAnioCuenta(2017);
		unaCuenta.setNombreCuenta("EDITBA");
		unaCuenta.setValor(500000);
		session.persist(unaCuenta);
		session.getTransaction().commit();
		
	}
	
	@Test
	public void persistEmpresa(){
		session.beginTransaction();
		List<Cuenta> cuentas = new ArrayList<Cuenta>();
		Cuenta unaCuenta = cuentaMock.getUnaCuenta();
		cuentas.add(unaCuenta);
		session.persist(unaCuenta);
		
		Empresa unaEmpresa = new Empresa();
		unaEmpresa.setNombreEmpresa("Facebook");
		unaEmpresa.setCuentas(cuentas);
		
		session.persist(unaEmpresa);
		session.getTransaction().commit();
	}
	@Test
	public void persistIndicador(){
		session.beginTransaction();
		Indicador unIndicador = indicadorMock.getUnIdicadorConUnaConstanteYUnaCuenta();
		session.persist(unIndicador);
		session.getTransaction().commit();
		Long idIndicador = unIndicador.getId();
		
		Indicador indicador = session.find(Indicador.class, idIndicador);
		
		Assert.assertEquals(1000, indicador.getParametro2().getValor());
	}
	
	@Test
	public void persistMetodologia(){
		session.beginTransaction();
		Metodologia unaMetodologia = metodologiaMock.unaMetodologiaMayorValor();
		session.persist(unaMetodologia);
		session.getTransaction().commit();
		session.beginTransaction();
		Long idMetodologia = unaMetodologia.getId();

		Metodologia metodologia = session.find(Metodologia.class, idMetodologia);
		session.getTransaction().commit();
		Assert.assertEquals(10, metodologia.getUnIndicador().getValor());
	}
	@Test
	public void testHerencia() throws Exception{
		session.beginTransaction();
		ComparadorFiltro comp = new ComparadorPromedio();
		ComparadorFiltro comp2 = new ComparadorValor();
		
		comp.setNombreComparador("Comparador promedio");
		comp.setOperando("<");
		comp.setValor(2000);
		session.persist(comp);
		
		comp2.setNombreComparador("Comparador Valor");
		comp2.setOperando("<");
		comp2.setValor(3000);
		session.persist(comp2);
		session.getTransaction().commit();
		
		Long compId = comp.getId();
		
		ComparadorFiltro comparador = session.find(ComparadorFiltro.class, compId);
		Assert.assertEquals("Comparador promedio", comparador.getNombreComparador());
	}
	@Test
	public void obtenerCuentas(){
		session.beginTransaction();
		Cuenta unaCuenta = cuentaMock.getOtraCuenta();
		session.persist(unaCuenta);
		session.getTransaction().commit();
		
		Cuenta cuentap = session.find(Cuenta.class, unaCuenta.getId());
		Assert.assertEquals("FCF",cuentap.getNombreCuenta());
	}

}