
package view;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.RadioSelector;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.UserException;

import builder.BuilderIndicador;
import model.Cuenta;
import model.Indicador;
import viewmodel.ParametroViewModel;

@SuppressWarnings("serial")
public class Parametro1View extends ParametroView {
	public Parametro1View(WindowOwner owner,BuilderIndicador builder) {
		super(owner, builder);
	}
	
	@Override
	public void createContents(Panel mainPanel) {
		this.setTitle("Ingreso de indicadores");
		mainPanel.setLayout(new VerticalLayout());
		cargarDatosParaIndicador(mainPanel);
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		// TODO Auto-generated method stub
		
	}
}

