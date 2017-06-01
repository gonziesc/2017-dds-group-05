package viewmodel;

import org.uqbar.commons.utils.Observable;

import builder.BuilderIndicador;
import model.Parametro;

@Observable
public class Parametro1ViewModel extends ParametroViewModel{
	
	public Parametro1ViewModel(BuilderIndicador builder) {
		super(builder);
	}

	@Override
	void ingresarParametroSeleccionado(Parametro parametro) {
		this.getBuilderIndicador().setParametro1(parametro);	
	}
}
