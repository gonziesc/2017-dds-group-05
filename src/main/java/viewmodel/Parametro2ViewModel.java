package viewmodel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

import Services.EmpresasService;
import Services.IndicadoresService;

import builder.BuilderIndicador;

import model.Cuenta;
import model.Empresa;
import model.Indicador;

import model.Parametro;

@Observable

public class Parametro2ViewModel extends ParametroViewModel{


	public Parametro2ViewModel(BuilderIndicador builder) {
		super(builder);
	}

	@Override
	void ingresarParametroSeleccionado(Parametro parametro) {
		this.getBuilderIndicador().setParametro2(parametro);	
	}

}
