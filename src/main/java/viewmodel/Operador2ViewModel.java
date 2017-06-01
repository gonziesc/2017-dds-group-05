package viewmodel;

import org.uqbar.commons.utils.Observable;

import builder.BuilderIndicador;

@Observable
public class Operador2ViewModel extends OperadorViewModel {
	
	public Operador2ViewModel(BuilderIndicador builder) {
		super(builder);
	}

	@Override
	public void ingresarOperador(){
		this.getBuilderIndicador().setOperacion2(this.getOperador());
	}
}