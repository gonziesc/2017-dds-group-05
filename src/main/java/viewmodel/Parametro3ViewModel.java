package viewmodel;

import org.uqbar.commons.utils.Observable;

import builder.BuilderIndicador;
import model.Parametro;

@Observable
public class Parametro3ViewModel extends ParametroViewModel{

	public Parametro3ViewModel(BuilderIndicador builder) {
		super(builder);
	}

	@Override
	void ingresarParametroSeleccionado(Parametro parametro) {
		this.getBuilderIndicador().setParametro3(parametro);	
	}
}
