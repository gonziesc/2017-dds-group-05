package view;

import java.io.IOException;

import org.uqbar.arena.layout.ColumnLayout;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import model.Cuenta;
import viewmodel.CargarCuentaViewModel;

@SuppressWarnings("serial")
public class CargarCuentaView extends Dialog<Cuenta> {

	public CargarCuentaView(WindowOwner owner) {
		super(owner, new Cuenta());
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(1));

		this.setTitle("Carga de datos de la cuenta");

		new Label(form).setText("Nombre de cuenta");
		new TextBox(form).bindValueToProperty("nombre_cuenta");

		new Label(form).setText("Numero de cuenta");
		new TextBox(form).setWidth(45).bindValueToProperty("numero_cuenta");

		new Label(form).setText("Ano");
		new TextBox(form).setWidth(45).bindValueToProperty("anio_cuenta");

		new Label(form).setText("Ganancia");
		new TextBox(form).setWidth(45).bindValueToProperty("ganancia");

		new Label(form).setText("Ganancia neta");
		new TextBox(form).setWidth(45).bindValueToProperty("gananciaNeta");

		new Label(form).setText("Intereses");
		new TextBox(form).setWidth(45).bindValueToProperty("intereses");

		new Label(form).setText("Impuestos");
		new TextBox(form).setWidth(45).bindValueToProperty("impuestos");

		new Label(form).setText("Despreciacion");
		new TextBox(form).setWidth(45).bindValueToProperty("depreciacion");

		new Label(form).setText("Amortizacion");
		new TextBox(form).setWidth(45).bindValueToProperty("amortizacion");

		new Label(form).setText("Perdida");
		new TextBox(form).setWidth(45).bindValueToProperty("perdida");

		new Button(form).setCaption("Cargar datos cuenta").onClick(() -> {
		
				cargarDatos();
			
		});
	}

	public void cargarDatos() throws IOException {
		getModelObject().crearCuenta();
		this.close();
	}
}