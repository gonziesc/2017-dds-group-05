package view;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.utils.Observable;

import builder.BuilderIndicador;

import model.Indicador;
import viewmodel.Parametro2ViewModel;

public class Parametro2View extends Window<Parametro2ViewModel> {
	public Parametro2View(WindowOwner owner,BuilderIndicador builder) {

		super(owner, new Parametro2ViewModel(builder));
		this.getModelObject().obtenerIndicadores();
		this.getModelObject().obtenerCuentas();
	}
	
	public void createContents(Panel mainPanel) {
		this.setTitle("Ingreso de indicadores");
		mainPanel.setLayout(new VerticalLayout());
		
		Selector<Indicador> selectorIndicadores = new Selector<Indicador>(mainPanel).allowNull(true);
		selectorIndicadores.bindItemsToProperty("indicadores").adaptWith(Indicador.class, "nombre");
		selectorIndicadores.bindValueToProperty("segundoIndicador");
		
		new Button(mainPanel).setCaption("Ingresar segundo parametro").onClick(this::ingresar);
		
	}
	
	public void ingresar(){
		this.getModelObject().ingresarParametro2();
		BuilderIndicador builder = this.getModelObject().getBuilderIndicador();
		this.close();
		new Operador2View(this, builder).open();
	}
	
	
}