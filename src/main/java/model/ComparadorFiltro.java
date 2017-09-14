package model;

public abstract class ComparadorFiltro extends Comparador{
	
	private int valor;

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	@Override
	public Empresa comparar(Empresa unaEmpresa, Empresa otraEmpresa, Indicador unIndicador, int fechaDesde, int fechaHasta) {
		//Aca tiene que ir un shouldNotImplement o separar la jerarquía -ilopetegui
		return null;
	}
}
