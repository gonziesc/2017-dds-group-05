package view;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import model.Indicador;
import viewmodel.ConsultarValorCuentaViewModel;

@SuppressWarnings("serial")
public class IndicadoresView extends Window<Indicador> {
	public IndicadoresView(WindowOwner owner) {
		super(owner, new Indicador());

	}

	public void createContents(Panel mainPanel) {
		this.setTitle("Ingreso de indicadores");
		mainPanel.setLayout(new VerticalLayout());
		
		new Label(mainPanel).bindValueToProperty("operador");
		crearBotonesDeOperadores(mainPanel);

	}

	public void crearBotonesDeOperadores(Panel mainPanel) {
		new Button(mainPanel).setCaption("+").setWidth(100);
		new Button(mainPanel).setCaption("-");
		new Button(mainPanel).setCaption("*");
		new Button(mainPanel).setCaption("/");
		new Button(mainPanel).setCaption("(");
		new Button(mainPanel).setCaption(")");
		
	}
	

}
