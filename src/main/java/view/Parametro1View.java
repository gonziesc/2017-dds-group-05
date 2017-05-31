
package view;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import builder.BuilderIndicador;
import model.Cuenta;
import model.Indicador;
import model.Parametro;
import viewmodel.Parametro1ViewModel;

@SuppressWarnings("serial")
public class Parametro1View extends Window<Parametro1ViewModel> {
	public Parametro1View(WindowOwner owner) {

		super(owner, new Parametro1ViewModel());
		this.getModelObject().obtenerIndicadores();
	}
	
	public void createContents(Panel mainPanel) {
		this.setTitle("Ingreso de indicadores");
		mainPanel.setLayout(new VerticalLayout());
		
		Selector<Indicador> selectorIndicadores = new Selector<Indicador>(mainPanel);//.onSelection();
		selectorIndicadores.bindItemsToProperty("indicadores").adaptWith(Indicador.class, "nombre");
		selectorIndicadores.bindValueToProperty("indicadorSeleccionado");//.notNull();
		
		espacio(mainPanel);
		
		Selector<Cuenta> selectorCuentas = new Selector<Cuenta>(mainPanel);
		selectorCuentas.bindItemsToProperty("cuentas").adaptWith(Cuenta.class, "nombreCuenta");
		selectorCuentas.bindValueToProperty("cuentaSeleccionada");
		
		espacio(mainPanel);
		
		new Button(mainPanel).setCaption("Ingresar primer parametro").onClick(this::ingresar);
		new Button(mainPanel).setCaption("Ingresar indicador").onClick(this::ingresarIndicador);	
	}

	public void ingresarIndicador(){
		this.getModelObject().ingresarIndicador();
		this.close();
	}
	
	public void ingresar(){
		this.getModelObject().ingresarParametro1();
		BuilderIndicador builder = this.getModelObject().getBuilderIndicador();
		this.close();
		new Operador1View(this,builder).open();
	}

	public void espacio(Panel mainPanel){
		new Label(mainPanel);
	}
}

