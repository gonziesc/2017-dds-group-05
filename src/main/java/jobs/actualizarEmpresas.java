package jobs;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.TimerTask;

import Services.EmpresasService;
import model.Empresa;

public class actualizarEmpresas  extends TimerTask {

	@Override
	public void run() {
		ArrayList<Empresa> empresasEnJson;
		try {
			empresasEnJson = EmpresasService.obtenerEmpresasDeServicioJSON();
			empresasEnJson.forEach(empresa -> EmpresasService.guardarEmpresaEnServicioExterno(empresa));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
