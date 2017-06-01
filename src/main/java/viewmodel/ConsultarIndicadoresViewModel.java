package viewmodel;

import java.io.FileNotFoundException;
import java.util.List;

import Services.IndicadoresService;
import model.Indicador;

public class ConsultarIndicadoresViewModel {
	
	private List<Indicador> indicadores;
	
	public void obtenerIndicadores(){
		try {
			setIndicadores(IndicadoresService.obtenerInicadoresDeServicioExterno());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Indicador> getIndicadores() {
		return indicadores;
	}

	public void setIndicadores(List<Indicador> indicadores) {
		this.indicadores = indicadores;
	}
}
