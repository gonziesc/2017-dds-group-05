package view;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import model.Comparador;
import model.Indicador;
import viewmodel.IngresarMetodologiaViewModel;

@SuppressWarnings("serial")
public class IngresarMetodologiaView extends Dialog<IngresarMetodologiaViewModel>{

	public IngresarMetodologiaView(WindowOwner owner) {
		super(owner, new IngresarMetodologiaViewModel());
		this.getModelObject().obtenerIndicadores();
		this.getModelObject().obtenerComparadores();
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Ingreso de metodologias");
		
		new Label(mainPanel).setText("Ingresar Indicador de la metodologia");
		
		Selector<Indicador> selectorIndicadores = new Selector<Indicador>(mainPanel);
		selectorIndicadores.bindItemsToProperty("indicadores").adaptWith(Indicador.class, "nombre");
		selectorIndicadores.bindValueToProperty("indicadorSeleccionado");
		
		new Label(mainPanel).setText("Ingresar comparador");
		
		Selector<Comparador> selectorComparadores = new Selector<Comparador>(mainPanel);
		selectorComparadores.bindItemsToProperty("comparadores").adaptWith(Comparador.class, "nombreComparador");
		selectorComparadores.bindValueToProperty("comparadorSeleccionado");
		
		new Button(mainPanel).setCaption("Ingresar metodologia").onClick(this::ingresarMetodologia);
		
	}
	public void ingresarMetodologia(){
		this.getModelObject().ingresarMetodologia();
		this.close();
	}
}
