package model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ComparadorOrden extends Comparador{
	
	protected Empresa procesarRetorno(Empresa unaEmpresa, Empresa otraEmpresa, Boolean condicion) {
		if (condicion)
			return unaEmpresa;
		else
			return otraEmpresa;
	}
	
	@Override
	public Boolean comparar(Empresa unaEmpresa, Indicador unIndicador, int fechaDesde, int fechaHasta){
		return null; //Aca tiene que ir un shouldNotImplement o separar la jerarquía -ilopetegui
	}
	
}
