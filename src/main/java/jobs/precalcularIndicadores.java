package jobs;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import Services.EmpresasService;
import Services.IndicadoresService;
import model.Empresa;
import model.Indicador;

public class precalcularIndicadores extends TimerTask {

	@Override
	public void run() {
		ArrayList<Empresa> empresas = EmpresasService.obtenerEmpresasDeServicioExterno();
		List<Indicador> indicadores = IndicadoresService.obtenerIndicadoresDeServicioExterno();
		indicadores.forEach(indicador -> {
			empresas.forEach(empresa -> {
				int valor = indicador.calcularIndicadorEn(empresa);
				IndicadoresService.guardarValorPrecalculado(indicador, empresa, valor);
			});
		});
	}

}