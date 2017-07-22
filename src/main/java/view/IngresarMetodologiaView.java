package view;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.CheckBox;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import builder.BuilderMetodologia;
import model.Comparador;
import model.Indicador;
import viewmodel.IngresarMetodologiaViewModel;

@SuppressWarnings("serial")
public class IngresarMetodologiaView extends Dialog<IngresarMetodologiaViewModel>{

	public IngresarMetodologiaView(WindowOwner owner, BuilderMetodologia builder) {
		super(owner, new IngresarMetodologiaViewModel(builder));
		this.getModelObject().obtenerIndicadores();
		this.getModelObject().obtenerComparadores();
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Ingreso de metodologias");
		
		new Label(mainPanel).setText("Ingresar nombre de la metodologia");
		new TextBox(mainPanel).bindValueToProperty("nombreMetodologia");
		
		new Label(mainPanel).setText("Ingresar Indicador de la metodologia");
		
		Selector<Indicador> selectorIndicadores = new Selector<Indicador>(mainPanel);
		selectorIndicadores.bindItemsToProperty("indicadores").adaptWith(Indicador.class, "nombre");
		selectorIndicadores.bindValueToProperty("indicadorSeleccionado");
		
		new Label(mainPanel).setText("Indique que tipo de comparador");
		
		new Label(mainPanel).setText("Filtrable");
		new CheckBox(mainPanel).bindValueToProperty("esFiltrable");
		new Label(mainPanel).setText("Ordenable");
		new CheckBox(mainPanel).bindValueToProperty("esOrdenable");
		
		new Label(mainPanel).setText("Ingresar comparador");
		
		Selector<Comparador> selectorComparadores = new Selector<Comparador>(mainPanel);
		selectorComparadores.bindItemsToProperty("comparadores").adaptWith(Comparador.class, "nombreComparador");
		selectorComparadores.bindValueToProperty("comparadorSeleccionado");
		
		new Button(mainPanel).setCaption("Ingresar otro comparador").onClick(this::ingresarComparador);
		new Button(mainPanel).setCaption("Ingresar metodologia").onClick(this::ingresarMetodologia);
		
	}
	public void ingresarComparador(){
		this.getModelObject().validarNombre();
		this.getModelObject().setearMetodologia();
		BuilderMetodologia builder = this.getModelObject().getBuilderMetodologia();
		this.close();
		new IngresarComparadoresView(this, builder).open();
	}
	
	public void ingresarMetodologia(){
		this.getModelObject().validarNombre();
		this.getModelObject().validarIndicadorSeleccionado();
		this.getModelObject().validarComparadorSeleccionado();
		this.getModelObject().ingresarMetodologia();
		this.close();
	}


}
