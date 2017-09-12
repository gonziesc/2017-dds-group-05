package model;

public class ComparadorAnios extends ComparadorOrden{
	
	@Override
	public Empresa comparar(Empresa unaEmpresa, Empresa otraEmpresa, Indicador unIndicador) {
		Boolean condicion = Operadores.compararOperacion(unaEmpresa.aniosEmpresa(),
				getValor(), getOperando());
		return this.procesarRetorno(unaEmpresa, otraEmpresa, condicion);
	}

	@Override
	public String getNombreComparador(){
		return "Comparador por anios";
	}

}
