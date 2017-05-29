package view;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import model.Cuenta;
import model.Indicador;
import viewmodel.ConsultarValorCuentaViewModel;
import viewmodel.IndicadorViewModel;

@SuppressWarnings("serial")
public class IndicadoresView extends Window<IndicadorViewModel> {
	public IndicadoresView(WindowOwner owner) {
		super(owner, new IndicadorViewModel());
		this.getModelObject().obtenerIndicadores();
		this.getModelObject().obtenerCuentas();
	}
	
	public void createContents(Panel mainPanel) {
		this.setTitle("Ingreso de indicadores");
		mainPanel.setLayout(new VerticalLayout());
		
		Selector<Indicador> selectorIndicadores = new Selector<Indicador>(mainPanel).allowNull(true);
		selectorIndicadores.bindItemsToProperty("indicadores");
		selectorIndicadores.bindValueToProperty("indicadorSeleccionado");
		
		Selector<Cuenta> selectorCuentas = new Selector<Cuenta>(mainPanel);
		selectorCuentas.bindItemsToProperty("cuentas");//.adaptWith(Cuenta.class, "nombreCuenta");
		selectorCuentas.bindValueToProperty("cuentaSeleccionada");
		
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
	
