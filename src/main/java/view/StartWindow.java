package view;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import builder.BuilderIndicador;
import viewmodel.StartWindowViewModel;

@SuppressWarnings("serial")
public class StartWindow extends SimpleWindow<StartWindowViewModel> {

	public StartWindow(WindowOwner parent) {
		super(parent, new StartWindowViewModel());
		// TODO Auto-generated constructor stub
	}

	@Override
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
		BuilderIndicador builder = new BuilderIndicador();
		new Parametro1View(this,builder, null).open();
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
