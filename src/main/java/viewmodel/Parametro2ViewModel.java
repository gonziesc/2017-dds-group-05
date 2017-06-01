package viewmodel;

import org.uqbar.commons.utils.Observable;

import builder.BuilderIndicador;
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
