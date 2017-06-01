package viewmodel;

import org.uqbar.commons.utils.Observable;

import builder.BuilderIndicador;

@Observable
public class Operador1ViewModel extends OperadorViewModel {
		
	public Operador1ViewModel(BuilderIndicador builder) {
		super(builder);
	}

	@Override
	public void ingresarOperador(){
		this.getBuilderIndicador().setOperacion1(this.getOperador());
	}
}
