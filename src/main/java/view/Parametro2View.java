package view;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import builder.BuilderIndicador;
import model.Cuenta;
import model.Indicador;
import viewmodel.Parametro2ViewModel;

@SuppressWarnings("serial")
public class Parametro2View extends Window<Parametro2ViewModel> {
	public Parametro2View(WindowOwner owner,BuilderIndicador builder) {

		super(owner, new Parametro2ViewModel(builder));
		this.getModelObject().obtenerIndicadores();
		this.getModelObject().obtenerCuentas();
	}
	
	public void createContents(Panel mainPanel) {
		this.setTitle("Ingreso de indicadores");
		mainPanel.setLayout(new VerticalLayout());
		
		new NumericField(mainPanel).bindValueToProperty("valorParametroConstante");
		
		espacio(mainPanel);
		
		Selector<Indicador> selectorIndicadores = new Selector<Indicador>(mainPanel).allowNull(true);
		selectorIndicadores.bindItemsToProperty("indicadores").adaptWith(Indicador.class, "nombre");
		selectorIndicadores.bindValueToProperty("segundoIndicador");//.notNull();
		
		espacio(mainPanel);
		
		Selector<Cuenta> selectorCuentas = new Selector<Cuenta>(mainPanel);
		selectorCuentas.bindItemsToProperty("cuentas").adaptWith(Cuenta.class, "nombreCuenta");
		selectorCuentas.bindValueToProperty("cuentaSeleccionada");
		
		espacio(mainPanel);
		
		new Button(mainPanel).setCaption("Ingresar segundo parametro").onClick(this::ingresar);
		new Button(mainPanel).setCaption("Ingresar indicador").onClick(this::ingresarIndicador);
		
	}
	public void ingresarIndicador(){
		this.getModelObject().ingresarIndicador();
		this.close();
	}
	public void ingresar(){
		this.getModelObject().ingresarParametro2();
		BuilderIndicador builder = this.getModelObject().getBuilderIndicador();
		this.close();
		new Operador2View(this, builder).open();
	}
	public void espacio(Panel mainPanel){
		new Label(mainPanel);
	}
}