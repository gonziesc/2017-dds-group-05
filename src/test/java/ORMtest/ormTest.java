package ORMtest;
 
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Mocks.CuentaMock;
import Mocks.IndicadorMock;
import Mocks.MetodologiaMock;
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
	}
	@Test
	public void testApp() {
		
		Usuario unUsuario = new Usuario();
		session.save(unUsuario);
		
		/*
		IndicadorMock indicadorMock = new IndicadorMock();
		Indicador unIndicador = indicadorMock.getUnIdicadorConstante();
		session.save(unIndicador);
		*/
 
		//session.getTransaction().commit();
		//session.close();
	}
	@Test
	public void persistCuenta(){
		Cuenta unaCuenta = new Cuenta();
		unaCuenta.setAnioCuenta(2017);
		unaCuenta.setNombreCuenta("EDITBA");
		unaCuenta.setValor(500000);
		
		session.save(unaCuenta);
	}
	@Test
	public void persistEmpresa(){
		List<Cuenta> cuentas = new ArrayList<Cuenta>();
		Cuenta unaCuenta = cuentaMock.getUnaCuenta();
		cuentas.add(unaCuenta);
		
		Empresa unaEmpresa = new Empresa();
		unaEmpresa.setNombreEmpresa("Facebook");
		unaEmpresa.setCuentas(cuentas);
		
		session.save(unaEmpresa);
	}
	@Test
	public void persistIndicador(){
		Indicador unIndicador = indicadorMock.getUnIdicadorConUnaConstanteYUnaCuenta();
		
		session.save(unIndicador);
	}
	
	@Test
	public void persistMetodologia(){
		Metodologia unaMetodologia = metodologiaMock.unaMetodologiaAnios();
		
		session.save(unaMetodologia);
	}
}