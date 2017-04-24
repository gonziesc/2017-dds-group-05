package view;
import org.uqbar.arena.layout.ColumnLayout;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import viewmodel.CargarCuentaViewModel;


@SuppressWarnings("serial")
public class CargarCuentaView extends Dialog<CargarCuentaViewModel> {
	
	public CargarCuentaView(WindowOwner owner) {
		super(owner, new CargarCuentaViewModel());
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(1));
		
		this.setTitle("Carga de datos de la cuenta");
		
		new Label(form).setText("Nombre de cuenta");
		//new TextBox(form).bindValueToProperty("...");
		
		new Label(form).setText("Numero de cuenta");
		//new TextBox(form).bindValueToProperty("...");
	
		new Label(form).setText("Año");
		//new TextBox(form).bindValueToProperty("...");

		new Label(form).setText("Ganancia");
		//new TextBox(form).bindValueToProperty("...");
		
		new Label(form).setText("Ganancia neta");
		//new TextBox(form).bindValueToProperty("...");
		
		new Label(form).setText("Intereses");
		//new TextBox(form).bindValueToProperty("...");
		
		new Label(form).setText("Impuestos");
		//new TextBox(form).bindValueToProperty("...");
		
		new Label(form).setText("Despreciacion");
		//new TextBox(form).bindValueToProperty("...");
		
		new Label(form).setText("Amortizacion");
		//new TextBox(form).bindValueToProperty("...");
		
		new Label(form).setText("Perdida");
		//new TextBox(form).bindValueToProperty("...");
		
		
		new Button(form).setCaption("Cargar datos cuenta").onClick(this::actualizarDatos);
	}
	public void actualizarDatos(){
		//getModelObject().modificarDatos(getModelObject());
		this.close();
	}
}