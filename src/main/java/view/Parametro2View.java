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
import org.uqbar.lacar.ui.model.Action;

import model.Cuenta;
import model.Indicador;
import model.Parametro;
import viewmodel.ConsultarValorCuentaViewModel;
import viewmodel.IndicadorViewModel;

@SuppressWarnings("serial")
public class Parametro2View extends Window<IndicadorViewModel> {
	public Parametro2View(WindowOwner owner) {

		super(owner, new IndicadorViewModel());
		this.getModelObject().obtenerIndicadores();
		this.getModelObject().obtenerCuentas();
	}
	
	public void createContents(Panel mainPanel) {
		this.setTitle("Ingreso de indicadores");
		mainPanel.setLayout(new VerticalLayout());
		
		Selector<Indicador> selectorIndicadores = new Selector<Indicador>(mainPanel).allowNull(true);
		selectorIndicadores.bindItemsToProperty("indicadores").adaptWith(Indicador.class, "nombre");
		selectorIndicadores.bindValueToProperty("indicadorSeleccionado");
		
		new Button(mainPanel).setCaption("Crear indicador").onClick(this::ingresar);
		
	}
	
	public void ingresar(){
		this.getModelObject().crearIndicador();
	}
}
	