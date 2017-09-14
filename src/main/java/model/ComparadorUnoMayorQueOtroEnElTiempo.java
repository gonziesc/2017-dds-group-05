package model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.uqbar.commons.utils.Observable;

@Entity
@DiscriminatorValue(value = "ComparadorUno<QueOtroTiempo")
@Observable
public class ComparadorUnoMayorQueOtroEnElTiempo extends ComparadorOrden{
	private int cuentasMayoresUnaEmpresa; // Hackazo, si no declaro estos acumuladores como variables de instancia
	private int cuentasMayoresOtraEmpresa; //no me deja accederlos desde el lambda de comparar(...) por no ser final
	
	@Override
	public Empresa comparar(Empresa unaEmpresa, Empresa otraEmpresa, Indicador unIndicador, int anioDesde, int anioHasta) {
		List<Cuenta> cuentasPeriodoOtraEmpresa = otraEmpresa
				.cuentasSegunTiempo(anioDesde, anioHasta);
		cuentasMayoresUnaEmpresa = 0;
		cuentasMayoresOtraEmpresa = 0;
		unaEmpresa
				.cuentasSegunTiempo(anioDesde, anioHasta)
				.stream().forEach(
						c -> {
							if(cumpleConSuCuentaPareja(c, cuentasPeriodoOtraEmpresa, getOperando(), unIndicador))
								cuentasMayoresUnaEmpresa++; 
							else 
								cuentasMayoresOtraEmpresa++;});
		return this.procesarRetorno(unaEmpresa, otraEmpresa, (cuentasMayoresUnaEmpresa>cuentasMayoresOtraEmpresa));
	}

	@Override
	public String getNombreComparador(){
		return "Comparador uno mayor que otro en el tiempo";
	}
	
	protected Boolean cumpleConSuCuentaPareja(Cuenta cuenta,
			List<Cuenta> cuentasPeriodoOtraEmpresa, String comparador2, Indicador unIndicador) {
		return cuentasPeriodoOtraEmpresa.stream().allMatch(
				c -> cumpleCuentaPareja(cuenta, c, comparador2, unIndicador));
	}

	private Boolean cumpleCuentaPareja(Cuenta cuenta, Cuenta otraCuenta,
			String comparador2, Indicador unIndicador) {
		if (cuenta.getAnioCuenta() == otraCuenta.getAnioCuenta()) {
			return Operadores.compararOperacion(
					cargarIndicador(cuenta, unIndicador).getValor(),
					cargarIndicador(otraCuenta, unIndicador).getValor(),
					comparador2);
		}
		return true;
	}

}
