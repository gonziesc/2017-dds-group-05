package Mocks;

import java.util.ArrayList;
import java.util.List;

import model.ComparadorAnios;
import model.ComparadorPromedio;
import model.ComparadorUnoMayorQueOtro;
import model.ComparadorUnoMayorQueOtroEnElTiempo;
import model.ComparadorValor;
import model.ComparadorValorTiempo;
import model.Empresa;
import model.Metodologia;

public class MetodologiaMock {
	
	public List<Empresa> listaEmpresas(){
		List<Empresa> listaEmpresas = new ArrayList<Empresa>();
		Empresa unaEmpresa = new EmpresasMock().Facebook();
		Empresa otraEmpresa = new EmpresasMock().Arcor();
		listaEmpresas.add(unaEmpresa);
		listaEmpresas.add(otraEmpresa);
		return listaEmpresas;
	}
	
	public Metodologia unaMetodologiaMayorValor(){
		ComparadorValor unComparador = new ComparadorValor();
		Metodologia unaMetodologia = new Metodologia();
		unaMetodologia.addComparadorParaFilatrado(unComparador);
		unaMetodologia.setUnIndicador(new IndicadorMock().getUnIdicadorConstante());
		return unaMetodologia;
	}

	public Metodologia unaMetodologiaMenorValor(){
		ComparadorValor unComparador = new ComparadorValor();
		Metodologia unaMetodologia = new Metodologia();
		unaMetodologia.addComparadorParaFilatrado(unComparador);
		unaMetodologia.setUnIndicador(new IndicadorMock().getUnIdicadorConstante());
		return unaMetodologia;
	}
	public Metodologia unaMetodologiaMayorValorTiempo(){
		ComparadorValorTiempo unComparador = new ComparadorValorTiempo();
		Metodologia unaMetodologia = new Metodologia();
		unaMetodologia.setPeriodoInicio(1999);
		unaMetodologia.setPeriodoFin(2017);
		unaMetodologia.addComparadorParaFilatrado(unComparador);
		unaMetodologia.setUnIndicador(new IndicadorMock().getUnIdicadorConstante());
		return unaMetodologia;
	}
	public Metodologia unaMetodologiaAnios(){
		ComparadorAnios unComparador = new ComparadorAnios();
		Metodologia unaMetodologia = new Metodologia();
		unaMetodologia.addComparadorParaFilatrado(unComparador);
		return unaMetodologia;
	}
	public Metodologia unaMetodologiaPromedio(){
		ComparadorPromedio unComparador = new ComparadorPromedio();
		Metodologia unaMetodologia = new Metodologia();
		unaMetodologia.setPeriodoInicio(1999);
		unaMetodologia.setPeriodoFin(2017);
		unaMetodologia.addComparadorParaFilatrado(unComparador);
		unaMetodologia.setUnIndicador(new IndicadorMock().getUnIdicadorConstante());
		return unaMetodologia;
	}
	public Metodologia unaMetodologiaUnoMayorQueOtro(){
		ComparadorUnoMayorQueOtro unComparador = new ComparadorUnoMayorQueOtro();
		Metodologia unaMetodologia = new Metodologia();
		unaMetodologia.setComparadorOrden(unComparador);
		unaMetodologia.setUnIndicador(new IndicadorMock().getUnIdicadorConstante());
		return unaMetodologia;
	}
	public Metodologia unaMetodologiaUnoMayorQueOtroEnElTiempo(){
		ComparadorUnoMayorQueOtroEnElTiempo unComparador = new ComparadorUnoMayorQueOtroEnElTiempo();
		Metodologia unaMetodologia = new Metodologia();
		unaMetodologia.setComparadorOrden(unComparador);
		unaMetodologia.setPeriodoInicio(1999);
		unaMetodologia.setPeriodoFin(2017);
		unaMetodologia.setUnIndicador(new IndicadorMock().getUnIdicadorConstante());
		return unaMetodologia;
	}
}
