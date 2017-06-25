package Mocks;

import model.ComparadorAnios;
import model.ComparadorPromedio;
import model.ComparadorUnoMayorQueOtro;
import model.ComparadorUnoMayorQueOtroEnElTiempo;
import model.ComparadorValor;
import model.ComparadorValorTiempo;
import model.Metodologia;

public class MetodologiaMock {
	public Metodologia unaMetodologiaMayorValor(){
		ComparadorValor unComparador = new ComparadorValor();
		Metodologia unaMetodologia = new Metodologia(unComparador);
		unaMetodologia.setValor(1);
		unaMetodologia.setComparadorOperando(">");
		unaMetodologia.setUnIndicador(new IndicadorMock().getUnIdicadorConstante());
		return unaMetodologia;
	}
	public Metodologia unaMetodologiaMenorValor(){
		ComparadorValor unComparador = new ComparadorValor();
		Metodologia unaMetodologia = new Metodologia(unComparador);
		unaMetodologia.setValor(1);
		unaMetodologia.setComparadorOperando("<");
		unaMetodologia.setUnIndicador(new IndicadorMock().getUnIdicadorConstante());
		return unaMetodologia;
	}
	public Metodologia unaMetodologiaMayorValorTiempo(){
		ComparadorValorTiempo unComparador = new ComparadorValorTiempo();
		Metodologia unaMetodologia = new Metodologia(unComparador);
		unaMetodologia.setValor(1);
		unaMetodologia.setPeriodoInicio(1999);
		unaMetodologia.setPeriodoFin(2017);
		unaMetodologia.setComparadorOperando(">");
		unaMetodologia.setUnIndicador(new IndicadorMock().getUnIdicadorConstante());
		return unaMetodologia;
	}
	public Metodologia unaMetodologiaAnios(){
		ComparadorAnios unComparador = new ComparadorAnios();
		Metodologia unaMetodologia = new Metodologia(unComparador);
		unaMetodologia.setValor(1);
		unaMetodologia.setComparadorOperando(">");
		return unaMetodologia;
	}
	public Metodologia unaMetodologiaPromedio(){
		ComparadorPromedio unComparador = new ComparadorPromedio();
		Metodologia unaMetodologia = new Metodologia(unComparador);
		unaMetodologia.setValor(1);
		unaMetodologia.setPeriodoInicio(1999);
		unaMetodologia.setPeriodoFin(2017);
		unaMetodologia.setComparadorOperando(">");
		unaMetodologia.setUnIndicador(new IndicadorMock().getUnIdicadorConstante());
		return unaMetodologia;
	}
	public Metodologia unaMetodologiaUnoMayorQueOtro(){
		ComparadorUnoMayorQueOtro unComparador = new ComparadorUnoMayorQueOtro();
		Metodologia unaMetodologia = new Metodologia(unComparador);
		unaMetodologia.setComparadorOperando(">");
		unaMetodologia.setUnIndicador(new IndicadorMock().getUnIdicadorConstante());
		unaMetodologia.setOtroIndicador(new IndicadorMock().getUnIdicadorConstanteMasBajo());
		return unaMetodologia;
	}
	public Metodologia unaMetodologiaUnoMayorQueOtroEnElTiempo(){
		ComparadorUnoMayorQueOtroEnElTiempo unComparador = new ComparadorUnoMayorQueOtroEnElTiempo();
		Metodologia unaMetodologia = new Metodologia(unComparador);
		unaMetodologia.setComparadorOperando(">");
		unaMetodologia.setPeriodoInicio(1999);
		unaMetodologia.setPeriodoFin(2017);
		unaMetodologia.setUnIndicador(new IndicadorMock().getUnIdicadorConstante());
		unaMetodologia.setOtroIndicador(new IndicadorMock().getUnIdicadorConstanteMasBajo());
		return unaMetodologia;
	}
}
