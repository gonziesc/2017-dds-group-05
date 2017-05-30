package view;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import Services.EmpresasService;
import viewmodel.StartWindowViewModel;

public class StartWindow extends SimpleWindow<StartWindowViewModel> {

	public StartWindow(WindowOwner parent) {
		super(parent, new StartWindowViewModel());
		// TODO Auto-generated constructor stub
	}

	public void createContents(Panel mainPanel) {
		this.setTitle("Pantalla de administracion de cuentas");
		mainPanel.setLayout(new VerticalLayout());

		
		new Button(mainPanel).setCaption("Consultar Cuenta").onClick(
				this::consultarCuenta);
		new Button(mainPanel).setCaption("Ingresar indicadores").onClick(
				this::ingresarIndicadores);
		

	}

	public void consultarCuenta() {
		new ConsultarValorCuenta(this).open();
	}
	public void ingresarIndicadores() {
		/*new IndicadoresView(this).open();*/
	}

	

	@Override
	protected void addActions(Panel arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void createFormPanel(Panel arg0) {
		// TODO Auto-generated method stub

	}

}
