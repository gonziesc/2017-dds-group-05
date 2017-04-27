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

import model.CuentasService;
import viewmodel.CargarCuentaViewModel;

public class StartWindow extends SimpleWindow<CargarCuentaViewModel> {

	public StartWindow(WindowOwner parent) {
		super(parent, new CargarCuentaViewModel());
		// TODO Auto-generated constructor stub
	}

	public void createContents(Panel mainPanel) {
		this.setTitle("Pantalla de administracion de cuentas");
		mainPanel.setLayout(new VerticalLayout());

		new Button(mainPanel).setCaption("Cargar cuenta").onClick(
				this::cargarCuenta);

		new Button(mainPanel).setCaption("Consultar Cuenta").onClick(
				this::consultarCuenta);

	}

	public void consultarCuenta() {
		Dialog<?> dialog = new ConsultarValorCuenta(this);
		dialog.open();
		dialog.onAccept(() -> {
		});
	}

	public void cargarCuenta() {
		Dialog<?> dialog = new CargarCuentaView(this);
		dialog.open();
		dialog.onAccept(() -> {
		});
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
