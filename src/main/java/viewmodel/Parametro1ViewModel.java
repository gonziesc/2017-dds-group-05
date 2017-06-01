package viewmodel;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.internal.runners.statements.ExpectException;
import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.model.UserException;
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
