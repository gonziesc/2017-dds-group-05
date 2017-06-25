package Mocks;


import java.util.ArrayList;
import java.util.List;

import model.Empresa;
import model.Cuenta;

public class EmpresasMock {
	public Empresa Facebook(){
		Empresa fb = new Empresa();
		List<Cuenta> cuentas = new ArrayList<Cuenta>();
		Cuenta unaCuenta2011 = new Cuenta();
		unaCuenta2011.setAnioCuenta(2011);
		unaCuenta2011.setNombreCuenta("cuenta1");
		unaCuenta2011.setValor(100000);
		Cuenta unaCuenta2012 = new Cuenta();
		unaCuenta2012.setAnioCuenta(2012);
		unaCuenta2012.setNombreCuenta("cuenta2");
		unaCuenta2012.setValor(200000);
		Cuenta unaCuenta2013 = new Cuenta();
		unaCuenta2013.setAnioCuenta(2013);
		unaCuenta2013.setNombreCuenta("cuenta3");
		unaCuenta2013.setValor(300000);
		cuentas.add(unaCuenta2011);
		cuentas.add(unaCuenta2012);
		cuentas.add(unaCuenta2013);
		fb.setNombre("facebook");
		fb.setCuentas(cuentas);
		return fb;
	}
	public Empresa Arcor(){
		Empresa arcor = new Empresa();
		List<Cuenta> cuentas = new ArrayList<Cuenta>();
		Cuenta unaCuenta2011 = new Cuenta();
		unaCuenta2011.setAnioCuenta(2011);
		unaCuenta2011.setNombreCuenta("cuenta1");
		unaCuenta2011.setValor(1000);
		Cuenta unaCuenta2012 = new Cuenta();
		unaCuenta2012.setAnioCuenta(2012);
		unaCuenta2012.setNombreCuenta("cuenta2");
		unaCuenta2012.setValor(2000);
		Cuenta unaCuenta2013 = new Cuenta();
		unaCuenta2013.setAnioCuenta(2014);
		unaCuenta2013.setNombreCuenta("cuenta3");
		unaCuenta2013.setValor(3000);
		cuentas.add(unaCuenta2011);
		cuentas.add(unaCuenta2012);
		cuentas.add(unaCuenta2013);
		arcor.setNombre("arcor");
		arcor.setCuentas(cuentas);
		return arcor;
	}
}
