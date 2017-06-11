package view;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import builder.BuilderIndicador;

import model.Indicador;
import viewmodel.Parametro2ViewModel;
import viewmodel.Parametro3ViewModel;

@SuppressWarnings("serial")
public class Parametro3View extends Window<Parametro3ViewModel> {
	public Parametro3View(WindowOwner owner,BuilderIndicador builder) {

		super(owner, new Parametro3ViewModel(builder));
		this.getModelObject().obtenerIndicadores();
		this.getModelObject().obtenerCuentas();
	}
	
	public void createContents(Panel mainPanel) {
		this.setTitle("Ingreso de indicadores");
		mainPanel.setLayout(new VerticalLayout());
		
		Selector<Indicador> selectorIndicadores = new Selector<Indicador>(mainPanel).allowNull(true);
		selectorIndicadores.bindItemsToProperty("indicadores").adaptWith(Indicador.class, "nombre");
		selectorIndicadores.bindValueToProperty("tercerIndicador");//.notNull();
		
		new Button(mainPanel).setCaption("Ingresar tercer parametro").onClick(this::ingresar);
		
	}
	
	public void ingresar(){
		this.getModelObject().ingresarParametro3();
		this.getModelObject().crearIndicador();
		this.close();
	}
	
	
}
